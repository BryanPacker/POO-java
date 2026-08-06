package Lista1.Ex4;
public class Pessoa {
    double altura, peso;
    double calcularImc(){
        return peso / (Math.pow(altura,2));
    }
}
