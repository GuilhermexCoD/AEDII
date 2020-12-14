//Curso: Ciencia da Computacao / Tarde
//Universidade: PUC Minas
//Materia: AEDII Lab
//Aluno: Guilherme Froes Camba de Freitas
//Matricula: 718116

//Importando a biblioteca com as funcoes de Random do java
import java.util.Random;

class TP01Q04AlteracaoAleatoria{
    
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
    * Get Random Lower Char.
    * 
    * Este metodo sorteia com um seed um char entre o minimo e o maximo.
    * @param seed semente para o utilizar no Random.
    * @param min caractere minimo diacordo com a tabela ASCII.
    * @param maxValue valor maximo de sorteio.
    */
    public static char getRandomLowerChar(int seed,char min,int maxValue){
        Random generator = new Random();
        generator.setSeed(seed);
        return ((char)(min+(Math.abs(generator.nextInt()) % maxValue)));
    }

    /** 
    * Get Random Lower Char.
    * 
    * Este metodo sorteia com um seed um char entre o minimo e o maximo.
    * @param generator apontador para o Random ja configurado.
    * @param min caractere minimo diacordo com a tabela ASCII.
    * @param maxValue valor maximo de sorteio.
    */
    public static char getRandomLowerChar(Random generator,char min,int maxValue){
        return ((char)(min+(Math.abs(generator.nextInt()) % maxValue)));
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
        
        Random generator = new Random();
        generator.setSeed(4);

        //Para cada linha de entrada, gerando uma de saida contendo SIM para palavras Palindromas e NAO caso contrario
        for(int i = 0; i < numEntrada; i++){
                
            char firstRandomChar = getRandomLowerChar(generator,'a',26);
            
            char secondRandomChar = getRandomLowerChar(generator,'a',26);
            //Como observado no pub.in letra A se converte em D assim temos que nosso K = 3
            MyIO.println(replace(entrada[i],firstRandomChar,secondRandomChar));
        }

    }

}