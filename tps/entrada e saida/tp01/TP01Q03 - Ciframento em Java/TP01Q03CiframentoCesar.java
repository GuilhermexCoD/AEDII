//Curso: Ciencia da Computacao / Tarde
//Universidade: PUC Minas
//Materia: AEDII Lab
//Aluno: Guilherme Froes Camba de Freitas
//Matricula: 718116

class TP01Q03CiframentoCesar{

    /** 
    * Modulo.
    * 
    * Este metodo ira encriptar o caractere de entrada no ciframento de Cesar .
    * @param letter caractere alvo.
    * @param k numero de caracteres que vamos deslocar as letras.
    */
    public static char cesarEncrypt(char letter,int k){

        //pegando o valor em do Char na tabela ASCII em decimal
        int decimalChar = letter;

    
        //formula do ciframento de cesar onde K eh o numero de caracteres que vamos deslocar as letras.
        decimalChar = (decimalChar + k);

        //Devemos converter o Decimal ja cifrado para char.
        letter = (char)decimalChar;
    
        return letter;
    }
    
    /** 
    * Modulo.
    * 
    * Este metodo ira encriptar a String de entrada no ciframento de Cesar .
    * @param text String alvo.
    * @param k numero de caracteres que vamos deslocar as letras.
    */
    public static String cesarEncrypt(String text,int k){
        String encryptStr = "";
        
        //Passando por todo os caracteres da string e encriptando sendo salvo na variavel encryptStr
        for(int i = 0;i < text.length();i++){
            encryptStr += cesarEncrypt(text.charAt(i),k);
        }
    
        return encryptStr;
    }

    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
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
            //Como observado no pub.in letra A se converte em D assim temos que nosso K = 3
            MyIO.println(cesarEncrypt(entrada[i],3));
        }

    }

}