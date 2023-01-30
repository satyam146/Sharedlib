def call(){
                 sh '''${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=CI_Jenkins \
                   -Dsonar.projectName=CI-CD_Jenkins \
                   -Dsonar.projectVersion=1.0 \
                   -Dsonar.sources=src/ \
                   -Dsonar.java.binaries=/var/lib/jenkins/workspace/CI-CD/target/test-classes/com/example/demo '''
               }
