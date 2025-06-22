FROM maven:3.9.6-eclipse-temurin-21

WORKDIR /home

COPY . .

RUN apt-get update && apt-get install -y netcat \
  && chmod +x wait-for-mysql.sh \
  && mvn clean package -DskipTests

EXPOSE 8080

ENTRYPOINT ["sh", "wait-for-mysql.sh"]
