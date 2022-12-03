pipeline {
    agent any
    stages{
        stage('printing working directory'){
            steps{
                sh 'pwd'
            }
        }
    stage ('clone repo'){
        steps {
            withCredentials([usernamePassword(credentialsId: 'shivani_git', passwordVariable: 'password', usernameVariable: 'username')]) {
            echo "repo cloned"
            sh 'ls -ltrh'
    }
    }
    }
    stage ('build dockerfile'){
        steps {
            sh "docker build -t image2 ."
        }
    }
    stage ('docker images'){
    steps {
        sh "docker images"
    }
}
    stage ('docker run the image'){
    steps {
        sh "docker run -d -p 8080:8086 image2 "
    }
}
    }
}
