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
     * Imprimir.
     * 
     * Este metodo imprime na tela todos atributos de Jogador.
    */ 
    public void imprimir(){
        String result = String.format("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]",id,nome,altura,peso,anoNascimento,universidade,cidadeNascimento,estadoNascimento);
        MyIO.println(result);
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

class TP02Q13_Mergesort{

    static int comparacion = 0;
    static int movement = 0;

    static Jogador[] jogadores;

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
    
    public static void main(String[] args){

        String[] entrada = new String[1000];
        int numEntrada = 0;
        
        
        String[] players = getPlayersFromFile();
        
        //Leitura da entrada primeira entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM
        
        jogadores = new Jogador[numEntrada];
        
        //Para cada linha de entrada
        for(int i = 0; i < numEntrada; i++){
            
            String playerData = players[Integer.parseInt(entrada[i])+1];
            
            jogadores[i] = Jogador.ler(playerData);
            
            //jogadores[i].imprimir();
            
        }   
        
        //leitura da pesquisa sequencial
        comparacion = 0;    
        
        long tempoInicial = System.currentTimeMillis();
        //metodo de ordenacao
        jogadores = sortSelection(jogadores);

        jogadores = sortMerge(jogadores);

        long tempoFinal = System.currentTimeMillis();
        
        printJogadores(jogadores);        
        
        String result = (String.format("718116\t%.3f\t%d\t%d",(tempoFinal-tempoInicial)/1000d,comparacion,movement));
        
        Arq.openWriteClose("718116_countingsort.txt",result);
        
    }     

    public static void printJogadores(Jogador[] jogadores){
        for (int i = 0; i < jogadores.length; i++) {
            if(jogadores[i] != null){
                jogadores[i].imprimir();
            }
        }
    }

    public static void swap(Jogador[] jogadores,int i, int j) {
        Jogador temp = Jogador.clone(jogadores[i]);
        jogadores[i] = jogadores[j];
        jogadores[j] = temp;
        movement += 3;

    }

    public static Jogador[] sortSelection(Jogador[] jogadores) {
        
        int n = jogadores.length;
        
        for (int i = 0; i < (n - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < n; j++){

                String nomeMenor = jogadores[menor].getNome();
                String nomeMaior = jogadores[j].getNome();
                int isMore = nomeMenor.compareTo(nomeMaior);

                comparacion ++;
                if (isMore > 0){
                    menor = j;
                }
            }
            swap(jogadores,menor, i);
        }

        return jogadores;
    }
    
    public static Jogador[] sortMerge(Jogador[] jogadores) {

        int n = jogadores.length;

        mergesort(0, n-1);

        return jogadores;
    }

    /**
    * Algoritmo de ordenacao Mergesort.
    * @param int esq inicio do array a ser ordenado
    * @param int dir fim do array a ser ordenado
    */
    private static void mergesort(int esq, int dir) {
        //MyIO.println(String.format("Esq: %d | Dir: %d",esq,dir));
        
        //MyIO.println(String.format("(%d < %d) = %b",esq,dir,(esq < dir)));
        
        if (esq < dir){
            int meio = (esq + dir) / 2;

            //MyIO.println(String.format("meio: %d",meio));

            //MyIO.println(String.format("Merge ESQ(%d,%d)",esq,meio));
            mergesort(esq, meio);
            //MyIO.println(String.format("Merge DIR(%d,%d)",meio+1,dir));
            mergesort(meio + 1, dir);
            //MyIO.println(String.format("Intercalando"));
            intercalar(esq, meio, dir);
        }

    }

    /**
    * Algoritmo que intercala os elementos entre as posicoes esq e dir
    * @param int esq inicio do array a ser ordenado
    * @param int meio posicao do meio do array a ser ordenado
    * @param int dir fim do array a ser ordenado
    */ 
    public static void intercalar(int esq, int meio, int dir){
        int n1, n2, i, j, k;
  
        //Definir tamanho dos dois subarrays
        n1 = meio-esq+1;
        n2 = dir - meio;
  
        Jogador[] a1 = new Jogador[n1+1];
        Jogador[] a2 = new Jogador[n2+1];
  
        //Inicializar primeiro subarray
        for(i = 0; i < n1; i++){
            a1[i] = Jogador.clone(jogadores[esq+i]);
        }
        //Inicializar segundo subarray
        for(j = 0; j < n2; j++){
            a2[j] = Jogador.clone(jogadores[meio+j+1]);;
        }
        //Sentinela no final dos dois arrays
        Jogador biggerJogador = new Jogador();
        biggerJogador.setUniversidade("zzz");
        a1[i] = a2[j] = Jogador.clone(biggerJogador);
        
        //MyIO.println("Primeiro vetor");
        //printJogadores(a1);
        //MyIO.println("Segundo vetor");
        //printJogadores(a2);

        //Intercalacao propriamente dita
        for(i = j = 0, k = esq; k <= dir; k++){
            String universidadeMenor = a1[i].getUniversidade();
            String universidadeMaior = a2[j].getUniversidade();
            int compString = universidadeMenor.compareTo(universidadeMaior);

            //MyIO.println(String.format("(%s e %s)(%d > 0) = %b",universidadeMenor,universidadeMaior,compString,(compString > 0)));

            if(compString <= 0){
                jogadores[k] = Jogador.clone(a1[i++]);
            }else{
                jogadores[k] = Jogador.clone(a2[j++]);
            }
        }
    }
}