package ListaPosProvaAV2.setup;

public class Software extends ItemSetup implements ComGarantia {
    private int licencas;

    public Software(String descricao, double precoBase, int licencas) {
        super(descricao, precoBase);

        if (licencas <= 0) {
            throw new IllegalArgumentException("licenças invalidas");
        }

        this.licencas = licencas;
    }

    public int getLicencas() {
        return licencas;
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase() * licencas;
    }

    @Override
    public double calcularGarantiaEstendida() {
        return calcularPreco() * 0.15;
    }
}
