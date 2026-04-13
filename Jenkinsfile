pipeline {
    agent any

    tools {
        maven 'Maven 3'
    }
    parameters {
            choice(
                name: 'TEST_GROUP',
                choices: ['smoke', 'regression'],
                description: 'Select which TestNG group to run'
            )
        }

    stages {
            stage('Build & Test') {
                steps {
                    sh """
                    mvn clean test \
                    -Dgroups=${params.TEST_GROUP} \
                    -Dheadless=true \
                    -Dchrome.binary=/usr/bin/chromium-browser
                    """
                }
            }
        }
}