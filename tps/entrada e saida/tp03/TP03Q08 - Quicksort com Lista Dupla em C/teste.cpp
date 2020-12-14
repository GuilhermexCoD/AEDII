#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int* metodo(int& a,int* b){
    a = 5;
    *b = 6;

    int v[3];
    int* resp = v;
    resp[0] = 10;
    resp[1] = 20;
    resp[2] = 30;

    return resp;
}

int main(int argc, char *argv[]) {
    int a = 10;
    int b = 25;
    int* vet = metodo(a,&b);
    printf("%d %d\n",a,b);
    printf("%d %d %d",vet[0],vet[1],vet[2]);

    return 0;
}

//No C++,quando implementamos um metodo fora da classe,antes do nome do metodo, colocamos o "nome da classe" seguido de "::"
//Ex: Class No /Method No(int);
//No::No(int elemento)