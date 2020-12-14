//Curso: Ciencia da Computacao / Tarde
//Universidade: PUC Minas
//Materia: AEDII Lab
//Aluno: Guilherme Froes Camba de Freitas
//Matricula: 718116

#include <stdio.h>
//#include <stdbool.h>
#include <string.h>

#define MAX_LENGTH 1000


int isPalindromo(char targetString[MAX_LENGTH]);
int isFim(char targetString[MAX_LENGTH]);

/** 
* Is Palindromo.
* 
* Este metodo inicia a para verificacao do array de caracteres para Palindromo
* @param targetString array de caracteres alvo.
*/
int isPalindromo(char targetString[MAX_LENGTH]){
    //Observando o codigo Pub.out deste exercicio verificamos que Caracteres Maiusculos e Minusculos sao considerados diferentes.
    //Nao sendo necessario converter para letras Maiusculas.
    int resp = 1;
    
    int length = strlen(targetString)-1;

    int halfLength = length/2;

    //printf("length = %d | halfLength = %d",length,halfLength);

    for(int index = 0; index < halfLength; index++){
        
        if(targetString[index] != targetString[length-1 -index]){
            resp = 0;
            index = halfLength;
        }
    }
    
    return resp;
}

int isFim(char targetString[MAX_LENGTH]){
    return (strlen(targetString) >= 3 && targetString[0] == 'F' && targetString[1] == 'I' && targetString[2] == 'M');
}

int main(){

    char line [MAX_LENGTH];
    
    fgets(line, MAX_LENGTH, stdin);

    while (isFim(line) == 0)
    {
        if(isPalindromo(line) == 1){
            printf("SIM\n");
        }else{
            printf("NAO\n");
        }
        fgets(line, MAX_LENGTH, stdin);
    }

    return 0;
}
