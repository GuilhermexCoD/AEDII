//Curso: Ciencia da Computacao / Tarde
//Universidade: PUC Minas
//Materia: AEDII Lab
//Aluno: Guilherme Froes Camba de Freitas
//Matricula: 718116

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LENGTH 1000

void selecao(struct Jogador *array, int n);
void swap(struct Jogador *i, struct Jogador *j);
void imprimirJogador(struct Jogador* jogador);
void imprimirPrimeiros(struct Jogador* players,int quantity);
void lerJogador(Jogador* jogador,char *input);
char* validateString(char *line,int size,char separator);
void cloneJogador(struct Jogador* toClone,struct Jogador* receiver);
void readFile(const char* fileName,struct Jogador* players);
bool isFim(char targetString[MAX_LENGTH]);

struct Jogador{

    int id;
    char name[200];
    int altura;
    int peso;
    char universidade[200];
    int anoNascimento;
    char cidadeNascimento[200];
    char estadoNascimento[200];

};

/** 
* Imprimir.
* 
* Este metodo imprime na tela todos atributos de Jogador.
*/ 
void imprimirJogador(struct Jogador* jogador){
    printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]",jogador->id,jogador->name,
            jogador->altura,jogador->peso,jogador->anoNascimento,
            jogador->universidade,jogador->cidadeNascimento,jogador->estadoNascimento);
}

/** 
* Imprimir.
* 
* Este metodo imprime na tela todos atributos de Jogador de n Jogadores.
*/ 
void imprimirPrimeiros(struct Jogador* players,int quantity){
    for(int i = 0;i < quantity;i++){
        imprimirJogador(&players[i]);
    }
}

/** 
* Ler.
* 
* Este metodo faz a leitura de uma string separada por virgulas contendo os atributos de jogador nessa ordem:
*  Id,Nome,Altura,Peso,Universidade,AnoNascimento,CidadeNascimento,EstadoNascimento
* @param jogador Jogador a ser lido.
* @param input String a ser lida.
*/
void lerJogador(Jogador* jogador,char *input){

    // Extract the first token
    char * token = strtok(input, ",");
    int i = 0;
    // loop through the string to extract all other tokens
    while( token != NULL ) {
        switch(i){
            case 0:
                jogador->id = atoi(token);
            break;
            
            case 1:
                strcpy (jogador->name ,token);
            break;

            case 2:
                jogador->altura = atoi(token);
            break;

            case 3:
                jogador->peso = atoi(token);
            break;

            case 4:
                strcpy(jogador->universidade, token);
            break;

            case 5:
                jogador->anoNascimento = atoi(token);
            break;

            case 6:
                strcpy(jogador->cidadeNascimento, token);
            break;

            case 7:
                strcpy(jogador->estadoNascimento, token);
            break;
        }

        token = strtok(NULL, ",");
        i++;
    }

    //imprimirJogador(jogador);
}

/** 
* Validate String.
* 
* Este metodo retorna uma String valida para os padroes de jogador
* @param line String contendo os dados de Jogador.
* @param size tamanho da String.
* @param separator Char que separa a String.
*/
char* validateString(char *line,int size,char separator){
    //char stringCopy[size*2];
    //printf("\nValidando linha: %s",line);

    char string[size];
    strcpy(string,line);
    line = (char*) malloc(size*2);
    char notInfor[] = "nao informado";

    int copyIndex = 0;

    int splitSize = 1;

    int i = 0;

    while(string[i] != '\0'){

        char actualChar = string[i];

        if(actualChar == '\r' || actualChar == '\n')
            actualChar = '\0';

        *(line+copyIndex) = actualChar;
        copyIndex++;

        if(actualChar == separator){
            if(i+1 <= size && (string[i+1] == separator) || (string[i+1] == '\0' || string[i+1] == '\r' || string[i+1] == '\n')){
                
                for(int j = 0;j < strlen(notInfor);j++){

                    *(line+copyIndex) = notInfor[j];
                    
                    copyIndex++;
                }

            }
            splitSize++;
        }

        i++;
    }

    //printf("Linha validada = %s",line);
    return line;
}

/** 
* Read File.
* 
* Este metodo lee um arquivo contendo varios jogadores
* @param fileName caminho e nome do arquivo.
* @param players Apontador para o array de jogadores.
*/
void readFile(const char *fileName,struct Jogador* players){
    FILE *p = fopen (fileName, "r");
    char str[200+1];
    char* resp;
    int i = 0;

    //struct Jogador jogadores[10000];

    if (p != NULL) {
        do {
            resp = fgets(str, 200, p);
            if(resp != NULL && i > 0){
                char *ptr;

                //printf("%s", str);

                ptr = validateString(str,sizeof(str), ',');

                lerJogador(&players[i-1],ptr);
            }

            i++;
        } while (resp != NULL);
        fclose(p);
    }
}

void cloneJogador(struct Jogador* toClone,struct Jogador* receiver){
    receiver->id = toClone->id;
    strcpy(receiver->name,toClone->name);
    receiver->altura = toClone->altura;
    receiver->peso = toClone->peso;
    strcpy(receiver->universidade, toClone->universidade);
    receiver->anoNascimento = toClone->anoNascimento;
    strcpy(receiver->cidadeNascimento, toClone->cidadeNascimento);
    strcpy(receiver->estadoNascimento, toClone->estadoNascimento);
}

/** 
* Is Fim.
* 
* Este metodo retorna verdadeiro quando a String alvo possui a palavra FIM.
* @param targetString String alvo.
*/ 
bool isFim(char targetString[MAX_LENGTH]){
    return (strlen(targetString) >= 3 && targetString[0] == 'F' && targetString[1] == 'I' && targetString[2] == 'M');
}

void selecao(struct Jogador *array, int n){

    for (int i = 0; i < (n - 1); i++) {
        int menor = i;
        for (int j = (i + 1); j < n; j++){
            int comp = strcmp (array[menor].name,array[j].name);

            if (comp > 0){
                menor = j;
            }
        }
        swap(&array[menor], &array[i]);
    }
}

int minIndex(struct Jogador *array, int i,int j){
    if (i == j) 
        return i; 
  
    // Find minimum of remaining elements 
    int k = minIndex(array, i + 1, j); 
  
    int comp = strcmp (array[i].name,array[k].name);
    // Return minimum of current and remaining. 
    return (comp < 0)? i : k;
}

void selecaoRecur(struct Jogador *array, int n,int index){

    if(n == index)
        return;

    int k = minIndex(array, index, n-1); 
    
    if (k != index) 
       swap(&array[k], &array[index]); 
  
    selecaoRecur(array, n, index + 1); 
}

//=============================================================================
// PROCEDIMENTO PARA TROCAR DOIS ELEMENTOS DO VETOR
void swap(struct Jogador *i, struct Jogador *j) {
   struct Jogador temp = *i;
   *i = *j;
   *j = temp;
}

int main(int argc, char *argv[]) {

    const char* FILE_NAME = "/tmp/players.csv";
    //printf("Trying to read file: %s",FILE_NAME);

    struct Jogador players[5000];

    readFile(FILE_NAME,players);

    //imprimirPrimeiros(players,3921);

    char line [MAX_LENGTH];
    
    fgets(line, MAX_LENGTH, stdin);

    struct Jogador jogadores[5000];

    int count = 0;

    while (!isFim(line))
    {
        int index = atoi(line);
        
        //printf("index: %d",index);   
        //imprimirJogador(&players[index]);
        //printf("\n");
        cloneJogador(&players[index],&jogadores[count]);
        count++;
        fgets(line, MAX_LENGTH, stdin);
    }

    selecaoRecur(jogadores,count,0);

    for(int i = 0;i < count;i++){
        imprimirJogador(&jogadores[i]);
        printf("\n");
    }

    return 0;
}