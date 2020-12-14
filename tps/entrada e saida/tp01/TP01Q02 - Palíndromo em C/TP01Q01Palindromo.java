//Curso: Ciencia da Computacao / Tarde
//Universidade: PUC Minas
//Materia: AEDII Lab
//Aluno: Guilherme Froes Camba de Freitas
//Matricula: 718116

class TP01Q01Palindromo{

    /** 
    * Is Palindromo.
    * 
    * Este metodo inicia a recurcao para verificacao da String para Palindromo
    * @param targetString String alvo.
    */
    public static boolean isPalindromo(String targetString){
        //Observando o codigo Pub.out deste exercicio verificamos que Caracteres Maiusculos e Minusculos sao considerados diferentes.
        //Nao sendo necessario converter para letras Maiusculas.
        boolean resp = false;

        for(int index = 0; index < targetString.length();index++){
            
            if(index >= targetString.length()/2){
                //Quando chegarmos ao meio da String signfica que terminamos nossa busca e ate o momento nossa String eh um Palindromo
                resp = true;
            }else if(targetString.charAt(index) != targetString.charAt(targetString.length()-1 -index)){
                //Se os caracteres inicial e final forem diferentes esta String NAO eh um Palindromo
                resp = false;
                break;
            }
        }

        return resp;
    }

    public static boolean isFim(String targetString){
        return (targetString.length() > 3 && targetString.charAt(0) == 'F' && targetString.charAt(1) == 'I' && targetString.charAt(2) == 'M');
    }

    public static void main(String[] args){
        String[] entrada = new String[1000];
        int numEntrada = 0;

        //Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
            numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

        //Para cada linha de entrada, gerando uma de saida contendo SIM para palavras Palindromas e NAO caso contrario
        for(int i = 0; i < numEntrada; i++){
            MyIO.println(isPalindromo(entrada[i])?"SIM":"NAO");
        }

    }

}