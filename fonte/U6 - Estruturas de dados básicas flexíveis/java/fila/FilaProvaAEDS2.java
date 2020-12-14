/**
 * Fila dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
public class Fila {
	private Celula primeiro;
	private Celula ultimo;


	/**
	 * Construtor da classe que cria uma fila sem elementos (somente no cabeca).
	 */
	public Fila() {
		primeiro = new Celula();
		ultimo = primeiro;
	}


	/**
	 * Insere elemento na fila (politica FIFO).
	 * @param x int elemento a inserir.
	 */
	public void inserir(int x) {
		ultimo.prox = new Celula(x);
		ultimo = ultimo.prox;
	}


	/**
	 * Remove elemento da fila (politica FIFO).
	 * @return Elemento removido.
	 * @trhows Exception Se a fila nao tiver elementos.
	 */
	public int remover() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover!");
		}

      Celula tmp = primeiro;
		primeiro = primeiro.prox;
		int resp = primeiro.elemento;
      tmp.prox = null;
      tmp = null;
		return resp;
	}


	/**
	 * Mostra os elementos separados por espacos.
	 */
	public void mostrar() {
		System.out.print("[ ");
		
		for(Celula i = primeiro.prox; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		}
		
		System.out.println("] ");
	}

	public int extrairdafila(int i){
		int resp = -1;
		
		//caminhar pela do primeiro ate o ultimo elemento da fila
		for(Celula atual = this.primeiro; atual != null; atual = atual.prox){
			//criamos uma variavel temporaria 
			Celula tmp;

			//se o elemento atual for igual ao elemento que procuramos 
			//vamos efetuar remove-lo
			if(atual.elemento == i){
				//armazenamos o valor de atual em tmp
				tmp = atual;
				//o elemento atual sera removido 
				atual = atual.prox;
				//liberamos tmp
				tmp.prox = null;
				tmp = null;
				//o valor de retorno foi encontrado
				resp = i;
				//saimos do for 
				atual = null;
			}else{

				//se o proximo elemento for diferente de NULL
				if(atual.prox != null){

					//salvamos o proximo elemento numa variavel temporaria
					tmp = atual.prox;
					//verificamos se o elemento proximo é o elemento que procuramos 
					//efetuamos a remocao
					if(tmp.elemento == i){
						//o elemento atual sera removido 
						atual.prox = tmp.prox;
						//liberamos tmp
						tmp.prox = null;
						tmp = null;
						//o valor de retorno foi encontrado
						resp = i;
						//saimos do for
						atual = null;
					}
				}
			}
		}
	}
}
