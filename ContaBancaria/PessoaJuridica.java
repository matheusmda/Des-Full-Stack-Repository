public class PessoaJuridica extends Pessoa{

    //Atributos
    private Integer cnpj;
    private String atividade;

    //Métodos
    public PessoaJuridica(Integer id, String nome, String Endereco, Integer cnpj, String atividade) {
        super(id, nome, Endereco);
        this.cnpj = cnpj;
        this.atividade = atividade;
    }

    public Integer getCnpj(){
        return cnpj;
    }

    public void setCnpj(Integer cnpj){
        this.cnpj = cnpj;
    }

    public String getAtividade(){
        return atividade;
    }

    public void setAtividade(String atividade){
        this.atividade = atividade;
    }
    
}
