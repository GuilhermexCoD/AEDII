class Pilha {
	private Celula topo;
	
	/**
	 * Construtor da classe que cria uma fila sem elementos.
	 */
	public Pilha() {
		topo = null;
	}

	public void mostrar() {
		System.out.print("[ ");
		for (Celula i = topo; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		}
		System.out.println("] ");
	}

	public int getSoma() {
		return getSoma(topo);
	}

	private int getSoma(Celula i) {
		int resp = 0;
		if (i != null) {
			resp += i.elemento + getSoma(i.prox);
		}
		return resp;
	}
	
	public int getMax() {
		int max = topo.elemento;
		for (Celula i = topo.prox; i != null; i = i.prox) {
			if (i.elemento > max)
			max = i.elemento;
		}
		return max;
	}
	
	public void mostraPilha() {
		mostraPilha(topo);
	}
	
	private void mostraPilha(Celula i) {
		if (i != null) {
			mostraPilha(i.prox);
			System.out.println("" + i.elemento);
		}
	}
	
	public int getSize(){
		int size = 0;

		for(Celula i = this.topo;i != null;i = i.prox){
			size++;
		} 

		return size;
	}

	public void empilhar(int x) {
		Celula tmp = new Celula(x);
		tmp.prox = topo;
		topo = tmp;
		tmp = null;
	}
	
	public int desempilhar() throws Exception {
		if (topo == null) {
			throw new Exception("Erro ao remover!");
		}
		int resp = topo.elemento;
		Celula tmp = topo;
		topo = topo.prox;
		tmp.prox = null;
		tmp = null;
		return resp;
	}

	public Pilha copyCelulas(){
		Pilha copyPilha = new Pilha();
		int size = getSize();
		// System.out.println(String.format("Size pilha %d",size));


		for(int i = 0;i < size;i++){
			Celula atual = this.topo;
			// System.out.println(String.format("Elemento atual : %d",atual.elemento));

			for(int j = size - i; j > 1;j--){
				atual = atual.prox;
			}
			// System.out.println(String.format("Ultimo elemento %d",atual.elemento));
			
			copyPilha.empilhar(atual.elemento);

		}
		return copyPilha;
	}

	public boolean vazia(){
		boolean resp = true;

		if(topo != null)
			resp = false;

		return resp;
	}

	public void enfileirar(int i )throws Exception{
		//Iniciamos uma pilha vazia
		Pilha copia = new Pilha();

		//enquanto a pilha atual ainda tiver elementos vamos desempilhando ela.
		while(!this.vazia()){
			int valor = this.desempilhar();
			copia.empilhar(valor);
		}
		//ex: 	this [ 0 1 ] 
		//		copia[ 1 0 ]
		//percebemos que estamos invertendo a pilha

		//vamos entao adicionar nosso elemento desejado primeiramente na pilha vazia
		this.empilhar(i);
		//ex:	this [ 2 ]

		//agora vamos passar por todos elementos da copia e ir desempilhando
		//e adicionando na pilha atual
		while(!copia.vazia()){
			int elemento = copia.desempilhar();
			this.empilhar(elemento);
		}
		//ex: 	this [ 0 1 2 ]
	}

	public int desenfileirar()throws Exception{
		//para respeitarmos FIFO (First In First Out)
		//temos que tirar o primeiro elemento inserido
		//apenas desempilhando a pilha
		int resp = this.desempilhar();

		return resp;
	}

}

public class PilhaProvaAEDS2 {

	public static Pilha inserirFila(Pilha fila,int elemento)throws Exception{
		System.out.println(String.format("Enfileirar : %d",elemento));

		fila.enfileirar(elemento);

		fila.mostrar();

		return fila;
	}

	public static Pilha removerFila(Pilha fila)throws Exception{
		
		int elemento = fila.desenfileirar();
		
		System.out.println(String.format("Desenfileirar : %d",elemento));
		
		fila.mostrar();
		
		return fila;
	}

	public static Pilha inserirPilha(Pilha pilha,int elemento){
		System.out.println(String.format("Empilhando : %d",elemento));

		pilha.empilhar(elemento);

		pilha.mostrar();

		return pilha;
	}

	public static Pilha removerPilha(Pilha pilha)throws Exception{
		
		int elemento = pilha.desempilhar();
		
		System.out.println(String.format("Desempilhando : %d",elemento));
		
		pilha.mostrar();
		
		return pilha;
	}

	public static void main(String[] args)throws Exception {
		try {
			System.out.println(" ==== PILHA DINAMICA (First In Last Out) ====");
			Pilha pilha = new Pilha();
			Pilha fila = new Pilha();

			System.out.println("\nIniciar insercoes Pilha: \n");

			pilha = inserirPilha(pilha,0);
			pilha = inserirPilha(pilha,1);
			pilha = inserirPilha(pilha,2);
			pilha = inserirPilha(pilha,3);
			pilha = inserirPilha(pilha,4);
			pilha = inserirPilha(pilha,5);
			
			System.out.println("\nApos insercoes Pilha: \n");
			pilha.mostrar();
			
			System.out.println("\nIniciar remocoes Pilha: \n");
			
			pilha = removerPilha(pilha);
			pilha = removerPilha(pilha);
			pilha = removerPilha(pilha);
			pilha = removerPilha(pilha);
			pilha = removerPilha(pilha);
			pilha = removerPilha(pilha);
			
			System.out.println("\nApos as remocoes Pilha: \n");
			pilha.mostrar();

			System.out.println("\n ==== FILA DINAMICA (First In First Out) ====");
			
			System.out.println("\nIniciar insercoes Fila: \n");
			
			fila = inserirFila(fila,0);
			fila = inserirFila(fila,1);
			fila = inserirFila(fila,2);
			fila = inserirFila(fila,3);
			fila = inserirFila(fila,4);
			fila = inserirFila(fila,5);
			
			System.out.println("\nApos insercoes Fila: \n");

			fila.mostrar();
			
			System.out.println("\nIniciar remocoes Fila: \n");

			fila = removerFila(fila);
			fila = removerFila(fila);
			fila = removerFila(fila);
			fila = removerFila(fila);
			fila = removerFila(fila);
			fila = removerFila(fila);

			System.out.println("\nApos as remocoes Fila: \n");
			
			fila.mostrar();
		}
		catch(Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
}
