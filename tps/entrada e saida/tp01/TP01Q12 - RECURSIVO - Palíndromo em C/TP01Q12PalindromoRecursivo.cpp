//Curso: Ciencia da Computacao / Tarde
//Universidade: PUC Minas
//Materia: AEDII Lab
//Aluno: Guilherme Froes Camba de Freitas
//Matricula: 718116

#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#define MAX_LENGTH 1000

bool isPalindromo(char targetString[MAX_LENGTH]);
bool isPalindromo(char targetString[MAX_LENGTH],int index);
bool isFim(char targetString[MAX_LENGTH]);

/** 
* Is Palindromo.
* 
* Este metodo inicia a recurcao para verificacao da String para Palindromo
* @param targetString String alvo.
*/
bool isPalindromo(char targetString[MAX_LENGTH]){
    //Observando o codigo Pub.out deste exercicio verificamos que Caracteres Maiusculos e Minusculos sao considerados diferentes.
    //Nao sendo necessario converter para letras Maiusculas.
    return isPalindromo(targetString,0);
}

/** 
* Is Palindromo.
* 
* Este metodo inicia a para verificacao do array de caracteres para Palindromo
* @param targetString array de caracteres alvo.
*/
bool isPalindromo(char targetString[MAX_LENGTH],int index){
    //Observando o codigo Pub.out deste exercicio verificamos que Caracteres Maiusculos e Minusculos sao considerados diferentes.
    //Nao sendo necessario converter para letras Maiusculas.
    int resp = true;
    
    int length = strlen(targetString)-1;

    int halfLength = length/2;

    //printf("length = %d | halfLength = %d",length,halfLength);
    if( index < halfLength){
        if(targetString[index] != targetString[length-1 -index]){
            resp = false;
            index = halfLength;
        }else{
            resp = isPalindromo(targetString,index + 1);
        }
    }
    
    return resp;
}

bool isFim(char targetString[MAX_LENGTH]){
    return (strlen(targetString) >= 3 && targetString[0] == 'F' && targetString[1] == 'I' && targetString[2] == 'M');
}

int main(){

    char line [MAX_LENGTH];
    
    fgets(line, MAX_LENGTH, stdin);

    while (!isFim(line))
    {
        printf("%s\n",isPalindromo(line)?"SIM":"NAO");
    
        fgets(line, MAX_LENGTH, stdin);
    }

    return 0;
}