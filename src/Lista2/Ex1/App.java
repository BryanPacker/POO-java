package Lista2.Ex1;

public class App {
    public static void main(String[] args) {
        ContaBancaria cb = new ContaBancaria();
        ContaBancaria cb2 = new ContaBancaria();
        ContaBancaria cb3 = new ContaBancaria();

        cb.setTitular("André");
        cb.setNumeroConta(01);
        cb.setDepositar(100);
        System.out.println("O saldo atual é: " + cb.getSaldo());
        cb.setDepositar(50000);
        System.out.println("O saldo adulterado agora é igual a: " + cb.getSaldo());
        System.out.println("A quantidade de contas no banco é igual a: " + ContaBancaria.getQtdContas());
    }
}
