pipeline {
    agent any

    tools {
        maven 'Maven 3'
    }
    parameters {
        string(name: 'TEST_GROUP', defaultValue: 'smoke', description: 'TestNG group to run')
    }

    stages{
        stage('Build & Test') {
            steps {
                sh "mvn clean test -Dgroups=${params.TEST_GROUP}"
            }
        }
    }
}