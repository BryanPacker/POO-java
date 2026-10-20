package Lista4;

public class Prato extends ItemCardapio {

    private char tamanho;

    public Prato(String nome, double precoBase, char tamanho) {
        super(nome, precoBase);

        if (tamanho != 'P' && tamanho != 'M' && tamanho != 'G') {
            throw new IllegalArgumentException("Tamanho inválido: " + tamanho + ". Use P, M ou G");
        }

        this.tamanho = tamanho;
    }

    public char getTamanho() {
        return tamanho;
    }

    @Override
    public double calcularPreco() {
        if (tamanho == 'M') {
            return getPrecoBase() * 1.3;
        } else if (tamanho == 'G') {
            return getPrecoBase() * 1.6;
        } else {
            return getPrecoBase();
        }
    }

    @Override
    public String toString() {
        return super.toString() + " (tamanho " + tamanho + ")";
    }
}
