arch=$(shell uname | tr '[:upper:]' '[:lower:]')-$(shell uname -p | tr '_' '-')
one:
	gcc -c myalloc.c -fPIC
	gcc -c test.c -fPIC
	gcc -shared -fPIC -o libtest.so test.o myalloc.o

two:
	gcc -c myalloc.c -fPIC
	gcc -shared -fPIC -o libmyalloc.so myalloc.o
	gcc -c test.c -fPIC
	gcc -shared -fPIC -o libtest.so test.o -L. -lmyalloc

install:
	mkdir -p ../../${arch}
	cp -v *.so ../../${arch}

clean:
	rm -f *.so *.o ../../${arch}/*.so
	rmdir ../../${arch}
