package ListaPosProvaAV2.aquecimento;

public abstract class Midia {
    private String descricao;
    private double precoBase;

    public Midia(String descricao, double precoBase) {
        this.descricao = descricao;
        this.precoBase = precoBase;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public abstract double calcularPreco();
}
