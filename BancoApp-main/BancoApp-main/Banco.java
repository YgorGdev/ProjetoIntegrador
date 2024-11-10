package BancoApp;

import BancoApp.factory.ContaFactory;
import BancoApp.models.Conta;

import java.util.HashMap;
import java.util.Map;

public class Banco {
    private Map<String, Conta> contas = new HashMap<>();

    public Conta criarConta(String tipo, String numeroConta) {
        System.out.println("Criando conta do tipo: " + tipo + " com número: " + numeroConta);
        Conta conta = ContaFactory.criarConta(tipo, numeroConta);
        contas.put(numeroConta, conta);
        System.out.println("Conta criada com sucesso: " + conta);
        return conta;
    }

    public Conta buscarConta(String numeroConta) {
        System.out.println("Buscando conta com número: " + numeroConta);
        Conta conta = contas.get(numeroConta);
        if (conta != null) {
            System.out.println("Conta encontrada: " + conta);
        } else {
            System.out.println("Conta com número " + numeroConta + " não encontrada.");
        }
        return conta;
    }

    public void depositar(String numeroConta, double valor) {
        System.out.println("Depositando valor de " + valor + " na conta com número: " + numeroConta);
        Conta conta = buscarConta(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
            System.out.println("Depósito realizado com sucesso. Novo saldo: " + conta.getSaldo());
        } else {
            System.out.println("Depósito falhou. Conta não encontrada.");
        }
    }

    public void sacar(String numeroConta, double valor) throws Exception {
        System.out.println("Sacando valor de " + valor + " da conta com número: " + numeroConta);
        Conta conta = buscarConta(numeroConta);
        if (conta != null) {
            try {
                conta.sacar(valor);
                System.out.println("Saque realizado com sucesso. Novo saldo: " + conta.getSaldo());
            } catch (Exception e) {
                System.out.println("Erro ao sacar: " + e.getMessage());
                throw e;
            }
        } else {
            System.out.println("Saque falhou. Conta não encontrada.");
        }
    }
}