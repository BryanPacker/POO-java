package estudos.setup;

public class Peca extends ItemSetup implements comGarantia {
    private int quantidade;

    public Peca(String descricao, double precoBase, int quantidade){
        
        super(descricao, precoBase);
        
        if (quantidade < 1) {
            throw new IllegalArgumentException();
        }

        this.quantidade = quantidade;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public double calcularPreco(){
        
        double preco = (precoBase * quantidade);

        if (quantidade >= 3) {
            preco = preco * 0.9;
        }

        return preco;
    }

    @Override
    public double calcularGarantiaEstendida() {
        return  calcularPreco() * 0.15;
    }
}
