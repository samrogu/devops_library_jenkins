def call(int buildNumber) {
  pipeline {
    agent none
    stages {
      stage('Build') {
        agent {
          label "maven-exec"
        }
        steps{
          checkout scm
          container('maven') {
            sh 'mvn clean install'
          }
        }
      }
      stage('Test') {
        steps{
          echo "The test app"
        }
      }
      stage('Upload NexusIQ'){
        steps{
          echo "The upload app nexusIQ"
        }
      }
      stage('Upload SonarQube'){
        steps{
          echo "The upload app Sonar"
        }
      }
      stage('Create Image'){
        steps{
          echo "Create Image"
        }
      }
      stage('Deploy'){
        steps{
          echo "Deploy service"
        }
      }
    }
  }
}
