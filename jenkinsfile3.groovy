
pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                sh './gradlew assemble'
            }
        }
        stage('deploy') {
            steps {
                sh './gradlew test'
            }
        }
    }
}
