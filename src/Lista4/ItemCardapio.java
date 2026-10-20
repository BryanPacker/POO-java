package Lista4;

import java.util.Locale;

public abstract class ItemCardapio {

    private String nome;
    private double precoBase;

    public ItemCardapio(String nome, double precoBase) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do item não pode ser nulo nem vazio");
        }

        this.nome = nome;
        setPrecoBase(precoBase);
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        validarPositivo(precoBase);
        this.precoBase = precoBase;
    }

    protected void validarPositivo(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido: " + valor + ". Precisa ser maior que 0!");
        }
    }

    public abstract double calcularPreco();

    public final double calcularPrecoComDesconto(double percentual) {
        if (percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("Percentual inválido: " + percentual + ". Precisa estar entre 0 e 100");
        }

        return calcularPreco() * (1 - percentual / 100);
    }

    @Override
    public String toString() {
        return String.format(Locale.of("pt", "BR"), "%s - R$ %.2f", nome, calcularPreco());
    }
}
