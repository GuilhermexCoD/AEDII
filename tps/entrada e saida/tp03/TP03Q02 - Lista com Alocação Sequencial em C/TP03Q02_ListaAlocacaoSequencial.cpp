//Curso: Ciencia da Computacao / Tarde
//Universidade: PUC Minas
//Materia: AEDII Lab
//Aluno: Guilherme Froes Camba de Freitas
//Matricula: 718116

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LENGTH 1000
#define MAXTAM 180

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
    printf("## %s ## %d ## %d ## %d ## %s ## %s ## %s ##",jogador->name,
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

void tirarQuebraDeLinha(char linha[]) {
    int tam = strlen(linha);

    if (linha[tam - 2] == '\r' && linha[tam - 1] == '\n') // Linha do Windows
        linha[tam - 2] = '\0'; // Apaga a linha

    else if (linha[tam - 1] == '\r' || linha[tam - 1] == '\n') // Mac ou Linux
        linha[tam - 1] = '\0'; // Apaga a linha
}


//Inicio Lista

struct Jogador array[180];   // Elementos da pilha 
int n;            // Quantidade de array.


/**
 * Inicializacoes
 */
void start(){
   n = 0;
}


/**
 * Insere um elemento na primeira posicao da lista e move os demais
 * elementos para o fim da 
 * @param x int elemento a ser inserido.
 */
void inserirInicio(struct Jogador x) {
   int i;

   //validar insercao
   if(n >= MAXTAM){
      printf("Erro ao inserir!");
      exit(1);
   } 

   //levar elementos para o fim do array
   for(i = n; i > 0; i--){
      array[i] = array[i-1];
   }

   array[0] = x;
   n++;
}


/**
 * Insere um elemento na ultima posicao da 
 * @param x int elemento a ser inserido.
 */
void inserirFim(struct Jogador x) {

   //validar insercao
   if(n >= MAXTAM){
      printf("Erro ao inserir!");
      exit(1);
   }

   array[n] = x;
   n++;
}


/**
 * Insere um elemento em uma posicao especifica e move os demais
 * elementos para o fim da 
 * @param x int elemento a ser inserido.
 * @param pos Posicao de insercao.
 */
void inserir(struct Jogador x, int pos) {
   int i;

   //validar insercao
   if(n >= MAXTAM || pos < 0 || pos > n){
      printf("Erro ao inserir!");
      exit(1);
   }

   //levar elementos para o fim do array
   for(i = n; i > pos; i--){
      array[i] = array[i-1];
   }

   array[pos] = x;
   n++;
}


/**
 * Remove um elemento da primeira posicao da lista e movimenta 
 * os demais elementos para o inicio da mesma.
 * @return resp int elemento a ser removido.
 */
struct Jogador removerInicio() {
   int i;
   struct Jogador resp;

   //validar remocao
   if (n == 0) {
      printf("Erro ao remover!");
      exit(1);
   }

   resp = array[0];
   n--;

   for(i = 0; i < n; i++){
      array[i] = array[i+1];
   }

   return resp;
}


/**
 * Remove um elemento da ultima posicao da 
 * @return resp int elemento a ser removido.
 */
struct Jogador removerFim() {

   //validar remocao
   if (n == 0) {
      printf("Erro ao remover!");
      exit(1);
   }

   return array[--n];
}


/**
 * Remove um elemento de uma posicao especifica da lista e 
 * movimenta os demais elementos para o inicio da mesma.
 * @param pos Posicao de remocao.
 * @return resp Jogador elemento a ser removido.
 */
struct Jogador remover(int pos) {
   int i;
   struct Jogador resp;

   //validar remocao
   if (n == 0 || pos < 0 || pos >= n) {
      printf("Erro ao remover!");
      exit(1);
   }

   resp = array[pos];
   n--;

   for(i = pos; i < n; i++){
      array[i] = array[i+1];
   }

   return resp;
}

/**
 * Procura um array e retorna se ele existe.
 * @param x int elemento a ser pesquisado.
 * @return <code>true</code> se o array existir,
 * <code>false</code> em caso contrario.
 */
// bool pesquisar(struct Jogador x) {
//    bool retorno = false;
//    int i;

//    for (i = 0; i < n && retorno == false; i++) {
//       retorno = (array[i] == x);
//    }
//    return retorno;
// }

/**
 * Mostra os array separados por espacos.
 */
void mostrar (){
   int i;

   for(i = 0; i < n; i++){
      printf("[%d] ",i);
      imprimirJogador(&array[i]);
      printf("\n");
   }

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

int main(int argc, char *argv[]) {

    const char* FILE_NAME = "/tmp/players.csv";

    struct Jogador players[5000];

    readFile(FILE_NAME,players);

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
        // cloneJogador(&players[index],&jogadores[count]);
        inserirFim(players[index]);
        count++;
        fgets(line, MAX_LENGTH, stdin);
    }

    fgets(line, MAX_LENGTH, stdin);

    int numEntrada = atoi(line);

    for(int i = 0; i < numEntrada; i++){
        fgets(line, MAX_LENGTH, stdin);

        char novaLinha[250];

        tirarQuebraDeLinha(line);
        strcpy(novaLinha, line);

        int index = -1;
        int indexTwo = -1;

        char *newLine;
        char operation[10];
        newLine = strtok(novaLinha, " ");

        strcpy(operation, newLine);

        newLine = strtok(NULL, " ");

        if(newLine != NULL){

            index = atoi(newLine);
        }

        newLine = strtok(NULL, " ");
        
        if(newLine != NULL){

            indexTwo = atoi(newLine);
        }
        
        if(strcmp(operation,"II") == 0){
            inserirInicio(players[index]);
        }

        if(strcmp(operation,"IF") == 0){
            inserirFim(players[index]);
        }

        if(strcmp(operation,"I*") == 0){
            inserir(players[indexTwo],index);
        }

        if(strcmp(operation,"RI") == 0){
            printf("(R) %s\n",removerInicio().name);
        }

        if(strcmp(operation,"RF") == 0){
            printf("(R) %s\n",removerFim().name);
        }

        if(strcmp(operation,"R*") == 0){
            printf("(R) %s\n",remover(index).name);
        }
        
    }  

    mostrar();

    return 0;
}