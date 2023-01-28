def call(){
  rtUpload (
                    // Obtain an Artifactory server instance, defined in Jenkins --> Manage Jenkins --> Configure System:
                    serverId: SERVER_ID,
                    spec: """{
                            "files": [
                                    {
                                        "pattern": "/var/lib/jenkins/workspace/CI-CD/target/*.war",
                                        "target": "demo/"
                                      
                                    }
                                ]
                            }""",
    buildName: '${env.BUILD_NUMBER}',
    buildNumber: '${env.BUILD_TIMESTAMP}'
                  )
}
