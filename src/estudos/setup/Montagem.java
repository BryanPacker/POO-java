package estudos.setup;

public class Montagem extends ItemSetup {

    private int horas;

    public Montagem(String descricao, double precoBase, int horas){
        super(descricao, precoBase);

        if (horas < 1) {
            throw new IllegalArgumentException();
        }

        this.horas = horas;
    }

    public int getHoras(){
        return horas;
    }

    @Override
    public double calcularPreco() {
        return precoBase * horas;
    }
}
