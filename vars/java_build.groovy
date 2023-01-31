def call(){
 deploy adapters: 
  [tomcat9(credentialsId: 'tomcat',
 
   url: 'http://3.109.183.122')],
   contextPath: 'test',
   onFailure: false,
   war: '**/target/*.war' 

}
