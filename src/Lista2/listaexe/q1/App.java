package Lista2.listaexe.q1;
import java.util.Scanner;

import Lista2.listaexe.q1.*;

public class App {
    public static void main(String[] args) {
        Pessoa[] pessoas = new Pessoa[1];
        Scanner prompt = new Scanner(System.in);
        for (int i = 0; i < pessoas.length; i++) {
            int numeroPessoa = i + 1;
            pessoas[i] = new Pessoa();
            System.out.println("Qual o nome da pessoa " + numeroPessoa + "?");
            pessoas[i].setNome(prompt.next());
            System.out.println("Qual a altura da pessoa " + numeroPessoa + "?");
            pessoas[i].setAltura(prompt.nextDouble());
            System.out.println("Qual o peso da pessoa " + numeroPessoa + "?");
            pessoas[i].setPeso(prompt.nextDouble());
        }
        for (int i = pessoas.length - 1; i >= 0; i--) {
            int numeroPessoa = i + 1;
            System.out.println("Número de pessoa " + numeroPessoa);
            System.out.println("O imc do(a) " + pessoas[i].getNome() + " é igual a " + pessoas[i].calcularImc());
        }
    }
}
