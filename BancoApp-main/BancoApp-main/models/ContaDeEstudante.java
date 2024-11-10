package BancoApp.models;

public class ContaDeEstudante extends Conta {
    private double emprestimo;

    public ContaDeEstudante(String numeroConta) {
        super(numeroConta);
        this.emprestimo = 1000.0;
    }

    public void pegarEmprestimo(double valor) throws Exception {
        if (valor <= emprestimo) {
            saldo += valor;
            emprestimo -= valor;
        } else {
            throw new Exception("Limite de empréstimo excedido");
        }
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
