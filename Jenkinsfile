pipeline{
    agent any
    stages{
        stage("Checkout"){
            steps{
                git url: "https://github.com/arpanelfranklin/Air-Pollution-Analytic-Plateform.git",
                branch: "main"
            }
        }
        
        stage("Building backend"){
            steps{
                echo "building backend"
            }
        }
        stage("Building ETL-pipeline"){
            steps{
                echo "building etl-pipeline"
            }
        }
        stage("SonarQube analysis"){
            steps{
                echo "SonarQube analysis"
            }
        }
        stage("Trivy file system scan"){
            steps{
                echo "Trivy file system scan"
            }
        }
        stage("Docker build backend"){
            steps{
                sh "docker build -t apap-backend ./backend"
            }
        }
        stage("Docker build etl-pipeline"){
            steps{
                echo "Docker build etl piepline"
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
        
    }
}