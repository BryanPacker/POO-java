package Lista4;

public class AssinaturaClube implements Cobravel {

    private double valorMensal;
    private int meses;
    private Cliente cliente;

    public AssinaturaClube(Cliente cliente, double valorMensal, int meses) {
        if (cliente == null) {
            throw new IllegalArgumentException("Necessário passar cliente válido");
        }

        if (valorMensal <= 0) {
            throw new IllegalArgumentException("Valor mensal inválido: " + valorMensal + ". Precisa ser maior que 0!");
        }

        if (meses < 1) {
            throw new IllegalArgumentException("Quantidade de meses inválida: " + meses + ". Precisa ser ao menos 1");
        }

        this.cliente = cliente;
        this.valorMensal = valorMensal;
        this.meses = meses;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public int getMeses() {
        return meses;
    }

    @Override
    public double calcularValorCobrar() {
        double valorTotal = valorMensal * meses;

        if (meses >= 12) {
            return valorTotal * 0.85;
        }

        return valorTotal;
    }
}
