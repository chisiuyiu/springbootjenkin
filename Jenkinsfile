pipeline {
    agent any
    tools {
        maven 'maven-3.9.2' 
    }
    environment {
        DATE = new Date().format('yy.M')
        TAG = "${DATE}.${BUILD_NUMBER}"
    }
    stages {
        stage ('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    docker.build("chisiuyiu/springbootbackend:${TAG}")
                }
            }
        }
	    stage('Pushing Docker Image to Dockerhub') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'docker_credential') {
                        docker.image("chisiuyiu/springbootbackend:${TAG}").push()
                        docker.image("chisiuyiu/springbootbackend:${TAG}").push("latest")
                    }
                }
            }
        }
        stage('Deploy'){
            steps {
                sh "docker stop springbootbackend | true"
                sh "docker rm springbootbackend | true"
                sh "docker run --name springbootbackend -d -p 8582:8582 -p 3306:3306 chisiuyiu/springbootbackend:${TAG}"
            }
        }
    }
}
