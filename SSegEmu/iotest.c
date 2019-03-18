#include <stdio.h> 
#define MAX 15 
int main() 
{ 
    char buf[MAX];
while(1){
	printf("hello\n");
    fgets(buf, MAX, stdin); 
    printf("string is: %s", buf); 
  

}	
    return 0; 
} 