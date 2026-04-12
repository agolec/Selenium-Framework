pipeline {
    agent any

    parameters {
        string(name: 'TEST_GROUP', defaultValue: 'smoke', description: 'TestNG group to run')
    }

        stage('Build & Test') {
            steps {
                sh "mvn clean test -Dgroups=${params.TEST_GROUP}"
            }
        }
    }
}