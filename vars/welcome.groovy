pipeline {
    agent any     tools {
        maven "MAVEN3"
    }
    environment {
        SONARSERVER = 'sonar'
        SONARSCANNER = 'sonar'
    }     stages {
        stage("Checkout"){
            steps{
                git branch: 'master', credentialsId: 'githublogin', url: 'git@github.com:satyam146/test2.git'
            }
        }
        buildFunction()
        codeAnalysisFunction()
        uploadFunction()
    }
}
 def buildFunction(){
    stage('Build') {
        steps {         
            sh "mvn package"               
        } post {
              success {
                 junit '**/target/surefire-reports/TEST-*.xml'
                 archiveArtifacts 'target/*.jar'
                // echo 'running hello Job'
                // build job: 'hello' "Trigerring another job post build"
                }
            }
        }
} def codeAnalysisFunction(){
    stage('CODE ANALYSIS with SONARQUBE') {
          environment {
             scannerHome = tool "${SONARSCANNER}"
          }           steps {
            withSonarQubeEnv("${SONARSERVER}") {
               sh '''${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=Demo_Jenkins \
                   -Dsonar.projectName=Demo_Jenkins \
                   -Dsonar.projectVersion=1.0 \
                   -Dsonar.sources=src/ \
                   -Dsonar.java.binaries=/var/lib/jenkins/workspace/Test/target/test-classes/com/example/demo/ \
                   -Dsonar.junit.reportsPath=/var/lib/jenkins/workspace/Test/target/surefire-reports/ '''
            } 
          }
        }
} def uploadFunction(){
    stage ('Upload file') {
            steps {
                rtUpload (
                    // Obtain an Artifactory server instance, defined in Jenkins --> Manage Jenkins --> Configure System:
                    serverId: SERVER_ID,
                    spec: """{
                            "files": [
                                    {
                                        "pattern": "/var/lib/jenkins/workspace/Test/target/*.jar",
                                        "target": "result/"
                                    }
                                ]
                            }"""
                  )
              }
          }
}

  
