package ListaPosProvaAV2.aquecimento;

public class Filme extends Midia {

    public Filme(String descricao, double precoBase) {
        super(descricao, precoBase);
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase();
    }
}
