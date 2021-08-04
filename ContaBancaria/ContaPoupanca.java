public class ContaPoupanca extends Conta{

    // Atributos
    private Double txCorrecao;

    // Métodos
    // abrirConta não seria o construtor?
    public ContaPoupanca(Pessoa cliente, Integer nrConta, Double saldo, Double txCorrecao) {
        super(cliente, nrConta, saldo);
        this.txCorrecao = txCorrecao;
    }

    public Double getTaxaCorrecao(){
        return txCorrecao;
    }

    public void setTaxaCorrecao(Double txCorrecao){
        this.txCorrecao = txCorrecao;
    }

    public void atualizaSaldoRendimento(){
        depositar(getSaldo() * 0.006);
    }
}
