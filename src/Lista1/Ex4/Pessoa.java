package Lista1.Ex4;
public class Pessoa {
    double altura, peso;
    String nome;
    double calcularImc(){
        return peso / (Math.pow(altura,2));
    }
}
