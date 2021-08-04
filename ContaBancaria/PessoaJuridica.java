public class PessoaJuridica extends Pessoa{

    //Atributos
    private String cnpj;
    private String atividade;

    //Métodos
    public PessoaJuridica(Integer id, String nome, String Endereco, String cnpj, String atividade) {
        super(id, nome, Endereco);
        this.cnpj = cnpj;
        this.atividade = atividade;
    }

    public String getCnpj(){
        return cnpj;
    }

    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }

    public String getAtividade(){
        return atividade;
    }

    public void setAtividade(String atividade){
        this.atividade = atividade;
    }
    
}
