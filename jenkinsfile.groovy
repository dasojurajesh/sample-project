pipeline {
    agent any

    tools {
        maven "maven"
        jdk "jdk"
    }

    stages {
        stage('Initialize'){
            steps{
                echo "my-app/jenkinsfile"
                echo "M2_HOME = /opt/maven"
            }
        }
        stage('Build') {
            steps {
                dir("/var/lib/jenkins/workspace/pipeline-project/my-app/") {
                sh 'mvn -B -DskipTests clean package'
                }
            
            }
        }
     }
    post {
       always {
          junit(
        allowEmptyResults: true,
        testResults: '*/test-reports/.xml'
      )
      }
   } 
}


