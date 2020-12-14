//Curso: Ciencia da Computacao / Tarde
//Universidade: PUC Minas
//Materia: AEDII Lab
//Aluno: Guilherme Froes Camba de Freitas
//Matricula: 718116

class TP01Q06Is{

    /** 
    * Is Lower Case.
    * 
    * Este metodo retorna True se o caractere em questao for minusculo.
    * @param value caractere alvo.
    */
    public static boolean isLowerCase(char value){
        
        if(!isLetter(value))
            return false;
    
        boolean lowerCase = false;
        int decimalChar = value;
        
        if(decimalChar >= 97 && decimalChar <= 122){
            lowerCase = true;
        }
        
        return lowerCase;
    }
    
    /** 
    * To Upper Case.
    * 
    * Este metodo recebe um char e retorna o em letra maiuscula.
    * @param letter char alvo.
    */  
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
    * To Upper Case.
    * 
    * Este metodo recebe uma String e retorna todos seus caracteres em letras maiusculas.
    * @param text String alvo.
    */  
    public static String toUpperCase(String text){
        
        String upperCaseText = "";
        
        for(int i = 0; i < text.length(); i++){
            char item = text.charAt(i);
          
            int decimalChar = item;
          
            if(isLowerCase(item)){
                item = (char)(decimalChar - 32);
                upperCaseText += item;
            
            }else{
                upperCaseText += item;
            }
        }
        
        return upperCaseText;
    }

    /** 
     * Is Integer.
     * 
     * Este metodo retorna True se o char em questao for um numero inteiro.
     * @param value char alvo.
     */
    public static boolean isInteger(char value){
        
        int decimalChar = value;
        
        if(decimalChar >= 48 && decimalChar <= 57){
            return true;
        }
        return false;

    }

    /** 
     * Is Integer.
     * 
     * Este metodo retorna True se a String em questao for um numero inteiro.
     * @param value String alvo.
     */
    public static boolean isInteger(String value){
        
        boolean result = true;

        for(int i = 0; i < value.length(); i++){
            char item = value.charAt(i);
          
            if(!isInteger(item)){
                result = false;
                break;
            }

        }
        
        return result;

    }

    /** 
     * Is Real.
     * 
     * Este metodo retorna True se a String em questao for um numero real.
     * @param value String alvo.
     */
    public static boolean isReal(String value){
        
        boolean result = true;

        int realCount = 0;

        for(int i = 0; i < value.length(); i++){
            char item = value.charAt(i);
          
            if(!isInteger(item)){
                //um numero real pode ter a aparicao de apenas um separador
                if(realCount < 1 && (item == '.' || item == ',')){
                    realCount++;
                }else{
                    result = false;
                    break;
                }
                
            }

        }
        
        return result;

    }

    /** 
     * Is Letter.
     * 
     * Este metodo retorna True se o caractere em questao eh uma letra de acordo com a tabela ASCII.
     * @param value caractere alvo.
     */
    public static boolean isLetter(char value){
        int decimalChar = value;
        
        if((decimalChar >= 65 && decimalChar <= 90) || (decimalChar >= 97 && decimalChar <= 122) ){
            return true;
        }
        return false;
    }
    
    /** 
    * Is Vowel.
    * 
    * Este metodo retorna True se todos elementos da String forem uma vogal.
    * @param value String alvo.
    */
    public static boolean isVowel(String value){
        int stringSize = value.length();
        int vowelCount = getVowelCount(value);

        return (stringSize == vowelCount);
    }

    /** 
    * Is Consonant.
    * 
    * Este metodo retorna True se todos elementos da String forem uma consoante.
    * @param value String alvo.
    */
    public static boolean isConsonant(String value){
        int stringSize = value.length();
        int consonantCount = getConsonantCount(value);

        return (stringSize == consonantCount);
    }    
    
    /** 
    * is Vowel.
    * 
    * Este metodo retorna True se o caractere em questao eh uma vogal.
    * @param value caractere alvo.
    */
    public static boolean isVowel(char value){
        if(!isLetter(value))
            return false;

        char upperValue = toUpperCase(value);
    
        int decimalChar = upperValue;

        if(decimalChar == 65 || decimalChar == 69 || decimalChar == 73 || decimalChar == 79 || decimalChar == 85){
            return true;
        }

        return false;
    
    }

        /** 
    * Get Consonant Count.
    * 
    * Este metodo retorna a contagem de consoantes da String alvo.
    * @param value String alvo.
    */
    public static int getConsonantCount(String value){

        return getConsonantCount(value,0);
    }

    /** 
    * Get Consonant Count.
    * 
    * Este metodo recursivo retorna a contagem de consoantes da String alvo.
    * @param value String alvo.
    * @param index indice para verificar se eh consoantes.
    */
    public static int getConsonantCount(String value,int index){
        int count = 0;

        if(index < value.length()){
            char letter = value.charAt(index);

            //nao verifica se eh uma letra, tudo que nao for vogal agora eh consoante
            if(isLetter(letter) && !isVowel(letter)){
                count ++;
            }
            count += getConsonantCount(value,index + 1);
        }

        return count;
    }

    /** 
    * Get Vowel Count.
    * 
    * Este metodo retorna a contagem de vogais da String alvo.
    * @param value String alvo.
    */
    public static int getVowelCount(String value){

        return getVowelCount(value,0);
    }

    /** 
    * Get Vowel Count.
    * 
    * Este metodo recursivo retorna a contagem de vogais da String alvo.
    * @param value String alvo.
    * @param index indice para verificar se eh vogal.
    */
    public static int getVowelCount(String value,int index){
        int count = 0;

        if(index < value.length()){
            char letter = value.charAt(index);
            if(isVowel(letter)){
                count ++;
            }
            count += getVowelCount(value,index + 1);
        }

        return count;
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
            
            MyIO.println((isVowel(entrada[i])?"SIM":"NAO")+" "+(isConsonant(entrada[i])?"SIM":"NAO")+" "+(isInteger(entrada[i])?"SIM":"NAO")+" "+(isReal(entrada[i])?"SIM":"NAO"));
        }
        

    }

}