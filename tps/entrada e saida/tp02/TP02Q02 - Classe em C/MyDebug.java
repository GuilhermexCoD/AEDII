class MyDebug {
   
   public static void print(int[] array){
	   
	   String arrayText = "{";
	   for(int i = 0;i < array.length;i++){
		   int element = array[i];
		   if(i == array.length -1)
				arrayText += String.format("%d}",element);
		   else
				arrayText += String.format("%d ,",element);
	   }
	   
	   MyIO.println(arrayText);
   }

   public static void print(int[] array, int[] indexes){
	   
	String arrayText = "{";
	for(int i = 0;i < array.length;i++){
		int element = array[i];
		String elementString = String.format("%d",element);

		for(int j = 0; j < indexes.length;j++){
			if(i==indexes[j])
				elementString = String.format("[%s]",elementString);
		}

		if(i == array.length -1)
			 arrayText += String.format("%s}",elementString);
		else
			 arrayText += String.format("%s ,",elementString);
	}
	
	MyIO.println(arrayText);
}


}
