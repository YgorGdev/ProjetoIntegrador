package BancoApp;

import BancoApp.factory.ContaFactory;
import BancoApp.models.Conta;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        // Criando contas de diferentes tipos
        Conta contaPadrao = banco.criarConta("PADRAO", "12345");
        Conta contaComLimite = banco.criarConta("COM_LIMITE", "23456");
        Conta contaEspecial = banco.criarConta("ESPECIAL", "34567");
        Conta contaEstudante = banco.criarConta("ESTUDANTE", "45678");
        Conta contaPoupanca = banco.criarConta("POUPANCA", "56789");

        // Buscando todas as contas
        banco.buscarConta("12345");
        banco.buscarConta("23456");
        banco.buscarConta("34567");
        banco.buscarConta("45678");
        banco.buscarConta("56789");

        // Realizando depósitos em todas as contas
        banco.depositar("12345", 1000.00); // Conta Padrão
        banco.depositar("23456", 1500.00); // Conta com Limite
        banco.depositar("34567", 2000.00); // Conta Especial
        banco.depositar("45678", 500.00);  // Conta de Estudante
        banco.depositar("56789", 300.00);  // Conta Poupança

        // Realizando saques
        try {
            banco.sacar("12345", 200.00); // Conta Padrão
            banco.sacar("23456", 600.00); // Conta com Limite
            banco.sacar("34567", 500.00); // Conta Especial
            banco.sacar("45678", 100.00); // Conta de Estudante
            banco.sacar("56789", 50.00);   // Conta Poupança

            // Tentativas de saque inválidas
            banco.sacar("23456", 1000.00); // Saque maior que o limite da Conta com Limite
            banco.sacar("11111", 100.00);  // Conta não existe
        } catch (Exception e) {
            System.out.println("Erro ao realizar saque: " + e.getMessage());
        }

        // Finalizando as operações
        System.out.println("Operações concluídas.");
    }
}
