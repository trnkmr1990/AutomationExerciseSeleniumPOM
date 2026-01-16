pipeline {
    agent any

	parameters {
        choice(name: 'TEST_GROUP', choices: ['login', 'products', 'smoke', 'all'],
           description: 'Which TestNG group to run')
    }
    tools {
        // Names must match Global Tool Configuration in Jenkins
        jdk 'JDK-21'
        maven 'Maven-3.9'
    }
    environment {
        MAVEN_OPTS = '-Xmx1024m'
    }
    stages {
        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }
        stage('Clean & Compile') {
            steps {
                bat 'mvn clean compile'
            }
        }
        stage('Run Selenium TestNG Suite') {
            steps {
               if(TEST_GROUP == 'all'){
                    bat 'mvn test'
               } else {
                    bat "mvn test -Dgroups=${TEST_GROUP}"
			   }
            }
        }
    }

    post {

        always {
            // Publish TestNG Results in Jenkins
            junit '**/surefire-reports/TEST-*.xml'

            // Archive Extent Report as Jenkins Artifact
            archiveArtifacts artifacts: 'test-output/**', fingerprint: true
        }

        success {
            echo '✅ Selenium Automation Tests Executed Successfully'
        }

        failure {
            echo '❌ Selenium Automation Tests Failed'
        }
    }
}
