def call(){
 deploy adapters: 
  [tomcat9(credentialsId: 'tomcat',
 
   url: 'http://192.168.29.127:9090')],
   contextPath: 'test',
   onFailure: false,
   war: '**/target/*.war' 

}
