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

Celula* novaCelula(int elemento) {
   Celula* nova = (Celula*) malloc(sizeof(Celula));
   nova->elemento = elemento;
   nova->prox = NULL;
   return nova;
}

//FILA PROPRIAMENTE DITA ========================================================
Celula* ultimo;


/**
 * Cria uma fila sem elementos (somente no cabeca).
 */
void start () {
   ultimo = NULL;
}

/**
 * Insere elemento na fila (politica FIFO).
 * @param x int Elemento a inserir.
 */
void inserir(int x) {
   if(ultimo == NULL){
      ultimo = novaCelula(x);
      ultimo->prox = ultimo;
   }else{
      Celula *inicio = ultimo->prox;
      ultimo->prox = novaCelula(x);
      ultimo = ultimo->prox;
      ultimo->prox = inicio;
   }
}


/**
 * Remove elemento da fila (politica FIFO).
 * @return Elemento removido.
 */
int remover() {

   if (ultimo == NULL) {
      errx(1, "Erro ao remover!");
   }
   Celula* tmp = ultimo->prox;
   ultimo->prox = tmp->prox;
   int resp = tmp->elemento;
   tmp->prox = NULL;
   free(tmp);
   tmp = NULL;
   return resp;
}

/**
 * Mostra os elementos separados por espacos.
 */
void mostrar() {
   if (ultimo == NULL) {
      printf("\nfila vazia\n");
   }else{

      Celula* i;
      printf("[ ");
      for (i = ultimo->prox; i != ultimo; i = i->prox) {
         printf("%d ", i->elemento);
      }
      printf("%d ] \n",ultimo->elemento);
   }
}

//METODO PRINCIPAL ==============================================================
int main(int argc, char** argv){
   int count;
   printf("\n==== FILA DINAMICA ====");
   start();

   mostrar();
   inserir(1);
   mostrar();
   inserir(2);
   mostrar();
   inserir(3);
   mostrar();
   inserir(4);
   mostrar();
   inserir(5);

   printf("\nApos insercoes na pilha: ");
   mostrar();

   remover();
   mostrar();
   remover();
   mostrar();
   remover();
   mostrar();
}
