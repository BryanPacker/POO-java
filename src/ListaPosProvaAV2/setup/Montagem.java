package ListaPosProvaAV2.setup;

public class Montagem extends ItemSetup {
    private int horas;

    public Montagem(String descricao, double precoBase, int horas) {
        super(descricao, precoBase);

        if (horas <= 0) {
            throw new IllegalArgumentException("horas invalidas");
        }

        this.horas = horas;
    }

    public int getHoras() {
        return horas;
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase() * horas;
    }
}
