//Curso: Ciencia da Computacao / Tarde
//Universidade: PUC Minas
//Materia: AEDII Lab
//Aluno: Guilherme Froes Camba de Freitas
//Matricula: 718116
/** 
* Is Lower Case.
* 
* Este metodo retorna True se o caractere em questao for minusculo.
* @param value caractere alvo.
*/

#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#define MAX_LENGTH 1000

bool isLowerCase(char value);
bool isInteger(char value);
bool isInteger(char value[MAX_LENGTH]);
bool isReal(char value[MAX_LENGTH]);
bool isLetter(char value);
bool isVowel(char value[MAX_LENGTH]);
bool isConsonant(char value[MAX_LENGTH]);
bool isVowel(char value);
int getConsonantCount(char value[MAX_LENGTH]);
int getConsonantCount(char value[MAX_LENGTH],int index);
int getVowelCount(char value[MAX_LENGTH]);
int getVowelCount(char value[MAX_LENGTH],int index);
bool isFim(char targetString[MAX_LENGTH]);


bool isLowerCase(char value){
    
    if(!isLetter(value))
        return false;

    bool lowerCase = false;
    int decimalChar = value;
    
    if(decimalChar >= 97 && decimalChar <= 122){
        lowerCase = true;
    }
    
    return lowerCase;
}

/** 
* Is Integer.
* 
* Este metodo retorna True se o char em questao for um numero inteiro.
* @param value char alvo.
*/
bool isInteger(char value){
    
    int decimalChar = value;
    
    if(decimalChar >= 48 && decimalChar <= 57){
        return true;
    }
    return false;

}

/** 
* Is Integer.
* 
* Este metodo retorna True se a String em questao for um numero inteiro.
* @param value String alvo.
*/
bool isInteger(char value[MAX_LENGTH]){
    
    bool result = true;

    int length = strlen(value)-1;

    for(int i = 0; i < length; i++){
        char item = value[i];
        
        if(!isInteger(item)){
            result = false;
            break;
        }

    }
    
    return result;

}

/** 
* Is Real.
* 
* Este metodo retorna True se a String em questao for um numero real.
* @param value String alvo.
*/
bool isReal(char value[MAX_LENGTH]){
    
    bool result = true;

    int realCount = 0;

    int length = strlen(value)-1;

    for(int i = 0; i < length; i++){
        char item = value[i];
        
        if(!isInteger(item)){
            //um numero real pode ter a aparicao de apenas um separador
            if(realCount < 1 && (item == '.' || item == ',')){
                realCount++;
            }else{
                result = false;
                break;
            }
            
        }

    }
    
    return result;

}

/** 
    * Is Letter.
    * 
    * Este metodo retorna True se o caractere em questao eh uma letra de acordo com a tabela ASCII.
    * @param value caractere alvo.
    */
bool isLetter(char value){
    int decimalChar = value;
    
    if((decimalChar >= 65 && decimalChar <= 90) || (decimalChar >= 97 && decimalChar <= 122) ){
        return true;
    }
    return false;
}

/** 
* Is Vowel.
* 
* Este metodo retorna True se todos elementos da String forem uma vogal.
* @param value String alvo.
*/
bool isVowel(char value[MAX_LENGTH]){
    int stringSize = strlen(value)-1;
    int vowelCount = getVowelCount(value);

    return (stringSize == vowelCount);
}

/** 
* Is Consonant.
* 
* Este metodo retorna True se todos elementos da String forem uma consoante.
* @param value String alvo.
*/
bool isConsonant(char value[MAX_LENGTH]){

    int stringSize = strlen(value)-1;
    int consonantCount = getConsonantCount(value);

    return (stringSize == consonantCount);
}    

/** 
* is Vowel.
* 
* Este metodo retorna True se o caractere em questao eh uma vogal.
* @param value caractere alvo.
*/
bool isVowel(char value){
    if(!isLetter(value))
        return false;

    int decimalChar = value;
    /*
    if(decimalChar == 65 || decimalChar == 69 || decimalChar == 73 || decimalChar == 79 || decimalChar == 85){
        return true;
    }
    */
    if(decimalChar == 97 || decimalChar == 101 || decimalChar == 105 || decimalChar == 111 || decimalChar == 117){
        return true;
    }

    return false;

}

    /** 
* Get Consonant Count.
* 
* Este metodo retorna a contagem de consoantes da String alvo.
* @param value String alvo.
*/
int getConsonantCount(char value[MAX_LENGTH]){

    return getConsonantCount(value,0);
}

/** 
* Get Consonant Count.
* 
* Este metodo recursivo retorna a contagem de consoantes da String alvo.
* @param value String alvo.
* @param index indice para verificar se eh consoantes.
*/
int getConsonantCount(char value[MAX_LENGTH],int index){
    int count = 0;

    int length = strlen(value)-1;

    if(index < length){
        char letter = value[index];

        //nao verifica se eh uma letra, tudo que nao for vogal agora eh consoante
        if(isLetter(letter) && !isVowel(letter)){
            count ++;
        }
        count += getConsonantCount(value,index + 1);
    }

    return count;
}

/** 
* Get Vowel Count.
* 
* Este metodo retorna a contagem de vogais da String alvo.
* @param value String alvo.
*/
int getVowelCount(char value[MAX_LENGTH]){

    return getVowelCount(value,0);
}

/** 
* Get Vowel Count.
* 
* Este metodo recursivo retorna a contagem de vogais da String alvo.
* @param value String alvo.
* @param index indice para verificar se eh vogal.
*/
int getVowelCount(char value[MAX_LENGTH],int index){
    int count = 0;

    int length = strlen(value)-1;

    if(index < length){
        char letter = value[index];
        if(isVowel(letter)){
            count ++;
        }
        count += getVowelCount(value,index + 1);
    }

    return count;
}

bool isFim(char targetString[MAX_LENGTH]){
    return (strlen(targetString) >= 3 && targetString[0] == 'F' && targetString[1] == 'I' && targetString[2] == 'M');
}

int main(){

    char line [MAX_LENGTH];
    
    fgets(line, MAX_LENGTH, stdin);

    while (!isFim(line))
    {
        //MyIO.println((isVowel(entrada[i])?"SIM":"NAO")+" "+(isConsonant(entrada[i])?"SIM":"NAO")+" "+(isInteger(entrada[i])?"SIM":"NAO")+" "+(isReal(entrada[i])?"SIM":"NAO"));
        printf("%s %s %s %s\n",
        (isVowel(line)?"SIM":"NAO"),
        (isConsonant(line)?"SIM":"NAO"),
        (isInteger(line)?"SIM":"NAO"),
        (isReal(line)?"SIM":"NAO"));

        fgets(line, MAX_LENGTH, stdin);
    }

    return 0;
}