import java.util.Calendar;

public class PessoaFisica extends Pessoa{

    // Atributos
    private Integer cpf;
    private Calendar dtNascimento;
    private String genero;

    // Métodos
    public PessoaFisica(Integer id, String nome, String Endereco, Integer cpf, Calendar dtNascimento, String genero) {
        super(id, nome, Endereco);
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.genero = genero;
    }

    public Integer getCpf(){
        return cpf;
    }

    public void setCpf(Integer cpf){
        this.cpf = cpf;
    }

    public Calendar getDtNascimento(){
        return dtNascimento;
    }

    public void setDtNascimento(Calendar dtNascimento){
        this.dtNascimento = dtNascimento;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    // Implementar depois!!
    public Integer getIdade(){
        return 1;
    }
    
}
