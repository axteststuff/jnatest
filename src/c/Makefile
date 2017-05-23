arch=$(shell uname | tr '[:upper:]' '[:lower:]')-$(shell uname -p | tr '_' '-')
all:
	gcc -c myalloc.c -fPIC
	gcc -shared -fPIC -o libmyalloc.so myalloc.o
	gcc -c test.c -fPIC
	gcc -shared -fPIC -o libtest.so test.o # -L. -lmyalloc

install: all
	mkdir -p ../../target/${arch}
	cp -v *.so ../../target/${arch}

clean:
	rm -f *.so *.o ../../target/${arch}/*.so
	rmdir ../../target/${arch}
