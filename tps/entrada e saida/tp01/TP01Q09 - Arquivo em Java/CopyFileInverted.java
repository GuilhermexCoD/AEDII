class CopyFileInverted{

    public static void main(String[] args){
        if(args.length == 1){
            ArqLib.copyFileWithNameInverted(args[0]);
        }else if (args.length == 2){
            ArqLib.copyFileWithNameInverted(args[0],args[1]);
        }else{
            ArqLib.copyFileWithNameInverted();
        }
    }
}