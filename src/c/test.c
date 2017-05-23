// Save this in a file test.c
#include <stdio.h>              
#include "myalloc.h"

struct mystruct
{              
    int a;     
    int b;     
};           

int fun_alloc(struct mystruct **allocint)
{                                        
    *allocint = (struct mystruct *) myalloc (sizeof(struct mystruct));
    printf("Native allocted pointer  %p\n", *allocint);              
    (*allocint)->a = 10000;                                          
    (*allocint)->b = 20099;
    printf("Struct field has values %d %d \n", (*allocint)->a,  (*allocint)->b);
     return 0;
}

int fun_free(struct mystruct **ptr)
{
    struct mystruct *p = *ptr;
    printf("Native Freeing mem %p with val %d %d\n", p,  p->a, p->b);
    myfree(p);
    return 0;
}

int setvals(struct mystruct **ptr, int num_structs)
{
    int i = 0;
    if (num_structs < 0)
        return 0;
    printf("Native recieved the pointer to an array of structures with %d elements\n", num_structs);
    while (i < num_structs) {
        ptr[i]->a = i;
        ptr[i]->b = i + 100;
        i++;
    }
    return 0;

}

int setstring(char *ptr)
{
    printf("Native recived string %s \n", ptr);
    printf("Native will set first char to 1 in that string");
    ptr[0]='1';
    return 0;
}