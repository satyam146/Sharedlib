def buildFunction(){
//     stage('Build') {
//         steps {         
            sh '''
            mvn package
            '''
//         }
//     }
}
            
//          post {
//               success {
//                  junit '**/target/surefire-reports/TEST-*.xml'
//                  archiveArtifacts 'target/*.jar'
//                 // echo 'running hello Job'
//                 // build job: 'hello' "Trigerring another job post build"
//                 }
//             }
//         }

  
