def call(int buildNumber) {
  if (buildNumber % 2 == 0) {
    pipeline {
      agent none
      stages {
	agent any;
        stage('Even Stage') {
          steps {
            echo "The build number is even"
          }
        }
        stage('Maven Event Stage') {
	agent {
	      label "maven-exec"
	  }
          steps{
				container('maven') {
					sh 'mvn --version'
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
		agent {
	      label "maven-exec"
	  }
			steps{
				container('maven') {
					sh 'mvn -B'
				}
			}          
        }
      }
    }
  }
}
