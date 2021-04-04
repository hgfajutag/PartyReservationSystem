FROM tomcat:8.0-alpine
LABEL maintainer="danyal.javadev@gmail.com"

ADD ./main/webapp /usr/local/tomcat/webapps/ROOT/

EXPOSE 8080
CMD ["catalina.sh", "run"]