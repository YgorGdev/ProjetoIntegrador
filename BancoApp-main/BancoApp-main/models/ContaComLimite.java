package BancoApp.models;

public class ContaComLimite extends Conta {
    private double limite;

    public ContaComLimite(String numeroConta, double limite) {
        super(numeroConta);
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) throws Exception {
        if (valor <= saldo + limite) {
            saldo -= valor;
        } else {
            throw new Exception("Limite excedido");
        }
    }
}
