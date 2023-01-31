def call(){
 deploy adapters: 
  [tomcat9(credentialsId: 'tomcat',
 
   url: 'http://3.109.183.122:8006')],
   contextPath: 'demo',
   onFailure: false,
   war: '**/target/*.war' 

}
