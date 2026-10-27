package ListaPosProvaAV2.setup;

public class Peca extends ItemSetup implements ComGarantia {
    private int quantidade;

    public Peca(String descricao, double precoBase, int quantidade) {
        super(descricao, precoBase);

        if (quantidade <= 0) {
            throw new IllegalArgumentException("quantidade invalida");
        }

        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public double calcularPreco() {
        double preco = getPrecoBase() * quantidade;

        if (quantidade >= 3) {
            return preco * 0.9;
        }

        return preco;
    }

    @Override
    public double calcularGarantiaEstendida() {
        return calcularPreco() * 0.15;
    }
}
