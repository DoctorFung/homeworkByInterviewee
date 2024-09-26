FROM 	openjdk:17-jdk-slim


ADD 	${project.build.finalName}.jar 	/app/

ADD	conf/* 		/app/conf/

EXPOSE ${server.port} 8080


WORKDIR /app
COPY target/incident-0.0.1.SNAPSHOT.jar incident-0.0.1.SNAPSHOT.jar

CMD 	["java", "-jar" , "app.jar"]