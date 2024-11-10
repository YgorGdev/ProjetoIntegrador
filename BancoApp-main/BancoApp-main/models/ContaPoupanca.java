package BancoApp.models;

public class ContaPoupanca extends Conta {
    private double taxaJuros = 0.05;

    public ContaPoupanca(String numeroConta) {
        super(numeroConta);
    }

    public void aplicarJuros() {
        saldo += saldo * taxaJuros;
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
