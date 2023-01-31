def call(){
 sh "mvn clean install package -DskipTests"
    }
def test(){
 
   junit '**/target/surefire-reports/TEST-*.xml'
}
