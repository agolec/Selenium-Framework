pipeline {
    agent any

    parameters {
        string(name: 'TEST_GROUP', defaultValue: 'smoke', description: 'TestNG group to run')
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/agolec/Selenium-Framework.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh "mvn clean test -Dgroups=${params.TEST_GROUP}"
            }
        }
    }
}