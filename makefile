JFLAGS = -d bin -sourcepath src
JUNIT5_JAR = lib/junit-platform-console-standalone-1.8.2.jar 
JUNIT5_RUNNER = org.junit.platform.console.ConsoleLauncher
CKSTYLE_COMMAND =  -jar lib/checkstyle-10.5.0-all.jar 

default: 
	@echo "usage: make target"
	@echo "4 available targets: clean - removes .class files"
	@echo "____________________ compile - builds codebase"
	@echo "____________________ test - runs JUnit5 tests"
	@echo "____________________ demo - runs demo"
	@echo "____________________ check - runs checkstyle"

compile: $(JUNIT5_JAR)
	javac $(JFLAGS) -cp .:$(JUNIT5_JAR) src/**/**/*.java

test: $(JUNIT5_JAR)
	java -cp bin:$(JUNIT5_JAR) $(JUNIT5_RUNNER) --scan-class-path 

demo: bin/client/Demo.class
	java -cp .:bin client.Demo

check: resources/styles.xml 
	java11 $(CKSTYLE_COMMAND) -c ./resources/styles.xml src/*/*/*.java

clean:
	rm -f ./bin/**/*.class