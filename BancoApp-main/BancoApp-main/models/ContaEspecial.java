package BancoApp.models;

public class ContaEspecial extends Conta {
    private double limiteEspecial;

    public ContaEspecial(String numeroConta, double limiteEspecial) {
        super(numeroConta);
        this.limiteEspecial = limiteEspecial;
    }

    @Override
    public void sacar(double valor) throws Exception {
        if (valor <= saldo + limiteEspecial) {
            saldo -= valor;
        } else {
            throw new Exception("Limite especial excedido");
        }
    }
}
