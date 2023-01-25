def call(){
  echo "SCM Checkout"
git([branches: [
        [name: '*/master'], 
    credentialsId: githublogin,
     url: git@github.com:satyam146/Test-jenkins.git])
}
