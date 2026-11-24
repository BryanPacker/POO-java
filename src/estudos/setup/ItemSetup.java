package estudos.setup;

public abstract class ItemSetup {
    private static int totalItens;
    private int codigo;
    private String descricao;
    protected double precoBase;

    public ItemSetup(String descricao, double precoBase){
       
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException();
        }

        if (precoBase <= 0) {
            throw new IllegalArgumentException();
        }

        totalItens++;
        this.codigo = totalItens;
        this.precoBase = precoBase;
        this.descricao = descricao;
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
        return (codigo + " - " + descricao + " - R$" + calcularPreco());
    }
}
