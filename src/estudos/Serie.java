package estudos;

public class Serie extends Midia implements Legendavel {
    private int temporadas;

    public Serie(String desc, double precoBase, int temporadas) {
        super(desc, precoBase);

        if (temporadas < 1) {
            throw new IllegalArgumentException();
        }
        this.temporadas = temporadas;
    }

    @Override
    public double calcularPrecoBase() {
        double valorTotal;
        valorTotal = precoBase * temporadas;
        return valorTotal;
    }

    @Override
    public double calcularCustoLegenda() {
        double custoLegenda;
        return custoLegenda = precoBase * 0.1;
    }

}
