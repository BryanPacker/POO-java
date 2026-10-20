package Lista4;

public class Bebida extends ItemCardapio {

    private int volumeMl;
    private boolean alcoolica;

    public Bebida(String nome, double precoBase, int volumeMl, boolean alcoolica) {
        super(nome, precoBase);
        validarPositivo(volumeMl);

        this.volumeMl = volumeMl;
        this.alcoolica = alcoolica;
    }

    public int getVolumeMl() {
        return volumeMl;
    }

    public boolean isAlcoolica() {
        return alcoolica;
    }

    @Override
    public double calcularPreco() {
        if (alcoolica) {
            return getPrecoBase() + 3;
        }

        return getPrecoBase();
    }

    @Override
    public String toString() {
        if (alcoolica) {
            return super.toString() + " (" + volumeMl + " ml) [alcoólica]";
        }

        return super.toString() + " (" + volumeMl + " ml)";
    }
}
