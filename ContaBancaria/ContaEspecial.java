public class ContaEspecial extends Conta {

    // Atributos
    private Double limite;

    // Métodos
    // abrirConta não seria o construtor?
    public ContaEspecial(Integer id, String nome, String Endereco, Integer nrConta, Double saldo, Double limite) {
        super(id, nome, Endereco, nrConta, saldo);
        this.limite = limite;
    }

    public void setLimite(Double limite){
        this.limite = limite;
    }

    public Double getLimite(){
        return limite;
    }

    protected boolean temSaldo(){
        if(getSaldo() > 0){
            return true;
        }
        else{
            return false;
        }
    }
}
