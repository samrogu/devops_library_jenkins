def call(int buildNumber) {
  pipeline {
      agent none
      stages {
        stage('Even Stage') {
	  agent any
          steps {
            echo "The build number is even"
          }
        }
        stage('Maven Event Stage') {
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
      }
    }
}
