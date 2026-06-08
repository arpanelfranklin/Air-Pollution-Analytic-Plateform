pipeline{
    agent: any
    stages{
        stage("checkout"){
            git url: "https://github.com/arpanelfranklin/Air-Pollution-Analytic-Plateform.git", 
            branch: "main"
        }

        stage("build backend"){
            steps{
                echo "Building backend"
            }
        }

        stage("Build ETL-Pipeline"){
            steps{
                echo "Building etl-pipeline"
            }
        }
        stage("unit test"){
            steps{
                echo "unit testing"
            }
        }

        stage("sonarqube analysis"){
            steps{
                echo "sonarqube analysis"
            }
        }
        stage("trivy file system scan"){
            steps{
                echo "trivy file system scan"
            }
        }

        stage("docker build backend"){
            steps{
                echo "Docker buld backend"
            }
        }

        stage("docker build etl pipeline"){
            steps{
                echo "docker build backend"
            }
        }

        stage("trivy scan"){
            steps{
                echo "container security scan"
            }
        }
        stage("docker push"){
            steps{
                echo "docker push"
            }
        }
        stage("update k8s menifest"){
            steps{
                echo "push updated menifest"
            }
        }

    }
    post {
        success{
            echo "build success"
        }

        failure {
            echo "build failed"
        }
    }
}