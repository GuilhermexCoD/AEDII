class Contato{

    private String nome;
    private String telefone;
    private String email;
    private int cpf;

    public Contato (){
        setNome("");
        setTelefone("");
    }

    public Contato (String nome,String telefone){
        setNome(nome);
        setTelefone(telefone);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

}