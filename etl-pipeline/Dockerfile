FROM maven:3.9-eclipse-temurin-17 AS builder
# Working Directory
WORKDIR /etlPipeline
#COPY DEPENDENCY
COPY pom.xml .
# INSTALL DEPENDENCY
RUN mvn dependency:go-offline
#COPY SOURCE CODE
COPY src ./src
#BUILD JAR
RUN mvn clean package -DskipTests

# ======= STAGE 2 =======
FROM eclipse-temurin:17-jre
#WORKING DIRECTORY
WORKDIR /etlPipeline
#COPY DEPENDENCY FROM BUILDER
COPY --from=builder /etlPipeline/target/*.jar etlPipeline.jar

# Adding Non root user
RUN groupadd -r appgroup && \
    useradd -r -g appgroup appuser
    
# Switch to Non root user 
USER appuser

#ENTRYPOINT
ENTRYPOINT ["java","-jar","etlPipeline.jar"]