package Lista2.listaexe.q1;
public class Pessoa {
    private double altura, peso;
    private String nome;
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double calcularImc(){
        return peso / (Math.pow(altura,2));
    }
}
