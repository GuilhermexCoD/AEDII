/**
 * Insere um elemento na ultima posicao da lista.
 * @param x int elemento a ser inserido.
 */
void inserirFim(int x) {
   ultimo->prox = novaCelulaDupla(x);
   ultimo->prox->ant = ultimo;
   //Substituir ultimo = ultimo->prox; por ultimo = ultimo->prox->ant->prox->ant->prox; 
   //ultimo->prox->ant quando fazemos prox->ant voltamos para a mesma celula e fazendo isso 2x nao muda nada
   //Entao sim ultimo = ultimo->prox; == ultimo->prox->ant->prox->ant->prox;
   ultimo = ultimo->prox->ant->prox->ant->prox;
}

