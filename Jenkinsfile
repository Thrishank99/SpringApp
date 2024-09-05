pipeline {
    agent any
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Thrishank99/SpringAppDevelopment.git']]])
                bat 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    bat 'docker build -t  thrishank99/spring-app-development .'
                }
            }
        
        }
        stage('Push image to Hub'){
            steps{
                script{
                  withCredentials([usernamePassword(credentialsId: 'boothub-pwdtest', passwordVariable: 'boothubpwd', usernameVariable: 'boothubpwd')]) {
                  bat "docker login -u ${env. thrishank99} -p ${env.boothubpwd}"

}
                  bat 'docker push  thrishank99/spring-app-development'
                }
            }
        }  
   }
}