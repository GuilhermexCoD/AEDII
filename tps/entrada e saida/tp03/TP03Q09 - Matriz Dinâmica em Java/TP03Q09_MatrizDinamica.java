//Curso: Ciencia da Computacao / Tarde
//Universidade: PUC Minas
//Materia: AEDII Lab
//Aluno: Guilherme Froes Camba de Freitas
//Matricula: 718116

import java.io.*;
import java.nio.charset.*;

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
 * Celula 
 * @author Guilherme Froes Camba de Freitas
 * @version 1 10/2020
 */
class Celula {
    public int elemento;
    public Celula inf, sup, esq, dir;
 
    public Celula(){
       this(0, null, null, null, null);
    }
 
    public Celula(int elemento){
       this(elemento, null, null, null, null);
    }
 
    public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir){
       this.elemento = elemento;
       this.inf = inf;
       this.sup = sup;
       this.esq = esq;
       this.dir = dir;
    }
}

/**
 * Matriz
 * @author Guilherme Froes Camba de Freitas
 * @version 1 10/2020
 */
class Matriz {
    public Celula inicio;
    private int linha, coluna;
 
    public Matriz (){
        this.linha = this.coluna = 3;
 
       //alocar a matriz com this.linha linhas e this.coluna colunas
    }
 
    public Matriz (int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
 
       //alocar a matriz com this.linha linhas e this.coluna colunas
    }

    public void inserir(Celula i){
        if(inicio != null){
            inicio = inserir(inicio,inicio,i,1,1);
        }else{
            inicio = i;
        }
    }

    public Celula inserir(Celula inicioLinha,Celula actual,Celula desired, int currentLine,int currentColumn){
        Celula result = null;

        if(actual != null){
            if(currentColumn < this.coluna){
                result = actual;
                if(actual.dir == null){
                    actual.dir = desired;
                    desired.esq = actual;
                    //possui elemento superior
                    if(actual.sup != null){
                        Celula up = actual.sup.dir;
                        up.inf = desired;
                        desired.sup = up;
                    }

                    if(actual.inf != null){
                        Celula down = actual.inf.dir;
                        down.sup = desired;
                        desired.inf = down;
                    }

                }else{
                    actual.dir = inserir(inicioLinha,actual.dir,desired,currentLine,currentColumn+1);
                    
                }
            }else{
                //chegou no final da coluna
                result = inicioLinha;

                if(currentLine < this.linha){
                    if(inicioLinha.inf != null){
                        inicioLinha = inserir(inicioLinha.inf,inicioLinha.inf,desired,currentLine+1,1);
                    }else{
                        inicioLinha.inf = desired;
                        desired.sup = inicioLinha;
                    }
                }else{
                    MyIO.println(String.format("Matriz cheia, nao foi possivel inserir : %d",desired.elemento));
                }
            }
        }

        return actual;
    }
 
    public Matriz soma (Matriz m) {
        Matriz resp = null;
 
        if(this.linha == m.linha && this.coluna == m.coluna){
            resp = new Matriz(this.linha,this.coluna);
            Celula walker = inicio;
            Celula otherWalker = m.inicio;

            for(int currentLine = 0; currentLine < this.linha; currentLine++){
                for(int currentColumn = 0; currentColumn < this.coluna; currentColumn++){
                    
                    Celula resultCelula = soma(walker, otherWalker);

                    resp.inserir(resultCelula);

                    if(walker.dir != null)
                        walker = walker.dir;

                    if(otherWalker.dir != null)
                        otherWalker = otherWalker.dir;
                }

                walker = reachMaxLeft(walker).inf;
                otherWalker = reachMaxLeft(otherWalker).inf;

            }
            
        }
 
        return resp;
    }

    public Celula reachMaxLeft(Celula i){
        if(i.esq != null)
            i = reachMaxLeft(i.esq);

        return i;
    }

    public Celula reachMaxRight(Celula i){
        if(i.dir != null)
            i = reachMaxRight(i.dir);

        return i;
    }


    public Celula soma(Celula a, Celula b){
        int valor = a.elemento + b.elemento;
        Celula result = new Celula(valor);
        return result;
    }

    public int multiplicacao(Celula a,Celula b){
        int value = a.elemento * b.elemento;
        if(a.dir != null && b.inf != null){
            value += multiplicacao(a.dir,b.inf);
        }
        return value;
    }

    public Matriz multiplicacao (Matriz m) {
        Matriz resp = null;
 
        if(this.coluna == m.linha){
            resp = new Matriz(this.linha,m.coluna);
            Celula walker = inicio;
            Celula otherWalker = m.inicio;

            for(int currentLine = 0; currentLine < this.linha; currentLine++){

                for(int currentColumn = 0; currentColumn < m.coluna; currentColumn++){
                    int value = multiplicacao(walker,otherWalker);

                    Celula resultCelula = new Celula(value);
                    
                    resp.inserir(resultCelula);

                    if(otherWalker.dir != null)
                        otherWalker = otherWalker.dir;
                }

                if(walker.dir != null){
                    walker = walker.inf;
                    otherWalker = m.inicio;
                }

            }
        }
 
        return resp;
    }
 
    public boolean isQuadrada(){
        return (this.linha == this.coluna);
    }
 
    public void mostrarDiagonalPrincipal (){
        if(isQuadrada() == true){
           mostrarDiagonalPrincipal(inicio); 
        }
        MyIO.print("\n");
    }

    public void mostrarDiagonalPrincipal (Celula i){
        MyIO.print(String.format("%d ",i.elemento));
        if(i.dir != null && i.dir.inf != null){
            mostrarDiagonalPrincipal(i.dir.inf);
        }
    }
 
    public void mostrarDiagonalSecundaria (){
        if(isQuadrada() == true){
            Celula i = reachMaxRight(inicio);
            mostrarDiagonalSecundaria(i);
        }
        MyIO.print("\n");
    }

    public void mostrarDiagonalSecundaria (Celula i){
        MyIO.print(String.format("%d ",i.elemento));
        if(i.esq != null && i.esq.inf != null){
            mostrarDiagonalSecundaria(i.esq.inf);
        }
    }

    public void mostrar(){
        mostrar(inicio,inicio,false);
    }

    public void mostrar(Celula inicioLinha,Celula i,boolean reachFinal){
        boolean stopCondition = (inicioLinha == i && reachFinal);

        if(!stopCondition){
            if(i != null){
                if(!reachFinal)
                    MyIO.print(i.elemento+" ");
                
                mostrar(inicioLinha,i.dir,reachFinal);
            }else{
                MyIO.println("");
                reachFinal = !reachFinal;
                mostrar(inicioLinha,inicioLinha,reachFinal);
            }
        }else{
            if(inicioLinha.inf != null){
                mostrar(inicioLinha.inf,inicioLinha.inf,!reachFinal);
            }
        }
    }
}


class TP03Q09_MatrizDinamica{

    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));

    public static String readLine(){
        String s = "";
        char tmp;
        try{
           do{
              tmp = (char)in.read();
              if(tmp != '\n' && tmp != 13 && tmp != 65535){
                 s += tmp;
              }
           }while(tmp != '\n' && tmp != 65535);
        }catch(IOException ioe){
           System.out.println("lerPalavra: " + ioe.getMessage());
        }
        return s;
    }

    public static Matriz getMatriz(){
        int lines = Integer.parseInt(MyIO.readLine());
        int columns = Integer.parseInt(MyIO.readLine());
        
        Matriz matriz = new Matriz(lines,columns);

        for(int l = 0;l < lines;l++){
            String line =  MyIO.readLine();
            String[] values = line.split(" ");

            for(int v = 0;v < values.length;v++){
                int value = Integer.parseInt(values[v]);
                Celula celula = new Celula(value);
                matriz.inserir(celula);
            }
        }

        return matriz;
    }
    
    public static void main(String[] args)throws Exception{

        int matrixNumbers = Integer.parseInt(MyIO.readLine());

        for(int i = 0;i < matrixNumbers;i++){

            Matriz matrizA = getMatriz();
            Matriz matrizB = getMatriz();

            Matriz soma = null;
            Matriz multiplicacao = null;

            matrizA.mostrarDiagonalPrincipal();
            matrizA.mostrarDiagonalSecundaria();
            
            soma = matrizA.soma(matrizB);
            soma.mostrar();
            multiplicacao = matrizA.multiplicacao(matrizB);
            multiplicacao.mostrar();

        }

    }
    
}