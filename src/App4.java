import java.util.Scanner;

public class App4 {
    public static void main(String[] args) {
        Pessoa[] pessoas = new Pessoa[3];
        Scanner prompt = new Scanner(System.in);
        for (int i = 0; i < pessoas.length; i++) {
            
            pessoas[i] = new Pessoa();
            System.out.println("Qual a altura da pessoa " + i + "?");
            pessoas[i].altura = prompt.nextDouble();
            System.out.println("Qual o peso da pessoa " + i + "?");
            pessoas[i].peso = prompt.nextDouble();
        }
        for (int i = 3; i > 0; i--) {
            System.out.println("O imc da pessoa " + i + " é igual a " + pessoas[i].calcularImc());
        }
    }
}
