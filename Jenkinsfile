pipeline {
    agent any

    tools {
        nodejs 'NodeJS'
    }

    environment {
        APPIUM_PORT = '4723'
    }

    stages {

        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Install Dependencies') {
            steps {
                sh '''
                npm install -g appium
                npm install
                '''
            }
        }

        stage('Start Appium Server') {
            steps {
                sh '''
                appium -p $APPIUM_PORT > appium.log 2>&1 &
                sleep 10
                '''
            }
        }

        stage('Run Appium Tests') {
            steps {
                sh '''
                mvn clean test
                '''
            }
        }
    }

    post {
        always {
            sh 'pkill -f appium || true'
            archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', allowEmptyArchive: true
        }
    }
}
