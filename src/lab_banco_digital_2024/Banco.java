package lab_banco_digital_2024;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Banco {

    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public List<Conta> filtrarContasPorSaldo(double saldoMinimo) {
        return contas.stream()
                     .filter(conta -> conta.getSaldo() >= saldoMinimo)
                     .collect(Collectors.toList());
    }

    public double getSomaTotalSaldos() {
        return contas.stream()
                     .mapToDouble(Conta::getSaldo)
                     .sum();
    }

    public List<Conta> ordenarContasPorSaldoDesc() {
        return contas.stream()
                     .sorted(Comparator.comparingDouble(Conta::getSaldo).reversed())
                     .collect(Collectors.toList());
    }

    public void imprimirExtratos() {
        System.out.println("=== Extratos de Todas as Contas ===");
        contas.forEach(Conta::imprimirExtrato);
    }
}
