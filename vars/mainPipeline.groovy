def call(int buildNumber) {
  if (buildNumber % 2 == 0) {
    pipeline {
      agent none
      stages {
	agent {
	      label "master"
	  }
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
      agent none
      stages {
        stage('Odd Stage') {
	agent {
	      label "master"
	  }
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
