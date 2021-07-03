def call(int buildNumber) {
  if (buildNumber % 2 == 0) {
    pipeline {
      agent any
      stages {
        stage('Even Stage') {
          steps {
            echo "The build number is even"
          }
        }
        stage('Maven Old Stage') {
          git: 'https://github.com/samrogu/fly-config-server.git'
          container('maven') {
            stage('Build a Maven project') {
              sh 'mvn -B -ntp clean install'
            }
          }
        }
      }
    }
  } else {
    pipeline {
      agent any
      stages {
        stage('Odd Stage') {
          steps {
            echo "The build number is odd"
          }
        }
        stage('Maven Old Stage') {
          git: 'https://github.com/samrogu/fly-config-server.git'
          container('maven') {
            stage('Build a Maven project') {
              sh 'mvn -B -ntp clean install'
            }
          }
        }
      }
    }
  }
}
