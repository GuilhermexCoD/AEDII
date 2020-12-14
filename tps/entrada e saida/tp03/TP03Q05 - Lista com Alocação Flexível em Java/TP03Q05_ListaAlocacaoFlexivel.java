//Curso: Ciencia da Computacao / Tarde
//Universidade: PUC Minas
//Materia: AEDII Lab
//Aluno: Guilherme Froes Camba de Freitas
//Matricula: 718116

class Jogador{

    private int id;
    private String nome;
    private int altura;
    private int peso;
    private String universidade;
    private int anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;

    /** 
    * Jogador.
    * 
    * Este construtor atribui valores nulos para todas as variaveis
    */
    public Jogador() {
        setId(-1);
        setNome("");
        setAltura(-1);
        setPeso(-1);
        setUniversidade("");
        setAnoNascimento(-1);
        setCidadeNascimento("");
        setEstadoNascimento("");
    }

    /** 
     * Jogador.
     * 
     * Este construtor atribui passados por parametros
     * @param id int id do jogador.
     * @param nome String nome do jogador.
     * @param altura int altura do jogador.
     * @param peso int peso do jogador.
     * @param universidade String universidade do jogador.
     * @param anoNascimento int anoNascimento do jogador.
     * @param cidadeNascimento String cidadeNascimento do jogador.
     * @param estadoNascimento String estadoNascimento do jogador.
    */
    public Jogador(int id,String nome,int altura,int peso,String universidade,int anoNascimento,String cidadeNascimento,String estadoNascimento) {
        setId(id);
        setNome(nome);
        setAltura(altura);
        setPeso(peso);
        setUniversidade(universidade);
        setAnoNascimento(anoNascimento);
        setCidadeNascimento(cidadeNascimento);
        setEstadoNascimento(estadoNascimento);
    }

    /** 
     * Get Valid String.
     * 
     * Este metodo retorna uma String valida para os padroes de jogador
     * @param value String que deve ser convertida para um valor valido.
    */
    public String getValidString(String value){
        if(value == "")
            return "nao informado";

        return value;
    }

    /** 
     * Set Id.
     * 
     * Este metodo atribui um valor para o id
     * @param id Valor int a ser atribuido.
    */
    public void setId(int id){
        this.id = id;
    }

    /** 
     * Set Id.
     * 
     * Este metodo atribui um valor para o id
     * @param id Valor String a ser atribuido.
    */
    public void setId(String id){
        this.id = getValidNumber(id);
    }

    /** 
     * Get Id.
     * 
     * Este metodo retorna o valor id
    */    
    public int getId(){
        return id;
    }

    /** 
     * Set Nome.
     * 
     * Este metodo atribui um valor para o nome
     * @param nome Valor String a ser atribuido.
    */  
    public void setNome(String nome){
        this.nome = getValidString(nome);
    }

    /** 
     * Get Nome.
     * 
     * Este metodo retorna o valor nome
    */ 
    public String getNome(){
        return nome;
    }

    /** 
     * Set Altura.
     * 
     * Este metodo atribui um valor para o altura
     * @param altura Valor int a ser atribuido.
    */ 
    public void setAltura(int altura){
        this.altura = altura;
    }

    /** 
     * Set Altura.
     * 
     * Este metodo atribui um valor para o altura
     * @param altura Valor String a ser atribuido.
    */ 
    public void setAltura(String altura){
        this.altura = getValidNumber(altura);
    }

    /** 
     * Get Altura.
     * 
     * Este metodo retorna o valor altura
    */ 
    public int getAltura(){
        return altura;
    }

    /** 
     * Set Peso.
     * 
     * Este metodo atribui um valor para o peso
     * @param peso Valor int a ser atribuido.
    */ 
    public void setPeso(int peso){
        this.peso = peso;
    }

    /** 
     * Set Peso.
     * 
     * Este metodo atribui um valor para o peso
     * @param peso Valor String a ser atribuido.
    */ 
    public void setPeso(String peso){
        this.peso = getValidNumber(peso);
    }

    /** 
     * Get Peso.
     * 
     * Este metodo retorna o valor peso
    */ 
    public int getPeso(){
        return peso;
    }

    /** 
     * Set Universidade.
     * 
     * Este metodo atribui um valor para o universidade
     * @param universidade Valor String a ser atribuido.
    */ 
    public void setUniversidade(String universidade){
        this.universidade = getValidString(universidade);
    }

    /** 
     * Get Universidade.
     * 
     * Este metodo retorna o valor universidade
    */ 
    public String getUniversidade(){
        return universidade;
    }

    /** 
     * Set Ano Nascimento.
     * 
     * Este metodo atribui um valor para o anoNascimento
     * @param anoNascimento Valor int a ser atribuido.
    */ 
    public void setAnoNascimento(int anoNascimento){
        this.anoNascimento = anoNascimento;
    }

    /** 
     * Set Ano Nascimento.
     * 
     * Este metodo atribui um valor para o anoNascimento
     * @param anoNascimento Valor String a ser atribuido.
    */ 
    public void setAnoNascimento(String anoNascimento){
        this.anoNascimento = getValidNumber(anoNascimento);
    }

    /** 
     * Get Ano Nascimento.
     * 
     * Este metodo retorna o valor anoNascimento
    */ 
    public int getAnoNascimento(){
        return anoNascimento;
    }

    /** 
     * Set Cidade Nascimento.
     * 
     * Este metodo atribui um valor para o cidadeNascimento
     * @param anoNascimento Valor String a ser atribuido.
    */ 
    public void setCidadeNascimento(String cidadeNascimento){
        this.cidadeNascimento = getValidString(cidadeNascimento);
    }

    /** 
     * Get Cidade Nascimento.
     * 
     * Este metodo retorna o valor cidadeNascimento
    */ 
    public String getCidadeNascimento(){
        return cidadeNascimento;
    }

    /** 
     * Set Estado Nascimento.
     * 
     * Este metodo atribui um valor para o estadoNascimento
     * @param estadoNascimento Valor String a ser atribuido.
    */ 
    public void setEstadoNascimento(String estadoNascimento){
        this.estadoNascimento = getValidString(estadoNascimento);
    }

    /** 
     * Get Estado Nascimento.
     * 
     * Este metodo retorna o valor estadoNascimento
    */ 
    public String getEstadoNascimento(){
        return estadoNascimento;
    }
    
    /** 
     * Clone.
     * 
     * Este metodo copia um Jogador para outro Jogador em um novo local na memoria.
     * @param toClone Jogador que deve ser clonado.
    */ 
    public static Jogador clone(Jogador toClone) {
        Jogador clone = new Jogador(toClone.getId(),toClone.getNome(),toClone.getAltura(),
                                    toClone.getPeso(),toClone.getUniversidade(),
                                    toClone.getAnoNascimento(),toClone.getCidadeNascimento(),
                                    toClone.getEstadoNascimento());
        return clone;
    }

    /** 
     * toString.
     * 
     * Este metodo imprime na tela todos atributos de Jogador.
    */ 
    public String toString() {
        String result = String.format("## %s ## %d ## %d ## %d ## %s ## %s ## %s ##",nome,altura,peso,anoNascimento,universidade,cidadeNascimento,estadoNascimento);

        return result;
    }

    /** 
     * Get Valid Number.
     * 
     * Este metodo converte a String em um valor inteiro valido para Jogador.
     * @param value String a ser convertida.
    */ 
    public int getValidNumber(String value){
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            //TODO: handle exception
            return -1;
        }
    }

    /** 
     * Ler.
     * 
     * Este metodo faz a leitura de uma string separada por virgulas contendo os atributos de jogador nessa ordem:
     *  Id,Nome,Altura,Peso,Universidade,AnoNascimento,CidadeNascimento,EstadoNascimento
     * @param input String a ser lida.
    */
    public static Jogador ler(String input){
        Jogador jogador = new Jogador();
        String[] inputValues = input.split(",");
        String[] values = new String[8];

        //criando um array de valores validos
        for(int i = 0; i< values.length;i++){
            if(i < inputValues.length){
                values[i] = inputValues[i];
                if(values[i].length() == 0){
                    values[i] = "";
                }
            }
            else
                values[i] = "";

        }

        jogador.setId(values[0]);
        jogador.setNome(values[1]);
        jogador.setAltura(values[2]);
        jogador.setPeso(values[3]);
        jogador.setUniversidade(values[4]);
        jogador.setAnoNascimento(values[5]);
        jogador.setCidadeNascimento(values[6]);
        jogador.setEstadoNascimento(values[7]);

        return jogador;
    }
}

/**
 * Celula (pilha, lista e fila dinamica)
 * @author Guilherme Froes Camba de Freitas
 * @version 1 10/2020
 */
class Celula {
	public Jogador elemento;
	public Celula prox; // Aponta a celula prox.


	/**
	 * Construtor da classe.
	 */
	public Celula() {
		this(null);
	}

	/**
	 * Construtor da classe.
	 * @param elemento Jogador inserido na celula.
	 */
	public Celula(Jogador elemento) {
      this.elemento = elemento;
      this.prox = null;
	}
}

/**
 * Lista dinamica
 * @author Guilherme Froes Camba de Freitas
 * @version 1 10/2020
 */
class Lista {
	private Celula primeiro;
	private Celula ultimo;


	/**
	 * Construtor da classe que cria uma lista sem elementos (somente no cabeca).
	 */
	public Lista() {
		primeiro = new Celula();
		ultimo = primeiro;
	}


	/**
	 * Insere um elemento na primeira posicao da lista.
    * @param x Jogador elemento a ser inserido.
	 */
	public void inserirInicio(Jogador x) {
		Celula tmp = new Celula(x);
      	tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if (primeiro == ultimo) {                 
			ultimo = tmp;
		}
      	tmp = null;
	}


	/**
	 * Insere um elemento na ultima posicao da lista.
    * @param x Jogador elemento a ser inserido.
	 */
	public void inserirFim(Jogador x) {
		ultimo.prox = new Celula(x);
		ultimo = ultimo.prox;
	}


	/**
	 * Remove um elemento da primeira posicao da lista.
    * @return resp Jogador elemento a ser removido.
	 * @throws Exception Se a lista nao contiver elementos.
	 */
	public Jogador removerInicio() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		}

      	Celula tmp = primeiro;
		primeiro = primeiro.prox;
		Jogador resp = primeiro.elemento;
      	tmp.prox = null;
      	tmp = null;
		return resp;
	}


	/**
	 * Remove um elemento da ultima posicao da lista.
     * @return resp Jogador elemento a ser removido.
	 * @throws Exception Se a lista nao contiver elementos.
	 */
	public Jogador removerFim() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		} 

		// Caminhar ate a penultima celula:
      	Celula i;
      	for(i = primeiro; i.prox != ultimo; i = i.prox);

      	Jogador resp = ultimo.elemento; 
      	ultimo = i; 
      	i = ultimo.prox = null;
      
		return resp;
	}


	/**
    * Insere um elemento em uma posicao especifica considerando que o 
    * primeiro elemento valido esta na posicao 0.
    * @param x Jogador elemento a ser inserido.
	* @param pos Jogador posicao da insercao.
	* @throws Exception Se <code>posicao</code> invalida.
	*/
   public void inserir(Jogador x, int pos) throws Exception {

      	int tamanho = tamanho();

      	if(pos < 0 || pos > tamanho){
			throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
      	} else if (pos == 0){
         	inserirInicio(x);
      	} else if (pos == tamanho){
         	inserirFim(x);
      	} else {
		   	// Caminhar ate a posicao anterior a insercao
         	Celula i = primeiro;
         	for(int j = 0; j < pos; j++, i = i.prox);
		
         	Celula tmp = new Celula(x);
         	tmp.prox = i.prox;
         	i.prox = tmp;
         	tmp = i = null;
      	}
   }


	/**
    * Remove um elemento de uma posicao especifica da lista
    * considerando que o primeiro elemento valido esta na posicao 0.
	* @param posicao Meio da remocao.
    * @return resp Jogador elemento a ser removido.
	* @throws Exception Se <code>posicao</code> invalida.
	*/
	public Jogador remover(int pos) throws Exception {
      	Jogador resp;
      	int tamanho = tamanho();

		if (primeiro == ultimo){
			throw new Exception("Erro ao remover (vazia)!");

      	} else if(pos < 0 || pos >= tamanho){
			throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
      	} else if (pos == 0){
        	resp = removerInicio();
      	} else if (pos == tamanho - 1){
         	resp = removerFim();
      	} else {
		   // Caminhar ate a posicao anterior a insercao
         	Celula i = primeiro;
         	for(int j = 0; j < pos; j++, i = i.prox);
		
         	Celula tmp = i.prox;
         	resp = tmp.elemento;
         	i.prox = tmp.prox;
         	tmp.prox = null;
         	i = tmp = null;
      	}

		return resp;
	}

	/**
	 * Mostra os elementos da lista separados por espacos.
	 */
	public void mostrar() {
        int index = 0;
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.println(String.format("[%d] %s",index++,i.elemento));
            
		}
	}

	/**
	 * Procura um elemento e retorna se ele existe.
	 * @param x Elemento a pesquisar.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(Jogador x) {
		boolean resp = false;
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
         	if(i.elemento == x){
            	resp = true;
            	i = ultimo;
         	}
		}
		return resp;
	}

	/**
	 * Calcula e retorna o tamanho, em numero de elementos, da lista.
	 * @return resp Jogador tamanho
	 */
   	public int tamanho() {
      	int tamanho = 0; 
      	for(Celula i = primeiro; i != ultimo; i = i.prox, tamanho++);
      	return tamanho;
   	}
}

class TP03Q05_ListaAlocacaoFlexivel{

    static int comparacion = 0;
    static int movement = 0;

    static Lista jogadores;

    /** 
    * Get Players From File.
    * 
    * Este metodo retorna todos um array de string contendo em cada indice um jogador.
    */
    public static String[] getPlayersFromFile(){

        String fileContent = Arq.openReadClose("/tmp/players.csv");

        return fileContent.split("\\n");
    }

    /** 
     * Is Fim.
     * 
     * Este metodo retorna verdadeiro quando a String alvo possui a palavra FIM.
     * @param targetString String alvo.
    */ 
    public static boolean isFim(String targetString){
        return (targetString.length() == 3 && targetString.charAt(0) == 'F' && targetString.charAt(1) == 'I' && targetString.charAt(2) == 'M');
    }
    
    public static void main(String[] args)throws Exception{

        String[] entrada = new String[1000];
        int numEntrada = 0;
        
        
        String[] players = getPlayersFromFile();
        
        //Leitura da entrada primeira entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM
        
        jogadores = new Lista();
        
        //Para cada linha de entrada
        for(int i = 0; i < numEntrada; i++){
            
            String playerData = players[Integer.parseInt(entrada[i])+1];
            
            Jogador j = Jogador.ler(playerData);

            jogadores.inserirFim(j);
            
        }   
        
        
        
        numEntrada = MyIO.readInt();

        for(int i = 0; i < numEntrada; i++){

            String operation = MyIO.readLine();
            
            String[] inputValues = operation.split(" ");

            int index = -1;
            int pos = -1;

            Jogador j = null;

            switch (inputValues[0]) {

                case "II":
                    index = Integer.parseInt(inputValues[1])+1;

                    j = Jogador.ler(players[index]);

                    jogadores.inserirInicio(j);
                    
                    break;

                case "IF":

                    index = Integer.parseInt(inputValues[1])+1;

                    j = Jogador.ler(players[index]);

                    jogadores.inserirFim(j);
                    
                    break;

                case "I*":

                    pos = Integer.parseInt(inputValues[1]);

                    index = Integer.parseInt(inputValues[2])+1;

                    j = Jogador.ler(players[index]);

                    jogadores.inserir(j,pos);
                    
                    break;

                case "RI":

                    j = jogadores.removerInicio();

                    MyIO.println(String.format("(R) %s",j.getNome()));
                    
                    break;

                case "RF":

                    j = jogadores.removerFim();

                    MyIO.println(String.format("(R) %s",j.getNome()));

                    break;

                case "R*":

                    pos = Integer.parseInt(inputValues[1]);

                    j = jogadores.remover(pos);

                    MyIO.println(String.format("(R) %s",j.getNome()));
                    
                    break;
            
                default:
                    break;
            }
            
        }  

        jogadores.mostrar(); 

    }
    
}