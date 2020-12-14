import java.io.*;
import java.net.*;

class ExemploURL_Diego {
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
   public static void main(String[] args) {
      MyIO.setCharset("UTF-8");
      
      int[] todoscarcters = new int[26];
      zerarovetor(todoscarcters);
      String endereco, html = "";

      String nome = MyIO.readLine();
     
      while(!isfim(nome)){
    


      endereco = MyIO.readLine();
      html = getHtml(endereco);
      Qofcarac(html, todoscarcters);
      escrever(todoscarcters, nome);
      zerarovetor(todoscarcters);
      nome = MyIO.readLine();

      }
   }
  

    public static void escrever(int[] todoscarcters, String nome){
      MyIO.println("a("+ todoscarcters[0] + ") e("+ todoscarcters[1] + ") i(" + todoscarcters[2] + ") o("+ todoscarcters[3] + ") u(" + todoscarcters[4] +")"
      +" \u00E1(" + todoscarcters[5] + ") \u00E9("+ todoscarcters[6] + ") \u00ED(" + todoscarcters[7] + ") \u00F3("+ todoscarcters[8] + ") \u00FA(" + todoscarcters[9] +")"+   " \u00E0(" + todoscarcters[16] + ") \u00E8("+ todoscarcters[18] + ") \u00EC(" + todoscarcters[17] + ") \u00F2("+ todoscarcters[15] + ") \u00F9(" + todoscarcters[19] +")"+
       " \u00E3(" + todoscarcters[20] + ") \u00F5("+ todoscarcters[21] + ") \u00E2(" + todoscarcters[10] + ") \u00EA("+ todoscarcters[11] + ") \u00EE(" + todoscarcters[13] +")"+
      " \u00F4(" + todoscarcters[12] + ") ("+ todoscarcters[14] + ") consoante(" + todoscarcters[24] + ") <br>("+ todoscarcters[22] + ") <table>(" + todoscarcters[23] +") "+ nome);
           
    }
      
      
   


    public static boolean isfim(String endereco){
       boolean is = false;
        if(endereco.length() == 3 && endereco.charAt(0) == 'F' && endereco.charAt(1) == 'I' &&
        endereco.charAt(2) == 'M'){
           is = true;
        }
        return is;
    }


    public static void zerarovetor(int[] todoscarcters){
       for(int i = 0; i < 25; i++){
          todoscarcters[i] = 0;
       }
    }

   public static void Qofcarac(String html, int[] todoscarcters){

     //representar cada elemento no vetor
      
     
       for(int i = 0; i < html.length(); i++){
         if (html.charAt(i) == '\u003C') {
            i++;
                    if (html.charAt(i) == 'b' && html.charAt(i + 1) == 'r' && html.charAt(i + 2) == '\u003E') {
                            todoscarcters[22]++;
                            i += 2;
    } else if (html.charAt(i) == 't' && html.charAt(i + 1) == 'a' && html.charAt(i+5) == '\u003E') {
                            todoscarcters[23]++;
                            i += 5;

                    }
       i--;
            }else if (html.charAt(i) == 'a')
                    todoscarcters[0]++;
          
         else if(html.charAt(i) == 'a'){
            todoscarcters[0]++; //contador para o caracter a
         }else if(html.charAt(i) == 'e'){
            todoscarcters[1]++;
         }else if(html.charAt(i) == 'i'){
            todoscarcters[2]++;
         }else if(html.charAt(i) == 'o'){
             todoscarcters[3]++;
         }else if(html.charAt(i) == 'u'){
            todoscarcters[4]++;
         }
         else if(html.charAt(i) == '\u00E1'){ // á
            todoscarcters[5]++;
         }else if(html.charAt(i) == '\u00E9'){// é
            todoscarcters[6]++;
         }else if(html.charAt(i) == '\u00ED'){//í
            todoscarcters[7]++;
         }else if(html.charAt(i) == '\u00F3'){// ó
            todoscarcters[8]++;
         }else if(html.charAt(i) == '\u00FA'){// ú
            todoscarcters[9]++;
         }else if(html.charAt(i) == '\u00E2'){// â
            todoscarcters[10]++;
         }else if(html.charAt(i) == '\u00EA' ){// ê
            todoscarcters[11]++;
         }else if(html.charAt(i) == '\u00F4'){ // ô
            todoscarcters[12]++;
         }else if(html.charAt(i) == '\u00EE'){// î
            todoscarcters[13]++;
         }else if(html.charAt(i) == '\u00FB'){//û
            todoscarcters[14]++;
         }else if(html.charAt(i) == '\u00F2'){// ò
            todoscarcters[15]++;
         }else if(html.charAt(i) == '\u00E0'){// à
            todoscarcters[16]++;
         }else if(html.charAt(i) == '\u00EC'){//ì
            todoscarcters[17]++;
         }else if(html.charAt(i) == '\u00E8'){// è
            todoscarcters[18]++;
         }else if(html.charAt(i) ==  '\u00F9'){// ù
            todoscarcters[19]++;
         }else if(html.charAt(i) == '\u00E3'){//ã
            todoscarcters[20]++;
         }else if(html.charAt(i) == '\u00F5'){//õ
            todoscarcters[21]++;
         } else if(html.charAt(i) >= 'a' && html.charAt(i) <= 'z'){
             if(!isvogal(html.charAt(i))){
                todoscarcters[24]++;
             }
           }
         }
      }    
   public static boolean isvogal(char letra){
      boolean isvogal = false;
       if(letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u'){
          isvogal = true;
       }
       return isvogal;
   }

}




