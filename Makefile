JAR_PATH = ./target
PORT = 8080
install:
	sudo apt update -y
	sudo apt install maven -y

start: install
	mvn clean install
	kill $$(lsof -t -i:${PORT})
	java -jar ${JAR_PATH}/mini-project-0.0.1-SNAPSHOT.jar &

clean:
	rm - rf ${JAR_PATH}
