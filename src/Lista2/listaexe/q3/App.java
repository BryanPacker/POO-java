package Lista2.listaexe.q3;

public class App {
    public static void main(String[] args) {
        ContaBancaria c1 = new ContaBancaria();
        ContaBancaria c2 = new ContaBancaria();
        //setters e métodos solicitados conta 1
        c1.depositar(1000);
        c1.depositar(700);
        c1.setNumero("01");
        c1.setTitular("zezinho");
        //setters e métodos solicitados conta2
        c2.depositar(5000);
        c2.setNumero("02");
        c2.setTitular("jubiscreuda");
        c2.sacar(3000);
        //transf
        c2.transferir(c1, 1800);

        System.out.println("O saldo do titular "+ c1.getTitular() + " é igual a: R$"+ c1.getSaldo());
        System.out.println("O saldo do titular "+ c2.getTitular() + " é igual a: R$"+ c2.getSaldo());
    }
}
