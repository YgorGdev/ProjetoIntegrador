package BancoApp.factory;

import BancoApp.models.*;

public class ContaFactory {
    public static Conta criarConta(String tipo, String numeroConta) {
        switch (tipo) {
            case "PADRAO":
                return new ContaPadrao(numeroConta);
            case "COM_LIMITE":
                return new ContaComLimite(numeroConta, 500);
            case "ESPECIAL":
                return new ContaEspecial(numeroConta, 1000);
            case "ESTUDANTE":
                return new ContaDeEstudante(numeroConta);
            case "POUPANCA":
                return new ContaPoupanca(numeroConta);
            default:
                throw new IllegalArgumentException("Tipo de conta inválido");
        }
    }
}
