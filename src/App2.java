import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Pessoa p2 = new Pessoa();
        Scanner prompt = new Scanner(System.in);
        System.out.println("Qual sua altura? ");
        p2.altura = prompt.nextDouble();
        System.out.println("Qual seu peso");
        p2.peso = prompt.nextDouble();
        System.out.println("IMC de p2 igual a: " + p2.calcularImc());
        
    }
}
