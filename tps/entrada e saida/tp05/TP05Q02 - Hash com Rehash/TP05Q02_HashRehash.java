
//Curso: Ciencia da Computacao / Tarde
//Universidade: PUC Minas
//Materia: AEDII Lab
//Aluno: Guilherme Froes Camba de Freitas
//Matricula: 718116

import java.io.*;
import java.nio.charset.*;

class Jogador {

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
     * 
     * @param id               int id do jogador.
     * @param nome             String nome do jogador.
     * @param altura           int altura do jogador.
     * @param peso             int peso do jogador.
     * @param universidade     String universidade do jogador.
     * @param anoNascimento    int anoNascimento do jogador.
     * @param cidadeNascimento String cidadeNascimento do jogador.
     * @param estadoNascimento String estadoNascimento do jogador.
     */
    public Jogador(int id, String nome, int altura, int peso, String universidade, int anoNascimento,
            String cidadeNascimento, String estadoNascimento) {
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
     * 
     * @param value String que deve ser convertida para um valor valido.
     */
    public String getValidString(String value) {
        if (value == "")
            return "nao informado";

        return value;
    }

    /**
     * Set Id.
     * 
     * Este metodo atribui um valor para o id
     * 
     * @param id Valor int a ser atribuido.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set Id.
     * 
     * Este metodo atribui um valor para o id
     * 
     * @param id Valor String a ser atribuido.
     */
    public void setId(String id) {
        this.id = getValidNumber(id);
    }

    /**
     * Get Id.
     * 
     * Este metodo retorna o valor id
     */
    public int getId() {
        return id;
    }

    /**
     * Set Nome.
     * 
     * Este metodo atribui um valor para o nome
     * 
     * @param nome Valor String a ser atribuido.
     */
    public void setNome(String nome) {
        this.nome = getValidString(nome);
    }

    /**
     * Get Nome.
     * 
     * Este metodo retorna o valor nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Set Altura.
     * 
     * Este metodo atribui um valor para o altura
     * 
     * @param altura Valor int a ser atribuido.
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * Set Altura.
     * 
     * Este metodo atribui um valor para o altura
     * 
     * @param altura Valor String a ser atribuido.
     */
    public void setAltura(String altura) {
        this.altura = getValidNumber(altura);
    }

    /**
     * Get Altura.
     * 
     * Este metodo retorna o valor altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * Set Peso.
     * 
     * Este metodo atribui um valor para o peso
     * 
     * @param peso Valor int a ser atribuido.
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * Set Peso.
     * 
     * Este metodo atribui um valor para o peso
     * 
     * @param peso Valor String a ser atribuido.
     */
    public void setPeso(String peso) {
        this.peso = getValidNumber(peso);
    }

    /**
     * Get Peso.
     * 
     * Este metodo retorna o valor peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * Set Universidade.
     * 
     * Este metodo atribui um valor para o universidade
     * 
     * @param universidade Valor String a ser atribuido.
     */
    public void setUniversidade(String universidade) {
        this.universidade = getValidString(universidade);
    }

    /**
     * Get Universidade.
     * 
     * Este metodo retorna o valor universidade
     */
    public String getUniversidade() {
        return universidade;
    }

    /**
     * Set Ano Nascimento.
     * 
     * Este metodo atribui um valor para o anoNascimento
     * 
     * @param anoNascimento Valor int a ser atribuido.
     */
    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    /**
     * Set Ano Nascimento.
     * 
     * Este metodo atribui um valor para o anoNascimento
     * 
     * @param anoNascimento Valor String a ser atribuido.
     */
    public void setAnoNascimento(String anoNascimento) {
        this.anoNascimento = getValidNumber(anoNascimento);
    }

    /**
     * Get Ano Nascimento.
     * 
     * Este metodo retorna o valor anoNascimento
     */
    public int getAnoNascimento() {
        return anoNascimento;
    }

    /**
     * Set Cidade Nascimento.
     * 
     * Este metodo atribui um valor para o cidadeNascimento
     * 
     * @param anoNascimento Valor String a ser atribuido.
     */
    public void setCidadeNascimento(String cidadeNascimento) {
        this.cidadeNascimento = getValidString(cidadeNascimento);
    }

    /**
     * Get Cidade Nascimento.
     * 
     * Este metodo retorna o valor cidadeNascimento
     */
    public String getCidadeNascimento() {
        return cidadeNascimento;
    }

    /**
     * Set Estado Nascimento.
     * 
     * Este metodo atribui um valor para o estadoNascimento
     * 
     * @param estadoNascimento Valor String a ser atribuido.
     */
    public void setEstadoNascimento(String estadoNascimento) {
        this.estadoNascimento = getValidString(estadoNascimento);
    }

    /**
     * Get Estado Nascimento.
     * 
     * Este metodo retorna o valor estadoNascimento
     */
    public String getEstadoNascimento() {
        return estadoNascimento;
    }

    /**
     * Clone.
     * 
     * Este metodo copia um Jogador para outro Jogador em um novo local na memoria.
     * 
     * @param toClone Jogador que deve ser clonado.
     */
    public static Jogador clone(Jogador toClone) {
        Jogador clone = new Jogador(toClone.getId(), toClone.getNome(), toClone.getAltura(), toClone.getPeso(),
                toClone.getUniversidade(), toClone.getAnoNascimento(), toClone.getCidadeNascimento(),
                toClone.getEstadoNascimento());
        return clone;
    }

    /**
     * toString.
     * 
     * Este metodo imprime na tela todos atributos de Jogador.
     */
    public String toString() {
        String result = String.format("## %s ## %d ## %d ## %d ## %s ## %s ## %s ##", nome, altura, peso, anoNascimento,
                universidade, cidadeNascimento, estadoNascimento);

        return result;
    }

    /**
     * Get Valid Number.
     * 
     * Este metodo converte a String em um valor inteiro valido para Jogador.
     * 
     * @param value String a ser convertida.
     */
    public int getValidNumber(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            // TODO: handle exception
            return -1;
        }
    }

    /**
     * Ler.
     * 
     * Este metodo faz a leitura de uma string separada por virgulas contendo os
     * atributos de jogador nessa ordem:
     * Id,Nome,Altura,Peso,Universidade,AnoNascimento,CidadeNascimento,EstadoNascimento
     * 
     * @param input String a ser lida.
     */
    public static Jogador ler(String input) {
        Jogador jogador = new Jogador();
        String[] inputValues = input.split(",");
        String[] values = new String[8];

        // criando um array de valores validos
        for (int i = 0; i < values.length; i++) {
            if (i < inputValues.length) {
                values[i] = inputValues[i];
                if (values[i].length() == 0) {
                    values[i] = "";
                }
            } else
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

class Hash {
    Jogador tabela[];
    int memoriaPrincipal;

    public Hash() {
        this(13);
    }

    public Hash(int memoriaPrincipal) {
        this.memoriaPrincipal = memoriaPrincipal;
        this.tabela = new Jogador[this.memoriaPrincipal];
        for (int i = 0; i < memoriaPrincipal; i++) {
            tabela[i] = null;
        }
    }

    public int h(int elemento) {
        return elemento % memoriaPrincipal;
    }

    public int reh(int elemento) {
        return (elemento + 1) % memoriaPrincipal;
    }

    public boolean inserir(Jogador elemento) {
        boolean resp = false;

        if (elemento != null) {

            int pos = h(elemento.getAltura());

            //MyIO.print(String.format(" Hash: %d", pos));

            if (tabela[pos] == null) {
                //MyIO.print(String.format(" Empty Hash: %d", pos));

                tabela[pos] = Jogador.clone(elemento);
                resp = true;

            } else {

                pos = reh(elemento.getAltura());
                //MyIO.print(String.format(" ReHash: %d", pos));

                if (tabela[pos] == null) {

                    //MyIO.print(String.format(" Empty ReHash: %d", pos));

                    tabela[pos] = Jogador.clone(elemento);
                    resp = true;
                }

            }
        }
        //MyIO.print("\n");

        return resp;
    }

    public boolean pesquisar(Jogador elemento) {
        boolean resp = false;

        int pos = h(elemento.getAltura());

        if (tabela[pos] != null && tabela[pos].getNome().compareTo(elemento.getNome()) == 0) {
            resp = true;

        } else {

            pos = reh(elemento.getAltura());

            if (tabela[pos] != null && tabela[pos].getNome().compareTo(elemento.getNome()) == 0 ) {
                resp = true;
            }

        }
        return resp;
    }

}

class TP05Q02_HashRehash {

    /**
     * Get Players From File.
     * 
     * Este metodo retorna todos um array de string contendo em cada indice um
     * jogador.
     */
    public static String[] getPlayersFromFile() {

        String fileContent = Arq.openReadClose("/tmp/players.csv");

        return fileContent.split("\\n");
    }

    public static Jogador getJogadorFromNome(String nome, String[] jogadores) {
        Jogador resp = null;

        for (int i = 0; i < jogadores.length && resp == null; i++) {

            Jogador tmp = Jogador.ler(jogadores[i]);

            if (tmp.getNome().contains(nome)) {
                resp = Jogador.clone(tmp);
            }

        }

        return resp;
    }

    /**
     * Is Fim.
     * 
     * Este metodo retorna verdadeiro quando a String alvo possui a palavra FIM.
     * 
     * @param targetString String alvo.
     */
    public static boolean isFim(String targetString) {
        return (targetString.length() == 3 && targetString.charAt(0) == 'F' && targetString.charAt(1) == 'I'
                && targetString.charAt(2) == 'M');
    }

    private static BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));

    public static String readLine() {
        String s = "";
        char tmp;
        try {
            do {
                tmp = (char) in.read();
                if (tmp != '\n' && tmp != 13 && tmp != 65535) {
                    s += tmp;
                }
            } while (tmp != '\n' && tmp != 65535);
        } catch (IOException ioe) {
            System.out.println("lerPalavra: " + ioe.getMessage());
        }
        return s;
    }

    public static void main(String[] args) throws Exception {

        Hash hash = new Hash(25);

        String[] players = getPlayersFromFile();

        String line;

        MyIO.setCharset("UTF-8");

        line = MyIO.readLine("");

        while (!isFim(line)) {
            int id = Integer.parseInt(line) + 1;

            String playerData = players[id];

            Jogador tmp = Jogador.ler(playerData);

            boolean hasInserted = hash.inserir(tmp);

            //MyIO.println(String.format("%b : %s : %d", hasInserted,tmp.getNome(),tmp.getAltura()%25));

            line = MyIO.readLine("");
        }

        line = MyIO.readLine("");

        while (!isFim(line)) {
            String nomeJogador = line;

            Jogador tmp = getJogadorFromNome(nomeJogador, players);

            if (tmp != null) {

                boolean found = hash.pesquisar(tmp);

                String resp = String.format("%s %s", nomeJogador, ((found) ? "SIM" : "NAO"));

                MyIO.println(resp);

            } else {
                MyIO.println("Nome: " + nomeJogador);
            }

            line = MyIO.readLine("");

        }

    }

}