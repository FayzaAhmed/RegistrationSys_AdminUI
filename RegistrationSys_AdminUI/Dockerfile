#base image
FROM openjdk:8

COPY . /app

WORKDIR /app/src

#compile
RUN javac *.java

ENTRYPOINT ["java", "Main"]

#run
#ENTRYPOINT ["bash"] 


