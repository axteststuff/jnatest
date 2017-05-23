arch=$(shell uname | tr '[:upper:]' '[:lower:]')-$(shell uname -p | tr '_' '-')
all:
	gcc -c test.c -fPIC
	gcc -shared -fPIC -o libtest.so test.o

install:
	mkdir -p ../../target/${arch}
	cp libtest.so ../../target/${arch}

clean:
	rm -f *.so *.o ../../target/${arch}/*.so
	rmdir ../../target/${arch}