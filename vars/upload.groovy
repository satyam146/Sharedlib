def call(){
  rtUpload (
                    // Obtain an Artifactory server instance, defined in Jenkins --> Manage Jenkins --> Configure System:
                    serverId: SERVER_ID,
                    spec: """{
                            "files": [
                                    {
                                        "pattern": "/var/lib/jenkins/workspace/Test/target/*.war",
                                        "target": "demo/",
                                        "version": "${env.BUILD_TIMESTAMP}"
                                    }
                                ]
                            }"""
                  )
}
