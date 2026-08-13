package Lista2.listaexe.q3;

public class ContaBancaria {
    private String numero;
    private String titular;
    private double saldo;
   
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public double getSaldo() {
        return saldo;
    }
    public void depositar(double valor){
        if (valor < 0) {
            System.out.println("Valor inválido, deposite um valor positivo");
        }
        else{
            saldo += valor;
        }
    }
    public void sacar(double valor){
        if (valor > saldo || valor < 0) {
            System.out.println("Valor inválido,  digite um valor menor que o saldo ou positivo");
        }
        else{
            saldo -= valor;
        }
    }
    public void transferir(ContaBancaria contaDestino,double valor){
        if (valor > saldo || valor < 0) {
            System.out.println("Valor inválido,  digite um valor menor que o saldo ou positivo");
        }
        else{
            this.sacar(valor);
            contaDestino.depositar(valor);
        }
    }
}
