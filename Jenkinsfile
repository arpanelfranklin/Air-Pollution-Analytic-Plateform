pipeline{
    agent any
    stages{
        stage("Checkout"){
            steps{
                git url: "https://github.com/arpanelfranklin/Air-Pollution-Analytic-Plateform.git",
                branch: "main"
            }
        }
        stage("Read version"){
            steps{
                script {
                    env.VERSION = readFile("VERSION").trim()
                    env.GIT_SHA = sh(
                                script: 'git rev-parse --short HEAD',
                                returnStdout: true
                            ).trim()
                }
            }
        }
        
        stage("Print Version"){
            steps{
                echo "Version : ${env.VERSION}"
                echo "Git-sha : ${GIT_SHA}"
            }
        }
        stage("Building backend"){
            steps{
                dir("backend"){
                    sh "mvn clean package -DskipTests"
                }
            }
        }
        stage("Building ETL-pipeline"){
            steps{
                dir("etl-pipeline"){
                    sh "mvn clean package -DskipTests"
                }
            }
        }
        stage("SonarQube analysis"){
            steps{
                dir("backend"){
                    sh '''
                    mvn clean verify sonar:sonar \
                    -Dsonar.projectKey=apap-backend \
                    -Dsonar.host.url=$SONAR_HOST_URL \
                    -Dsonar.token=$SONAR_TOKEN
                     '''
                }
            }
        }
        stage("Trivy file system scan for backend"){
            steps{
                sh '''
                    trivy fs \
                    --severity HIGH,CRITICAL \
                    --exit-code 1 \
                    ./backend
                '''
            }
        }

        stage("Trivy file system scan for etl-pipeline"){
            steps{
                sh '''
                    trivy fs \
                    --severity HIGH,CRITICAL \
                    --exit-code 1 \
                    ./etl-pipeline
                '''
            }
        }
        stage("Docker build backend"){
            steps{
                sh "docker build -t arpanel/apap-backend:v${env.VERSION}-${env.GIT_SHA} ./backend"
            }
        }
        stage("Docker build etl-pipeline"){
            steps{
                sh "docker build -t arpanel/apap-etl-pipeline:v${env.VERSION}-${env.GIT_SHA} ./etl-pipeline"
            }
        }

        stage("Trivy Image scan of backend"){
            steps{
                sh '''
                    trivy image \
                    --severity HIGH,CRITICAL \
                    --exit-code 1 \
                    arpanel/apap-backend:v{env.VERSION}-${env.GIT_SHA}
                '''
            }
        }
        stage("Trivy Image scan for etl-pipeline"){
            steps{
                sh ''' 
                    trivy image \
                    --severity HIGH,CRITICAL \
                    --exit-code 1\
                    arpanel/apap-etl-pipeline:v{env.VERSION}-${env.GIT_SHA}
                '''
            }
        }
        stage("Docker push"){
           steps{
               echo "Docker push"
           }
        }
        stage("Update k8s menifest"){
            steps{
                echo "update menifest"
            }
        }
        stage ("Push updated k8s to github"){
            steps{
                echo "Git pushed"
            }
        }
        
    }
}