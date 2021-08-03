public class Pessoa {

    // Atributos
    private Integer id;
    private String nome;
    private String Endereco;


    // Métodos
    public Pessoa(Integer id, String nome, String Endereco){
        this.id = id;
        this.nome = nome;
        this.Endereco = Endereco;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEndereco(){
        return Endereco;
    }
    
    public void setEndereco(String Endereco){
        this.Endereco = Endereco;
    }

}
