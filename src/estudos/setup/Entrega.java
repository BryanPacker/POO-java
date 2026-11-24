package estudos.setup;

public class Entrega {

    private String cidade;
    private int prazoDias;

    public Entrega(String cidade, int prazoDias){
        if (cidade == null || cidade.isBlank()) {
            throw new IllegalArgumentException();
        }

        if (prazoDias <= 0) {
            throw new IllegalArgumentException();
        }

        this.cidade = cidade;
        this.prazoDias = prazoDias;
    }

    public String getCidade() {
        return cidade;
    }

    public int getPrazoDias() {
        return prazoDias;
    }
}
