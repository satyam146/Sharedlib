def call(){
  echo "SCM Checkout"
  sh `''
  git branch: 'master', credentialsId: 'githublogin', url: 'git@github.com:satyam146/test2.git
  `''
}
