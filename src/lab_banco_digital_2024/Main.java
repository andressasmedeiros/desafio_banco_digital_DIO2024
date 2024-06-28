package lab_banco_digital_2024;

public class Main {

    public static void main(String[] args) {
        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Banco banco = new Banco("Meu Banco");

        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);

        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        cc.depositar(100);
        cc.transferir(100, poupanca);

        banco.imprimirExtratos();

        System.out.println("\nFiltrar contas com saldo maior ou igual a 0:");
        banco.filtrarContasPorSaldo(0)
             .forEach(conta -> System.out.println("Saldo da conta: " + conta.getSaldo()));

        System.out.println("\nSoma total dos saldos das contas: " + banco.getSomaTotalSaldos());

        System.out.println("\nOrdenar contas por saldo (descendente):");
        banco.ordenarContasPorSaldoDesc()
             .forEach(conta -> System.out.println("Saldo da conta: " + conta.getSaldo()));
    }
}
