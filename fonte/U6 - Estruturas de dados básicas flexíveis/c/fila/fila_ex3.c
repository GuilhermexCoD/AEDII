/**
 * Fila dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
#include <stdio.h>
#include <stdlib.h>
#include <err.h>

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
Celula* primeiro;
Celula* ultimo;


/**
 * Cria uma fila sem elementos (somente no cabeca).
 */
void start () {
   primeiro = novaCelula(-1);
   ultimo = primeiro;
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


//METODO PRINCIPAL ==============================================================
int main(int argc, char** argv){
   int x1, bigger, x3;
   printf("\n==== FILA DINAMICA ====");

   start();

   inserir(3);
   inserir(5);
   inserir(7);
   inserir(8);

   printf("\nApos insercoes(3, 5, 7, 8): ");
   
   mostrar();

   printf("\nTerceiro elemento (%d):", getThirdElement());

}
