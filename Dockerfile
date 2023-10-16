FROM tomcat:10-jdk11
ADD target/astonTask_2-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/astonTask_2-1.0-SNAPSHOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]