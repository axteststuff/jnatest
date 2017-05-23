all: native java

native:
	make -C src/c all install

java:
	mvn clean install assembly:single 

test:
	(cd target; java -Djava.library.path=$$(pwd)/linux-x86-64 -jar app-1.0-SNAPSHOT-jar-with-dependencies.jar )

clean:
	mvn clean
	make -C src/c clean
