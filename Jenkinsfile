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
                 withCredentials([string(credentialsId: 'srinuworld-pwd', variable: 'srinuworld')]) {
                  bat 'docker login -u thrishank99 -p ${srinuworld}'

}
                  bat 'docker push  thrishank99/spring-app-development'
                }
            }
        }  
   }
}

boothub-spring