## <center>dubbo consumer客户端</center>

### Build and run

+ Prerequisites

	- Java 7
	- Maven > 3.0

+ From terminal

	`Go on the project's root folder`, then type:

    	$ mvn spring-boot:run

	`You can also run springboot like this`
	
		$ mvn package
		$ java -jar target/XXXX-0.0.1-SNAPSHOT
		

### dubbo

+ zookeeper
	- sudo ./zookeeper/bin/zkServer.sh start
+ provider
	- mvn package
	- java -jar XX.jar
+ consumer
	- mvn package
	- java -jar XX.jar
	- http://127.0.0.1:18004/dubbo