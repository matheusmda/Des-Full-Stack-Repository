import java.util.ArrayList;

public class Conta {

    // Atributos
    private Pessoa cliente;
    private Integer nrConta;
    private Double saldo;

    // Métodos
    // abrirConta não seria o construtor?
    public Conta(Pessoa cliente, Integer nrConta, Double saldo){
        this.cliente = cliente;
        this.nrConta = nrConta;
        this.saldo = saldo;
    }

    public Pessoa getCliente(){
        return cliente;
    }

    // Dúvida aqui -> Tá correto?
    public void setCliente(Pessoa cliente){
        this.cliente = cliente;
    }

    public Integer getNrConta(){
        return nrConta;
    }

    public Double getSaldo(){
        return saldo;
    }

    public void sacar(Double saque){
        if(saque <= getSaldo()){
            debitar(saque);
        }
    }

    private void debitar(Double saque){
        this.saldo = getSaldo() - saque;
    }

    protected boolean temSaldo(){
        if(getSaldo() > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public void depositar(Double quantia){
        this.saldo = getSaldo() + quantia;
    }

    public void transferir(Double quantia, Integer nrConta, ArrayList<Conta> listaContas){
        if(quantia <= getSaldo()){
            for (Conta conta : listaContas) {
                if(conta.getNrConta() == nrConta){
                    debitar(quantia);
                    conta.depositar(quantia);
                    break;
                }
            }
        }
    }

}