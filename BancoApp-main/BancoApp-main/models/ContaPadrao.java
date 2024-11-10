package BancoApp.models;

public class ContaPadrao extends Conta {

    public ContaPadrao(String numeroConta) {
        super(numeroConta);
    }

    @Override
    public void sacar(double valor) throws Exception {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            throw new Exception("Saldo insuficiente");
        }
    }
}
