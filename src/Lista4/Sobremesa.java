package Lista4;

public class Sobremesa extends ItemCardapio {

    private int pesoGramas;

    public Sobremesa(String nome, double precoPor100g, int pesoGramas) {
        super(nome, precoPor100g);
        validarPositivo(pesoGramas);

        this.pesoGramas = pesoGramas;
    }

    public int getPesoGramas() {
        return pesoGramas;
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase() * pesoGramas / 100;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + pesoGramas + " g)";
    }
}
