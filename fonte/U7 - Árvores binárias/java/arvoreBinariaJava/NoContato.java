/**
 * NoContato da arvore binaria
 * @author Max do Val Machado
 */
class NoContato {
	public char letra;
	public Lista elemento; // Conteudo do no.
	public NoContato esq, dir;  // Filhos da esq e dir.

	/**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 */
	public NoContato(Lista elemento) {
		this(elemento, null, null);
	}

	/**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 * @param esq NoContato da esquerda.
	 * @param dir NoContato da direita.
	 */
	public NoContato(Lista elemento, NoContato esq, NoContato dir) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
	}
}
