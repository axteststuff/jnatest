two: native-two java

one: native-one java

native-one:
	make -C src/c one install

native-two:
	make -C src/c two install

java:
	mvn clean install assembly:single 

test:
	(cd target; java -jar app-1.0-SNAPSHOT-jar-with-dependencies.jar )
#	(cd target; java -Djava.library.path=$$(pwd)/../linux-x86-64 -jar app-1.0-SNAPSHOT-jar-with-dependencies.jar )

clean:
	mvn clean
	make -C src/c clean
