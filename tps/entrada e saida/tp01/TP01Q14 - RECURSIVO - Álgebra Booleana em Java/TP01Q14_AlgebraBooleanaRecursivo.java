//Curso: Ciencia da Computacao / Tarde
//Universidade: PUC Minas
//Materia: AEDII Lab
//Aluno: Guilherme Froes Camba de Freitas
//Matricula: 718116

class TP01Q14_AlgebraBooleanaRecursivo{
    
    /** 
    * Replace.
    * 
    * Este metodo procura todas ocorrencias de um caractere em uma String e o substitui pelo outro caractere.
    * @param targetString palavra onde vai ocorrer a busca.
    * @param searchElement caractere de busca.
    * @param replaceElement caractere de troca.
    */
    public static String replace(String targetString, char searchElement, char replaceElement){
        String resultString ="";
        
        //Percorrer por toda String
        for(int i = 0;i < targetString.length();i++){
            char element = targetString.charAt(i);
            //Quando o elemento alvo for igual ao elemento de busca fazer a substituicao pelo elemento de troca
            if(element == searchElement){
                resultString += replaceElement;
            }else{
                resultString += element;
            }

        }

        return resultString;
    }

    /** 
    * Boolean Algebra.
    * 
    * Este metodo inicia a solucao da algebra booleana.
    * @param problem String contendo a Algebra booleana.
    */
    public static boolean bAlgebra(String problem){
        //Removemos os espacos
        String[] subStringArray = splitString(problem,' ');

        int variablesCount = getVariablesCount(subStringArray);

        String problemString = "";

        //Construindo a Operacao Booleana
        for(int i = variablesCount+1;i < subStringArray.length; i++){
            problemString += subStringArray[i];
        }

        for(int i = 0;i < getVariablesCount(subStringArray); i++){

            char searchElement = (char)(i+65);
            char replaceElement = subStringArray[i+1].charAt(0);
            problemString = replace(problemString,searchElement,replaceElement);
        }

        String ans = getSubAlgebra(problemString);

        boolean result = false;

        if(ans.length() > 0){
            result = charToBool(ans.charAt(0));
        }

        return result;
    }

    /** 
    * Get Sub Algebra.
    * 
    * Este metodo soluciona a algebra booleana do parenteses mais interno para os mais externos.
    * @param problem String contendo a Algebra booleana.
    */
    public static String getSubAlgebra(String problem){
        String subFunction = problem;
        //encontramos os limites dos parenteses
        int[] limits = getParenthesesLimits(problem);

        //se o limite for >=0 significa que ele eh valido e ainda temos Algebra booleana para resolver
        if(limits[0] >= 0){
            subFunction = solveAlgebraString(problem,limits[0],limits[1]);
        }

        return subFunction;
    }

    /** 
    * Solve Algebra String.
    * 
    * Este metodo recursivo soluciona a algebra booleana do parenteses mais interno para os mais externos.
    * @param problem String contendo a Algebra booleana (0 ate StartIndex-1 => Operacao) e de (StartIndex + 1 ate EndIndex-1 => Variaveis).
    * @param startIndex indice do caractere inicial que separa a Operacao das Variaveis.
    * @param endIndex indice do caractere final mostra onde terminam as Variaveis.
    */
    public static String solveAlgebraString(String problem,int startIndex,int endIndex){

        String result = "";

        //String contendo apenas a Operacao booleana a ser executada
        String method = getStringFromTo(problem,0,startIndex-1);

        //String contendo apenas as Variaveis a serem executadas
        String variables = getStringFromTo(problem,startIndex+1,endIndex-1);
        
        //Cada Variavel fica em uma posicao para facilitar o acesso
        String[] variablesArray = getVariables(variables);
        
        int parenthesesBeginCount = subStringCount(variables,'(');
        
        //Pela quantidade de parente se > 0 indica que devemos executar o metodo recursivo para cada Variavel encontrada
        if(parenthesesBeginCount > 0){
            for(int i = 0;i < variablesArray.length; i++){
                variablesArray[i] = getSubAlgebra(variablesArray[i]);
            }
        }
        
        //executado a Operacao desejada
        switch (method) {
            case "and":
                result = and(stringToArray(variablesArray))?"1":"0";
                break;

            case "or":
                result = or(stringToArray(variablesArray))?"1":"0";
                break;

            case "not":
                if(variablesArray.length > 0)
                    result = not(variablesArray[0].charAt(0))?"1":"0";
                break;
            default:
                MyIO.println(String.format("Not found Method: %s",method));
                break;
            
        }

        //retorna o valor para o parenteses superior ou retorna para o metodo inicial
        return result;
    }

    /** 
    * Get Variables.
    * 
    * Este metodo encontra as variaveis das expressoes da Algebra booleana .
    * @param targetStrings String alvo.
    */
    public static String[] getVariables(String targetString){
        int countP = 0;

        int countVar = 0;

        String variable = "";
        
        int arrayLength = targetString.length();

        //Separamos na memoria um array com o tamanho da "targetString" sendo o maior caso de variaveis possiveis
        String[] subStringArray = new String[arrayLength];
        
        //Contamos quantas variaveis temos baseado na separacao por ','
        for(int i = 0;i < targetString.length(); i++){
            
            char element = targetString.charAt(i);

            if(element == '('){
                variable += element;
                countP++;
            }else if(element == ')'){
                variable += element;
                countP--;
            }else if(element == ',' && countP == 0){
                subStringArray[countVar] = variable;
                variable = "";
                countVar++;
            }else{
                variable += element;
            }

        }

        //adicionando a ultima variavel que fica depois da ','
        if(variable.length() > 0){
            subStringArray[countVar] = variable;
            countVar++;
        }
        
        String[] resultSubStringArray = new String[countVar];
        
        //entregamos o array do tamanho desejado ( numero de variaveis)
        for(int i = 0;i < resultSubStringArray.length; i++){
            
            String elementS = subStringArray[i];

            resultSubStringArray[i] = elementS;
        }


        //MyIO.println(String.format("array Length : %d",arrayLength));

        return resultSubStringArray;
    }

    /** 
    * String To Array.
    * 
    * Este metodo converte um array de Strings para um Array de Char.
    * @param targetStrings String alvo.
    */
    public static char[] stringToArray(String[] targetStrings){
        String result = "";

        for(int i = 0;i < targetStrings.length; i++){

            result += targetStrings[i];
        }

        return stringToArray(result);
    }

    /** 
    * Get String From To.
    * 
    * Este metodo dado uma String alvo ele particiona ela iniciando do char na posicao StartIndex e termina no char na posicao EndIndex
    * @param targetString String alvo.
    * @param startIndex indice do caractere de comeco inclusive.
    * @param endIndex indice do caractere de fim inclusive.
    */
    public static char[] stringToArray(String targetString){
        char[] cArray = new char[targetString.length()];

        for(int i = 0;i < targetString.length(); i++){

            char element = targetString.charAt(i);
            cArray[i] = element;
        }

        return cArray;
    }

    /** 
    * Get String From To.
    * 
    * Este metodo dado uma String alvo ele particiona ela iniciando do char na posicao StartIndex e termina no char na posicao EndIndex
    * @param targetString String alvo.
    * @param startIndex indice do caractere de comeco inclusive.
    * @param endIndex indice do caractere de fim inclusive.
    */
    public static String getStringFromTo(String targetString ,int startIndex,int endIndex){
        if(targetString.length() <= endIndex )
            return "";

        String result = "";

        //montando a nova String
        for(int i = 0;i < targetString.length(); i++){

            if(i >= startIndex && i <= endIndex){

                char element = targetString.charAt(i);
                result += element;

            }
            
        }

        return result;
    }

    /** 
    * Get Parentheses Limits.
    * 
    * Este metodo dado uma String ele retorna um array de inteiros,
    * onde o primeiro indice representa a primeira aparicao de um parenteses aberto e
    * o ultimo indice representa o equivalente para o parenteses fechado.
    * @param value String onde vamos procurar a incidencia de parenteses.
    */
    public static int[] getParenthesesLimits(String value){
        // -1 para quando nao tivermos parenteses na String
        int[] limits = new int[]{-1,-1};

        int parenthesesBeginCount = 0;
        for(int i = 0;i < value.length(); i++){
            char element = value.charAt(i);
            if(element == '('){
                if(parenthesesBeginCount == 0)
                    limits[0] = i;

                parenthesesBeginCount++;
                
            }else if(element == ')'){
                parenthesesBeginCount--;

                //quando o count chegar a zero significa que encontramos o parenteses complementar.
                if(parenthesesBeginCount == 0)
                    limits[1] = i;
            }
        }

        return limits;
    }

    /** 
    * Get Variables Chars.
    * 
    * Este metodo recebe um array de Strings com as variaveis da Algebra booleana e os retorna em um Array de Chars.
    * @param variables Array de Strings com as variaveis da Algebra booleana.
    */
    public static char[] getVariablesChars(String[] variables){
        int varCount = getVariablesCount(variables);
        char[] varChars = new char[varCount];

        for(int i = 0;i < varCount; i++){
            String element = variables[i+1];
            varChars[i] = element.charAt(0);
        }
        return varChars;
    }

    /** 
    * Or.
    * 
    * Este metodo recebe um array de caracteres que serao transformados em booleanas, e aplica a operacao logica OU para todos eles.
    * @param values Array de Caracteres serao convertidos em booleanas.
    */
    public static boolean or(char[] values){
        boolean resp = false;

        for(int i = 0;i < values.length; i++){
            boolean element = charToBool(values[i]);
            //quando o primeiro for True podemos interromper o for e retornar False
            if(element){
                resp = true;
                break;
            }
        }

        return resp;
    }

    /** 
    * And.
    * 
    * Este metodo recebe um array de caracteres que serao transformados em booleanas, e aplica a operacao logica E para todos eles.
    * @param values Array de Caracteres serao convertidos em booleanas.
    */
    public static boolean and(char[] values){
        boolean resp = true;

        for(int i = 0;i < values.length; i++){
            boolean element = charToBool(values[i]);
            //quando o primeiro for False podemos interromper o for e retornar False
            if(!element){
                resp = false;
                break;
            }
        }

        return resp;
    }

    /** 
    * Not.
    * 
    * Este metodo retorna a negacao do valor booleano do caractere alvo.
    * @param value caractere alvo.
    */
    public static boolean not(char value){
        return !charToBool(value);
    }

    /** 
    * Char To Bool.
    * 
    * Este metodo retorna True se o char for '1' se nao False.
    * @param value caractere alvo.
    */
    public static boolean charToBool(char value){
        return value=='1'?true:false;
    }

    /** 
    * Get Variables Count.
    * 
    * Este metodo retorna a quantidade de variaveis que temos na expressao da Algebra booleana.
    * @param variables Array de Strings que subdividiu a expressao da Algebra booleana.
    */
    public static int getVariablesCount(String[] variables){
        //Subitrair 48 para chegar em valores inteiros; '0' = 48 na Tabela ASCII
        return (variables[0].charAt(0)-48);
    }

    /** 
    * Split String.
    * 
    * Este metodo percorre pelo vetor da String dividindo para cada vez que o caractere de divisao aparecer formando sub Strings.
    * @param targetString palavra onde vai ocorrer a busca.
    * @param splitChar caractere de divisao.
    */
    public static String[] splitString(String targetString, char splitChar){

        int arrayLength = subStringCount(targetString,splitChar)+1;

        String[] subStringArray = new String[arrayLength];

        String aux = "";
        
        int count = 0;

        for(int i = 0;i < targetString.length(); i++){
            
            char element = targetString.charAt(i);

            if(element == splitChar){
                subStringArray[count] = aux;
                aux = "";
                count++;
            }else{
                aux += element;
            }

        }
        subStringArray[count] = aux;

        return subStringArray;
    }

    /** 
    * Sub String Count.
    * 
    * Este metodo percorre pelo vetor da String e conta quantos caracteres iguais ao procurado temos.
    * @param targetString palavra onde vai ocorrer a busca.
    * @param searchElement caractere de busca.
    */
    public static int subStringCount(String targetString,char searchElement){
        int count = 0;
        
        for(int i = 0;i < targetString.length(); i++){
            //Se o elemento for igual ao elemento procurado adicionar ao contador
            char element = targetString.charAt(i);
            if(element == searchElement)
                count++;

        }

        return count;
    }

    public static boolean isFim(String s){
        return (s.length() == 1 && s.charAt(0) == '0');
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

            MyIO.println(bAlgebra(entrada[i])?"1":"0");
        }

    }

}