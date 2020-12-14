//Curso: Ciencia da Computacao / Tarde
//Universidade: PUC Minas
//Materia: AEDII Lab
//Aluno: Guilherme Froes Camba de Freitas
//Matricula: 718116

class TP02Q01Classe{

    /** 
    * Is Palindromo.
    * 
    * Este metodo inicia a recurcao para verificacao da String para Palindromo
    * @param targetString String alvo.
    */
    public static String[] getPlayersFromFile(){

        String fileContent = Arq.openReadClose("players.csv");

        return fileContent.split("\\n");
    }

    public static boolean isFim(String targetString){
        return (targetString.length() == 3 && targetString.charAt(0) == 'F' && targetString.charAt(1) == 'I' && targetString.charAt(2) == 'M');
    }

    public static void main(String[] args){
        String[] entrada = new String[1000];
        int numEntrada = 0;
        
        //Leitura da entrada padrao
        
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
            numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

        String[] players = getPlayersFromFile();
        Jogador[] jogadores = new Jogador[numEntrada];

        
        //Para cada linha de entrada
        for(int i = 0; i < numEntrada; i++){

            //MyIO.println(String.format("Verificando jogador na linha : %d",Integer.parseInt(entrada[i])));

            String playerData = players[Integer.parseInt(entrada[i])+1];
            
            jogadores[i] = Jogador.ler(playerData);

            jogadores[i].imprimir();
   
        }
        

        /*
        MyIO.println("teste do jogador");
        Jogador teste = new Jogador();
        teste.imprimir();
        
        Jogador guilhermexcod = new Jogador(0,"Guilherme Froes",170,78,"Puc Minas",1992,"Nova Lima","MG");

        guilhermexcod.imprimir();
        
        Jogador guiClone = Jogador.clone(guilhermexcod);
        
        MyIO.println("Changing id guilhermexcod");
        guilhermexcod.setId(2);
        guilhermexcod.imprimir();

        MyIO.println("Printing clone");
        guiClone.imprimir();
        
        MyIO.println("Reading jogador");
        String input = "2107,Tony Smith,201,95,,1968,,";
        Jogador readJogador = Jogador.ler(input);
        readJogador.imprimir();
        */
        
    }

}