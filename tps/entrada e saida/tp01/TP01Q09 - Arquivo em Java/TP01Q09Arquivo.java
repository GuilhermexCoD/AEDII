//Curso: Ciencia da Computacao / Tarde
//Universidade: PUC Minas
//Materia: AEDII Lab
//Aluno: Guilherme Froes Camba de Freitas
//Matricula: 718116

import java.io.*;

class TP01Q09Arquivo{ 

    /** 
    * Read File Inverse.
    * 
    * Este metodo lee um arquivo salvo em bytes do final para o inicio.
    * @param fileName nome do arquivo.
    * @param value array de numeros reais que seram salvos no arquivo em byte.
    */
    public static void writeDoubleToFile(String fileName,double[] value)throws Exception{

        //criando ou acessando um arquivo e habilitando para leitura e escrita
        RandomAccessFile raf = new RandomAccessFile(fileName,"rw");

        for(int i = 0; i < value.length; i++){

            raf.writeDouble(value[i]);

        }  
        
        raf.close();

    }

    /** 
    * Read File Inverse.
    * 
    * Este metodo lee um arquivo salvo em bytes do final para o inicio.
    * @param fileName nome do arquivo.
    */
    public static void readFileInverse(String fileName)throws Exception{

        RandomAccessFile raf = new RandomAccessFile(fileName,"r");

        long pointer = 0;

        long seekPointer = 0;
        
        long length = raf.length();
        
        double value = 0.0;
        
        raf.skipBytes((int)length);
        
        //percorrendo o arquivo inteiro printando os valores
        do{
            //640
            pointer = raf.getFilePointer();
            
            //double = 8 bytes
            //640-8 => 632
            seekPointer = pointer-8;
            
            //Proximo ponto de leitura
            raf.seek(seekPointer);

            //MyIO.println(String.format("0 Length = %d | Pointer = %d | Seek = %d",length,pointer,seekPointer));

            
            //ler o valor de double entre 640 e 632
            //ReadDouble leva meu ponteiro para 640 novamente devo voltar ele para 632
            value = raf.readDouble();
    
            //Voltar o ponteiro para 632
            raf.seek(seekPointer);

            //atualizando a variavel pointer para 632
            pointer = raf.getFilePointer();
                        
            int valueInt = (int)Math.round(value);
            
            if(value - valueInt == 0)
                MyIO.println(valueInt);
            else
                MyIO.println(value);
            

        }while(pointer != 0);

        raf.close();

    }

    /** 
    * Get Numbers FromFile.
    * 
    * Este metodo retorna todos os numeros reais.
    * @param numberAmount total de numeros reais presentes no arquivo.
    */
    public static double[] getNumbersFromFile(int numberAmount){

        double[] result = new double[numberAmount];

        for(int i = 0; i < numberAmount; i++){
            result[i] = Double.parseDouble(MyIO.readLine());
        }   

        return result;
    }


    public static void main(String[] args)throws Exception{
        
        //receber a quantidade de numeros reais presentes no arquivo
        int entryNumbers = Integer.parseInt(MyIO.readLine());

        double[] result = getNumbersFromFile(entryNumbers);

        String fileName = "numeros.txt";

        writeDoubleToFile(fileName,result);

        readFileInverse(fileName);    
    }
}