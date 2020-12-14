//Curso: Ciencia da Computacao / Tarde
//Universidade: PUC Minas
//Materia: AEDII Lab
//Aluno: Guilherme Froes Camba de Freitas
//Matricula: 718116

import java.io.*;
import java.net.*;

class TP01Q08LeituraDePaginaHTML{

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
     * Is Letter.
     * 
     * Este metodo retorna True se o caractere em questao eh uma letra de acordo com a tabela ASCII.
     * @param value caractere alvo.
     */
    public static boolean isLetter(char value){
        int decimalChar = value;
        
        if(decimalChar >= 97 && decimalChar <= 122){
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

        char upperValue = value;
    
        int decimalChar = upperValue;

        if(decimalChar == 97 || decimalChar == 101 || decimalChar == 105 || decimalChar == 111 || decimalChar == 117){
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
    * Get Char Count.
    * 
    * Este metodo retorna a contagem do char da String alvo.
    * @param value String alvo.
    * @param targetsChar caracteres alvos.
    */
    public static int[] getCharCounts(String value,char[] targetsChar){
        
        int[] counts = new int[targetsChar.length];

        for(int i = 0; i < value.length(); i++){

            char element = value.charAt(i);
            
            for(int j = 0; j < targetsChar.length; j++){
              
                if(element == targetsChar[j]){
                    
                    counts[j] = 1 + counts[j];

                }
            }

        }
        
        return counts;
    }

    /** 
    * Get Char Count.
    * 
    * Este metodo retorna a contagem do char da String alvo.
    * @param value String alvo.
    * @param targetsChar caracteres alvos.
    */
    public static int getCharCount(String value,char targetsChar){
        
        int count = 0;

        for(int i = 0; i < value.length(); i++){

            char element = value.charAt(i);
            
            if(element == targetsChar){
                
                count++;

            }
        }
        
        return count;
    }
    
    /** 
    * Get Pattern Count.
    * 
    * Este metodo retorna a contagem do char da String alvo.
    * @param value String alvo.
    * @param pattern caracteres alvos.
    */
    public static int getPatternCount(String value,String pattern){
        
        int count = 0;
        boolean checkPattern = false;
        int patternIndex = 0;

        for(int i = 0; i < value.length(); i++){

            char element = value.charAt(i);
            
            boolean isPattern = true;

            if(!checkPattern && element == pattern.charAt(0)){
            
                checkPattern = true;
                patternIndex = i;

            }else if(checkPattern){

                if(i - patternIndex < pattern.length()){

                    if(element != pattern.charAt(i - patternIndex)){
                        checkPattern = false;
                        patternIndex = 0;
                    }

                }else{
                    count++;
                    checkPattern = false;
                    patternIndex = 0;
                }

            }

        }
        
        return count;
    }

    /** 
    * Get All Pattern Counts.
    * 
    * Este metodo retorna o total de vogais de uma String
    * @param value String alvo.
    * @param patterns array de Strings.
    */
    public static String getAllPatternCounts(String value,String[] patterns){
        String result = "";

        for(int i = 0; i < patterns.length; i++){
         
            int count = getPatternCount(value,patterns[i]);
            
            result +=  patterns[i]+"("+count+") ";
        }
        
        return result;
    }

    /** 
    * Get All Vowel Count.
    * 
    * Este metodo retorna o total de vogais de uma String
    * @param value String alvo.
    * @param targetsChar array de caracteres.
    */
    public static String getAllVowelCount(String value, char[] targetsChar,String[] ignoreTags){
        
        String result = "";

        int[] vowelCounts = getCharCounts(value,targetsChar);        

        
        for(int j = 0; j < ignoreTags.length; j++){
            
            String ignoreTag = ignoreTags[j];

            int[]vowelCountsSubtract = getCharCounts(ignoreTag,targetsChar);

            int ignoreCount = getPatternCount(value,ignoreTag);

            if(ignoreCount > 0 ){

                for(int i = 0; i < vowelCountsSubtract.length; i++){
                    vowelCounts[i] = vowelCounts[i] + (-1 * ignoreCount * vowelCountsSubtract[i]);
                }
            }
            
        }
        
        for(int i = 0; i < targetsChar.length; i++){

            result += targetsChar[i] + "(" +vowelCounts[i]+ ") ";

        }
        
        return result;
    }

    /** 
    * Get All Consonant Count.
    * 
    * Este metodo retorna o total de consoantes de uma String
    * @param value String alvo.
    */
    public static String getAllConsonantCount(String value,String[] ignoreTags){
        String result = "";

        int count = 0;

        for(int i = 0; i < value.length(); i++){

            char letter = value.charAt(i);

            if(isLetter(letter) && !isVowel(letter)){
                count ++;
            }            

        }

        for(int j = 0; j < ignoreTags.length; j++){
            
            String ignoreTag = ignoreTags[j];

            int ConsonantCountsSubtract = getConsonantCount(ignoreTag);

            int ignoreCount = getPatternCount(value,ignoreTag);

            if(ignoreCount > 0 ){

                count = count - (1 * ignoreCount * ConsonantCountsSubtract);
                
            }
            
        }
        
        result += "consoante("+count+") ";

        return result;
    }

    /** 
    * Url Stats.
    * 
    * Este metodo analisa uma url e retona todas suas vogais consoantes e padroes escolhidos.
    * @param name nome do Site.
    * @param url endereco do site.
    */
    public static String urlStats(String name,String url){

        String result = "";

        String html;

        html = getHtml(url);

        char[] allVowels = new char[]{'a','e','i','o','u',(char)225,(char)233,(char)237,
                            (char)243,(char)250,(char)224,(char)232,(char)236,(char)242,
                            (char)249,(char)227,(char)245,(char)226,(char)234,(char)238,
                            (char)244,(char)251};

        String[] patterns = new String[]{"<br>","<table>"};

        result += getAllVowelCount(html,allVowels,patterns);

        result += getAllConsonantCount(html,patterns);
        
        result += getAllPatternCounts(html,patterns);

        result += name;

        return result;
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

    /** 
    * Get Html.
    * 
    * Este metodo recebe um endereco e retorna uma String com o conteudo HTML da pagina.
    * @param endereco String alvo.
    */
    public static String getHtml(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;
  
        try {
           url = new URL(endereco);
           is = url.openStream();  // throws an IOException
           br = new BufferedReader(new InputStreamReader(is));
  
           while ((line = br.readLine()) != null) {
              resp += line + "\n";
           }
        } catch (MalformedURLException mue) {
           mue.printStackTrace();
        } catch (IOException ioe) {
           ioe.printStackTrace();
        } 
  
        try {
           is.close();
        } catch (IOException ioe) {
           // nothing to see here
  
        }
  
        return resp;
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

        String name = "";
        String url = "";

        MyIO.setCharset("UTF-8");
   
        for(int i = 0; i < numEntrada; i++){
            
            if(i % 2 == 0){
                name = entrada[i];
            }else{
                url = entrada[i];

                MyIO.println(urlStats(name,url));
            }   
        }
    }
}