def call(){
                 sh '''${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=Demo_Jenkins \
                   -Dsonar.projectName=Demo_Jenkins \
                   -Dsonar.projectVersion=1.0 \
                   -Dsonar.sources=src/ \
                   -Dsonar.java.binaries=/var/lib/jenkins/workspace/Test/target/test-classes/com/example/demo/ \
                   -Dsonar.junit.reportsPath=/var/lib/jenkins/workspace/Test/target/surefire-reports/ '''
}
