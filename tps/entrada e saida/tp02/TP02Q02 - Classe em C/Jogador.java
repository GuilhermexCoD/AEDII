class Jogador{

    private int id;
    private String name;
    private int altura;
    private int peso;
    private String universidade;
    private int anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;

    public Jogador() {
        setId(-1);
        setName("");
        setAltura(-1);
        setPeso(-1);
        setUniversidade("");
        setAnoNascimento(-1);
        setCidadeNascimento("");
        setEstadoNascimento("");
    }

    public Jogador(int id,String name,int altura,int peso,String universidade,int anoNascimento,String cidadeNascimento,String estadoNascimento) {
        setId(id);
        setName(name);
        setAltura(altura);
        setPeso(peso);
        setUniversidade(universidade);
        setAnoNascimento(anoNascimento);
        setCidadeNascimento(cidadeNascimento);
        setEstadoNascimento(estadoNascimento);
    }

    public String getValidString(String value){
        if(value == "")
            return "nao informado";

        return value;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setId(String id){
        this.id = getValidNumber(id);
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = getValidString(name);
    }

    public String getName(){
        return name;
    }

    public void setAltura(int altura){
        this.altura = altura;
    }

    public void setAltura(String altura){
        this.altura = getValidNumber(altura);
    }

    public int getAltura(){
        return altura;
    }

    public void setPeso(int peso){
        this.peso = peso;
    }

    public void setPeso(String peso){
        this.peso = getValidNumber(peso);
    }

    public int getPeso(){
        return peso;
    }

    public void setUniversidade(String universidade){
        this.universidade = getValidString(universidade);
    }

    public String getUniversidade(){
        return universidade;
    }

    public void setAnoNascimento(int anoNascimento){
        this.anoNascimento = anoNascimento;
    }

    public void setAnoNascimento(String anoNascimento){
        this.anoNascimento = getValidNumber(anoNascimento);
    }

    public int getAnoNascimento(){
        return anoNascimento;
    }

    public void setCidadeNascimento(String cidadeNascimento){
        this.cidadeNascimento = getValidString(cidadeNascimento);
    }

    public String getCidadeNascimento(){
        return cidadeNascimento;
    }

    public void setEstadoNascimento(String estadoNascimento){
        this.estadoNascimento = getValidString(estadoNascimento);
    }

    public String getEstadoNascimento(){
        return estadoNascimento;
    }
    
    public static Jogador clone(Jogador toClone) {
        Jogador clone = new Jogador(toClone.getId(),toClone.getName(),toClone.getAltura(),
                                    toClone.getPeso(),toClone.getUniversidade(),
                                    toClone.getAnoNascimento(),toClone.getCidadeNascimento(),
                                    toClone.getEstadoNascimento());
        return clone;
    }

    public void imprimir(){
        String result = String.format("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]",id,name,altura,peso,anoNascimento,universidade,cidadeNascimento,estadoNascimento);
        MyIO.println(result);
    }

    public int getValidNumber(String value){
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            //TODO: handle exception
            return -1;
        }
    }

    public static Jogador ler(String input){
        Jogador jogador = new Jogador();
        String[] inputValues = input.split(",");
        String[] values = new String[8];


        //MyIO.println(String.format("Input : %s",input));

        for(int i = 0; i< values.length;i++){
            if(i < inputValues.length){
                values[i] = inputValues[i];
                if(values[i].length() == 0){
                    values[i] = "";
                }
            }
            else
                values[i] = "";

            //MyIO.println(String.format("%d : %s",i, values[i]));
            /*
            for(int j = 0;j<values[i].length();j++){
                    
                MyIO.println(String.format("\t%d : %s",j, values[i].charAt(j)));
            }
            */
        }

        jogador.setId(values[0]);
        jogador.setName(values[1]);
        jogador.setAltura(values[2]);
        jogador.setPeso(values[3]);
        jogador.setUniversidade(values[4]);
        jogador.setAnoNascimento(values[5]);
        jogador.setCidadeNascimento(values[6]);
        jogador.setEstadoNascimento(values[7]);

        return jogador;
    }
}