/**
 * Fila dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
#include <stdio.h>
#include <stdlib.h>
#include <err.h>
#include <stdbool.h>


//TIPO CELULA ===================================================================
typedef struct Celula {
	int elemento;        // Elemento inserido na celula.
	struct Celula* prox; // Aponta a celula prox.
} Celula;

bool isEven(int a);
bool isMulti5(int a);
int getEvenAndMulti5Rec(Celula *i);
int getEvenAndMulti5();

Celula* novaCelula(int elemento) {
   Celula* nova = (Celula*) malloc(sizeof(Celula));
   nova->elemento = elemento;
   nova->prox = NULL;
   return nova;
}

//FILA PROPRIAMENTE DITA ========================================================
Celula* primeiro;
Celula* topo;
Celula* ultimo;


/**
 * Cria uma fila sem elementos (somente no cabeca).
 */
void start () {
   primeiro = novaCelula(-1);
   ultimo = primeiro;
}

/**
 * Cria uma fila sem elementos (somente no cabeca).
 */
void startPilha () {
   topo = NULL;
}


/**
 * Insere elemento na fila (politica FIFO).
 * @param x int Elemento a inserir.
 */
void inserir(int x) {
   ultimo->prox = novaCelula(x);
   ultimo = ultimo->prox;
}


/**
 * Remove elemento da fila (politica FIFO).
 * @return Elemento removido.
 */
int remover() {
   if (primeiro == ultimo) {
      errx(1, "Erro ao remover!");
   }
   Celula* tmp = primeiro->prox;
   primeiro->prox = tmp->prox;
   int resp = tmp->elemento;
   tmp->prox = NULL;
   free(tmp);
   tmp = NULL;
   return resp;
}

/**
 * Mostrar maior elemento da fila.
 * @return Maior Elemento .
 */
int getMaior() {
   if (primeiro == ultimo) {
      errx(1, "Erro ao fila vazia!");
   }else{

      int bigger = primeiro->prox->elemento;

      Celula *walker = primeiro->prox->prox;

      while(walker != NULL){
         if(bigger < walker->elemento){
            bigger = walker->elemento;
         }
         walker = walker->prox;
      }

      return bigger;

   }

}

/**
 * Mostrar terceiro elemento da fila.
 * @return terceiro Elemento .
 */
int getThirdElement() {
   return primeiro->prox->prox->prox->elemento;

}

/**
 * Retorna a soma de todos os elementos da fila.
 * @return Soma de todos os elementos.
 */
int getSum() {
   if (primeiro == ultimo) {
      errx(1, "Erro ao fila vazia!");
   }else{

      int sum = primeiro->prox->elemento;

      Celula *walker = primeiro->prox->prox;

      while(walker != NULL){
         sum += walker->elemento;
         walker = walker->prox;
      }

      return sum;

   }
}

// [3 5 7 8]
void invertQueue(){
   Celula* end = ultimo;
   //printf("\nend->elemento = %d",end->elemento);
   // end->elemento = 8

   // primeiro->prox = 3 != 8
   while(primeiro->prox != end){
      //printf("\n (%d != %d)",primeiro->prox->elemento,end->elemento);
      //criando uma nova celula com o primeiro elemento valido da fila
      //newCell->elemento = 3
      Celula *newCell = novaCelula(primeiro->prox->elemento);
      //printf("\nnewCell->elemento = %d",newCell->elemento);
      //atribuindo a nova celula criada aponta para o ultimo prox = NULL
      //newCell->prox = NULL
      newCell->prox = end->prox;
      // ultimo proximo aponta para nova celula
      //end->prox = newCell(3)
      end->prox = newCell;

      //tmp = 3
      Celula *tmp = primeiro->prox;
      //primeiro->prox = 5
      primeiro->prox = tmp->prox;

      // free(newCell);
      newCell = tmp = tmp->prox = NULL;

      if(ultimo == end){
         ultimo = ultimo->prox;
      }
   }

   end = NULL;
   free(end);
}

bool isEven(int a){
   return (a % 2 == 0);
}

bool isMulti5(int a){
   return (a % 5 == 0);
}

int getEvenAndMulti5Rec(Celula *i){
   int resp;

   if(i == NULL){
      resp = 0;
   }else if(isEven(i->elemento) && isMulti5(i->elemento)){
      resp = 1 + getEvenAndMulti5Rec(i->prox);
   }else{
      resp = getEvenAndMulti5Rec(i->prox);
   }
      
   return resp;

}

int getEvenAndMulti5(){
   return getEvenAndMulti5Rec(primeiro->prox);
}

//[ 5 10 15 20 25 ]
void metodoDoidao(){
   Celula *fim = ultimo;

   //
   while(primeiro != fim){
      //null = (5)
      ultimo->prox = novaCelula(primeiro->prox->elemento);
      Celula *tmp = primeiro;
      //avanca o primeiro
      primeiro = primeiro->prox;
      tmp = tmp->prox = NULL;
      //avanca o ultimo
      ultimo = ultimo->prox;
   }

   fim = NULL;
}



/**
 * Mostra os elementos separados por espacos.
 */
void mostrar() {
   Celula* i;
   printf("[ ");
   for (i = primeiro->prox; i != NULL; i = i->prox) {
      printf("%d ", i->elemento);
   }
   printf("] \n");
}

/**
 * Mostra os elementos separados por espacos, comecando do topo.
 */
void mostrarPilha() {
   Celula* i;
   printf("[");
   for(i = topo; i != NULL; i = i->prox) {
      printf("%d ,", i->elemento);
   }

   printf("] \n");
}

/**
 * Insere elemento na pilha (politica FILO).
 * @param x int elemento a inserir.
 */
void inserirPilha(int x) {
   Celula* tmp = novaCelula(x);
   tmp->prox = topo;
   topo = tmp;
   tmp = NULL;
}

/**
 * Remove elemento da pilha (politica FILO).
 * @return Elemento removido.
 */
int removerPilha() {
   if (topo == NULL) {
      errx(1, "Erro ao remover!");
   }

   int resp = topo->elemento;
   Celula* tmp = topo;
   topo = topo->prox;
   tmp->prox = NULL;
   free(tmp);
   tmp = NULL;
   return resp;
}

Celula toFila(Celula *topo){

   Celula *inicio = topo;
   Celula *fim = NULL;

   start();

   while(inicio->prox != fim){
      inicio = inicio->prox;
      if(inicio->prox == fim){
         inserir(inicio->elemento);
         fim = inicio;
         inicio = topo;
      }
   }

   inserir(topo->elemento);
}


//METODO PRINCIPAL ==============================================================
int main(int argc, char** argv){
   int count;
   printf("\n==== FILA DINAMICA ====");
   startPilha();

   inserirPilha(1);
   inserirPilha(2);
   inserirPilha(3);
   inserirPilha(4);
   inserirPilha(5);

   printf("\nApos insercoes na pilha: ");
   mostrarPilha();

   printf("\nConverter Pilha to Fila: ");
   toFila(topo);
   mostrar();

}
