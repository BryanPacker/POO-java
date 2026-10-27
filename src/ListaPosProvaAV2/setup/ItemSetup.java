package ListaPosProvaAV2.setup;

public abstract class ItemSetup {
    private static int totalItens;
    private int codigo;
    private String descricao;
    private double precoBase;

    /* totalItens e getTotalItens sao static por que o contador é da classe, o codigo é de cada item */
    public ItemSetup(String descricao, double precoBase) {
        if (precoBase <= 0) {
            throw new IllegalArgumentException("preço base invalido");
        }

        totalItens++;
        this.codigo = totalItens;
        this.descricao = descricao;
        this.precoBase = precoBase;
    }

    public static int getTotalItens() {
        return totalItens;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public abstract double calcularPreco();

    @Override
    public String toString() {
        return codigo + " - " + descricao + " - R$ " + calcularPreco();
    }
}
