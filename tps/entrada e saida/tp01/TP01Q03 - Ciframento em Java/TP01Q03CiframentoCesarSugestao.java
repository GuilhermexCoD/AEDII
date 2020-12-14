//Curso: Ciencia da Computacao / Tarde
//Universidade: PUC Minas
//Materia: AEDII Lab
//Aluno: Guilherme Froes Camba de Freitas
//Matricula: 718116

class TP01Q03CiframentoCesar{

    public static boolean isLetter(char value){
        int decimalChar = value;
        
        if((decimalChar >= 65 && decimalChar <= 90) || (decimalChar >= 97 && decimalChar <= 122) ){
            return true;
        }
        return false;
    }

    public static boolean isLowerCase(char value){
        
        if(!isLetter(value))
            return true;
    
        boolean lowerCase = false;
        int decimalChar = value;
        
        if(decimalChar >= 97 && decimalChar <= 122){
            lowerCase = true;
        }
        
        return lowerCase;
    }

    public static char toUpperCase(char letter){
    
        char upperCaseText = letter;
          
        int decimalChar = letter;
          
        if(isLowerCase(letter)){
          
            letter = (char)(decimalChar - 32);
            upperCaseText = letter;
        }
        
        return upperCaseText;
    }

     /** 
     * Modulo.
     * 
     * This method makes a cyclic modular operation.
     * @param a dividend.
     * @param b divisor.
     */
    public static int mod(int a,int b){
        return ((a % b) + b) % b;
    }

    public static char cesarEncrypt(char letter,int k){
        //Se NAO for uma Letra nao eh necessario fazer o resto do metodo 
        
        if(!isLetter(letter))
            return letter + k;
        
        boolean lowerCase = isLowerCase(letter);
        
        //Caso char seja minusculo transformaremos em Maiusculo para facilitar os calculos futuros.
        if(lowerCase){
            letter = toUpperCase(letter);
        }
        
        //pegando o valor em do Char na tabela ASCII em decimal
        int decimalCharUpper = letter;
    
        //zerando o valor da tabela ASCII para letras Maiusculas 
        decimalCharUpper -= 65; // A = 65 entao meu novo A = 0
    
        //formula do ciframento de cesar onde K eh o numero de caracteres que vamos deslocar as letras.
        decimalCharUpper = (decimalCharUpper + k);
        decimalCharUpper = mod(decimalCharUpper,26); // (-3 + 26) % 26 => (23%26) = 23
        
        
        //Retornando o char para seu estado anterior (Minusculo ou Maiusculo)
        if(lowerCase){
            decimalCharUpper += 97;
        }else{
            decimalCharUpper += 65;
        }

        //Devemos converter o Decimal ja cifrado para char.
        letter = (char)decimalCharUpper;
    
        return letter;
    }
    
    public static String cesarEncrypt(String text,int k){
        String encryptStr = "";
    
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