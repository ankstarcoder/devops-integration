pipeline{
    agent any
    tools{
        maven 'Maven3'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: '764417ee-f0d9-4ec4-8336-f2e378d6dfca', url: 'https://github.com/ankstarcoder/devops-integration']])
                bat 'mvn clean install'
            }
        }
        stage('Build Docker Image'){
    steps{
        bat 'docker build -t ankstarcoder/app:v1 .'
    }
}
        stage('Push Docker Image to Docker Hub'){
    steps{
        withCredentials([
            usernamePassword(
                credentialsId: 'dockerhub-creds',
                usernameVariable: 'DOCKER_USER',
                passwordVariable: 'DOCKER_PASS'
            )
        ]) {
            bat 'docker login -u %DOCKER_USER% -p %DOCKER_PASS%'
            bat 'docker push ankstarcoder/app:v1'
        }
    }
}
    }
}