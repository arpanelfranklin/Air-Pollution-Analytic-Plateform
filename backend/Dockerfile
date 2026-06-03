FROM  maven:3.9-eclipse-temurin-17  AS builder
# Create working directory
WORKDIR /backend
#Copy the dependency file
COPY pom.xml .
#Install dependency
RUN mvn dependency:go-offline
#Copy source code
COPY src ./src
#Build jar
RUN mvn clean package -DskipTests

# ===== STAGE 2 =====
FROM eclipse-temurin:17-jre
#workig directory
WORKDIR /backend
#Copy jar from builder
COPY --from=builder /backend/target/*.jar backend.jar

#EXPOSE PORT
EXPOSE 8080

#RUN
ENTRYPOINT ["java","-jar","backend.jar"]



