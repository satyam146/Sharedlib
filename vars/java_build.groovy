def call(){
 deploy adapters: 
  [tomcat9(credentialsId: 'tomcat',
 
   url: 'http://3.108.62.0:8006')],
   contextPath: 'test',
   onFailure: false,
   war: '**/target/*.war' 

}
