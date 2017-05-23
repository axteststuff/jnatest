#include "myalloc.h"

void *myalloc(size_t s)
{
    return malloc(s);
}

void myfree(void *p)
{
    free(p);
}