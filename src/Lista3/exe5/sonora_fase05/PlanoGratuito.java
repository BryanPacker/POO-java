package Lista3.exe5.sonora_fase05;

public final class PlanoGratuito extends Plano {
    public PlanoGratuito() {
        super("Gratuito", 1);
    }

    @Override
    public boolean temAnuncios() {
        return true;
    }

    @Override
    public double calcularMensalidade() {
        return 0.0;
    }
}
