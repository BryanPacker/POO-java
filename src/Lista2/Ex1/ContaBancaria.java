package Lista2.Ex1;

public class ContaBancaria {

    private String titular;
    private int numeroConta;
    private double saldo;
    private static int qtdContas;
    
    // construtor    
    public ContaBancaria(){
        qtdContas++;
    }

    // Getters
    public double getSaldo(){
        return saldo;
    }

    public String getTitular(){
        return titular;
    }

    public int getNumeroConta(){
        return numeroConta;
    }
    public static int getQtdContas(){
        return qtdContas;
    }

    // Setters

    public void setDepositar(double valor) {
        if (valor < 0.01) {
            System.out.println("Não é possivel depositar um valor menor que 1 centavo");
        }
        else{
        saldo = saldo + valor;
        }
    }

    public void setSacar(double valor){
        if (saldo < valor) {
            System.out.println("Fundos insuficientes, saque um valor menor ou igual ao do saldo");
        }
        else{
        saldo = saldo - valor;
        }
    }

    public void setTitular(String titular){
        this.titular = titular; 
    }
    
    public void setNumeroConta(int numeroConta){
        this.numeroConta = numeroConta;
    }
}
