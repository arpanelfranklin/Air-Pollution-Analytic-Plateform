pipeline{
    agent any
    environment{
        JAVA_HOME = "/usr/lib/jvm/java-21-openjdk-amd64"
    }
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
                echo "Git-sha : ${env.GIT_SHA}"
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
                    mvn sonar:sonar \
                    -Dsonar.projectKey=apap-backend \
                    -Dsonar.host.url=http://100.26.110.241:9000/ \
                    -Dsonar.login=squ_0cddf4b8d859713aaa423313ea169e29ef61fc67
                     '''
                }
            }
        }
        stage("Trivy file system scan for backend"){
            steps{
                sh '''
                    trivy fs \
                    --severity HIGH,CRITICAL \
                    --exit-code 0 \
                    ./backend
                '''
            }
        }

        stage("Trivy file system scan for etl-pipeline"){
            steps{
                sh '''
                    trivy fs \
                    --severity HIGH,CRITICAL \
                    --exit-code 0 \
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
                sh """
                    trivy image \
                    --severity HIGH,CRITICAL \
                    --exit-code 1 \
                    arpanel/apap-backend:v${env.VERSION}-${env.GIT_SHA}
                """
            }
        }
        stage("Trivy Image scan for etl-pipeline"){
            steps{
                sh """
                    trivy image \
                    --severity HIGH,CRITICAL \
                    --exit-code 1 \
                    arpanel/apap-etl-pipeline:v${env.VERSION}-${env.GIT_SHA}
                """
            }
        }
       
        stage("Docker Push of image"){
            withCredentials([usernamePassword(
                credentialsId: "dockerHubCreds",
                passwordVariable: "dockerHubPass"
                usernameVariable: "dockerHubUser"
            )]){
                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                sh "docker push arpanel/apap-backend:v${env.VERSION}-${env.GIT_SHA}"
                sh "docker push arpanel/apap-etl-pipeline:v${env.VERSION}-${env.GIT_SHA}"
            }
        }

        stage("Update k8s menifest files"){
            steps{
                sh """
                    sed -i "s|image: arpanel/apap-backend:.*|image: arpanel/apap-backend:v${VERSION}-${GIT_SHA}|" k8s/backend/deployment.yml \
                    sed -i "s|image: arpanel/apap-etl-pipeline:.*|image: arpanel/apap-etl-pipeline:v${VERSION}-${GIT_SHA}|" k8s/etl/cronjob.yml
                """
                
            }
        }
        stage ("Push updated k8s to github"){
            steps{
                echo "Git pushed"
            }
        }
        
    }
}