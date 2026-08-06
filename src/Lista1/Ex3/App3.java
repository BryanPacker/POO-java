package Lista1.Ex3;
import java.util.Scanner;

import Lista1.Ex3.Pessoa;

public class App3 {
    public static void main(String[] args) {
        Pessoa p3 = new Pessoa();
        Scanner prompt = new Scanner(System.in);
        System.out.println("Qual sua altura? ");
        p3.altura = prompt.nextDouble();
        System.out.println("Qual seu peso");
        p3.peso = prompt.nextDouble();
        System.out.println("IMC de p3 igual a: " + p3.calcularImc());
        
        Pessoa p4 = new Pessoa();
        System.out.println("Qual sua altura? ");
        p4.altura = prompt.nextDouble();
        System.out.println("Qual seu peso");
        p4.peso = prompt.nextDouble();
        System.out.println("IMC de p4 igual a: " + p4.calcularImc());
        
        Pessoa p5 = new Pessoa();
        System.out.println("Qual sua altura? ");
        p5.altura = prompt.nextDouble();
        System.out.println("Qual seu peso");
        p5.peso = prompt.nextDouble();
        System.out.println("IMC de p5 igual a: " + p5.calcularImc());        
    }
}
