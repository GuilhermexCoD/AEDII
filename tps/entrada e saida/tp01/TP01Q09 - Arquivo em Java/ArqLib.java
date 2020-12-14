class ArqLib
{
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
    if(!isLetter(letter))
      return letter;
    
    boolean lowerCase = isLowerCase(letter);

    if(lowerCase){
      letter = toUpperCase(letter);
    }

    //MyIO.println(String.format("Is LowerCase = %b",lowerCase));

    int decimalCharUpper = letter;

    //zerando o valor da tabela ASCII para letras Maiusculas 
    decimalCharUpper -= 65; // A = 65 entao meu novo A = 0

    //MyIO.println(String.format("1(%d)%s",decimalCharUpper,String.valueOf(letter)));

    decimalCharUpper = (decimalCharUpper + k);
    decimalCharUpper = mod(decimalCharUpper,26); // (-3 + 26) % 26 => (23%26) = 23

    //MyIO.println(String.format("2(%d)%s",decimalCharUpper,String.valueOf(letter)));

    if(lowerCase){
      decimalCharUpper += 97;
    }else{
      decimalCharUpper += 65;
    }

    letter = (char)decimalCharUpper;

    //MyIO.println(String.format("3(%d)%s",decimalCharUpper,String.valueOf(letter)));

    return letter;
  }

  public static String cesarEncrypt(String text,int k){
    String encryptStr = "";

    for(int i = 0;i < text.length();i++){
      encryptStr += cesarEncrypt(text.charAt(i),k);
    }

    return encryptStr;
  }

  public static void copyFileWithNameCesar(String fileName,String copyFileName,int k){
    
    String str = "";
    String encryptStr = "";
    
    str = readFile(fileName);

    encryptStr = cesarEncrypt(str,k);
    
    writeFileWithString(copyFileName,encryptStr);
    
  }

  public static void copyFileWithNameCesar(String fileName,int k){
    
    copyFileWithNameCesar(fileName,"Copy_"+fileName,k);
    
  }

  public static void copyFileWithNameCesar(){

    String fileName = readStringWithMessage("Digite o nome do arquivo que deseja copiar:");

    MyIO.println("Digite o valor de k para encriptografar um arquivo cesar:");
    
    int k = MyIO.readInt();
    
    copyFileWithNameCesar(fileName,k);
  }
  
  public static String readFile(String fileName){
    Arq.openRead(fileName);
    
    String str = "";
    
    while(Arq.hasNext() == true){
      str += Arq.readAll();
    }
    
    Arq.close();
    
    return str;
  }

  public static String readStringWithMessage(String message){
    
    MyIO.println(message);

    return MyIO.readString();
  }

  public static String readFile(){
    
    String fileName = readStringWithMessage("Digite o nome do arquivo que deseja ler:");
    
    return readFile(fileName);
  }
  
  public static void copyFileWithNameInverted(String fileName,String copyFileName){
    
    String str = "";
    
    str = readFile(fileName);
    
    str = invertString(str);
    
    writeFileWithString(copyFileName,str);
    
  }

  public static void copyFileWithNameInverted(String fileName){
    
    copyFileWithNameInverted(fileName,"Copy_"+fileName);
    
  }

  public static void copyFileWithNameInverted(){
    
    String fileName = readStringWithMessage("Digite o nome do arquivo que deseja copiar:");
    
    copyFileWithNameInverted(fileName);
    
  }
  
  public static void writeFileWithString(String fileName,String value){
    
    Arq.openWrite(fileName);
    Arq.print(value);
    Arq.close();
    
  }
  
  public static void copyFileWithNameUpperCase(String fileName,String copyFileName){
    
    String str = "";
    
    str = readFile(fileName);
    
    str = toUpperCase(str);
    
    writeFileWithString(copyFileName,str);
    
  }
  
  public static void copyFileWithNameUpperCase(String fileName){
    
    copyFileWithNameUpperCase(fileName,"Copy_"+fileName);
    
  }
  
  public static void copyFileWithNameUpperCase(){
    
    MyIO.println("Digite o nome do arquivo que deseja copiar:");
    String fileName = MyIO.readString();
    copyFileWithNameUpperCase(fileName);
    
  }
  
  public static void copyFileWithName(String fileName,String copyFileName){
    String str = "";
    
    str = readFile(fileName);
    
    writeFileWithString(copyFileName,str);
  }
  
  public static void copyFileWithName(String fileName){
    
    copyFileWithName(fileName,"Copy_"+fileName);
    
  }
  
  public static void copyFileWithName(){

    String fileName = readStringWithMessage("Digite o nome do arquivo que deseja copiar:");
    
    copyFileWithName(fileName);
  }
  
  public static String readFileShow(String fileName){
    
    String str = readFile(fileName);

    MyIO.println(str);

    return str;
  }
  
  public static String readFileShow(){
  
    String fileName = readStringWithMessage("Digite o nome do arquivo que deseja ler:");
    
    return readFileShow(fileName);
  }
  
  public static String readFileShowUpperCase(String fileName){
    
    String originalFileString = readFileShow(fileName);
    
    return toUpperCase(originalFileString);
  }
  
  public static String readFileShowUpperCase(){
    
    String originalFileString = readFileShow();
    
    return toUpperCase(originalFileString);
  }

  public static String readFileEncryptCesarShow(String fileName,int k){
    
    String fileString = readFile(fileName);

    String encryptedString = "";

    encryptedString = cesarEncrypt(fileString,k);

    MyIO.println(encryptedString);

    return encryptedString;
  }

  public static String readFileEncryptCesarShow(){
    
    String fileName = readStringWithMessage("Digite o nome do arquivo que deseja ler:");

    MyIO.println("Digite o valor de k para encriptografar um arquivo cesar:");
    
    int k = MyIO.readInt();

    return readFileEncryptCesarShow(fileName,k);
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
      MyIO.print(item);
    }
    
    return upperCaseText;
  }
  
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
  
  public static boolean isLetter(char value){
    int decimalChar = value;
    
    if((decimalChar >= 65 && decimalChar <= 90) || (decimalChar >= 97 && decimalChar <= 122) ){
      return true;
    }
    return false;
  }

  public static boolean isVogal(char value){
    if(!isLetter(value)){
      return false;
    }
    char upperValue = toUpperCase(value);

    int decimalChar = upperValue;
    if(decimalChar == 65 || decimalChar == 69 || decimalChar == 73 || decimalChar == 79 || decimalChar == 85){
      return true;
    }
    return false;

  }
  
  public static String invertString(String value){
    String inverted = "";
  
    for(int i = value.length()-1; i >= 0;i--){
      inverted += value.charAt(i);
    }
  
    return inverted;
  }
  
} // Fim class
