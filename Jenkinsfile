pipeline {
    agent any
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Thrishank99/SpringApp.git']]])
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
                  withCredentials([usernamePassword(credentialsId: 'srinudockerhub', passwordVariable: 'dockerhubnew', usernameVariable: 'dockerhubnew')]) {
                  bat "docker login -u ${env.thrishank99} -p ${env.dockerhubnew}"

}
                  bat 'docker push thrishank99/spring-app-development'
                }
            }
        }  
   }
}