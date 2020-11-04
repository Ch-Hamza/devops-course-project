JAR_PATH = ./target
PORT = 8080

init:
	sudo apt update -y
	sudo apt install maven -y

build: init
	mvn clean install

start: build
	kill $$(lsof -t -i:${PORT}) | true
	java -jar ${JAR_PATH}/mini-project-0.0.1-SNAPSHOT.jar &

test: init
	mvn clean test

clean:
	rm - rf ${JAR_PATH}
