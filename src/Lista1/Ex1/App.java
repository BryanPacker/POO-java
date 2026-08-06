package Lista1.Ex1;

public class App {
    public static void main(String[] args) throws Exception {
        Pessoa p1 = new Pessoa();
        p1.altura = 1.75;
        p1.peso = 78;
        System.out.println("O Imc da p1 é igual a: " + p1.calcularImc());
    }
}
