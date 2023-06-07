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
                    docker.withRegistry('https://registry.hub.docker.com', 'dckr_pat_Dj96TFmDxIOj0MjCknKXcLKFFjk') {
                        docker.image("chisiuyiu/springbootbackend:${TAG}").push()
                        docker.image("chisiuyiu/springbootbackend:${TAG}").push("latest")
                    }
                }
            }
        }
        stage('Deploy'){
            steps {
                sh "docker stop hello-world | true"
                sh "docker rm hello-world | true"
                sh "docker run --name springbootbackend -d -p 8582:8582 chisiuyiu/springbootbackend:${TAG}"
            }
        }
    }
}
