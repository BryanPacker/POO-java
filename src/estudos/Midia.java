package estudos;

public abstract class Midia {

    private String desc;
    protected double precoBase;

    public Midia(String desc, double precoBase){

        if (desc == null || desc.isBlank()) {
            throw new IllegalArgumentException();
        }

        if (precoBase <= 0) {
            throw new IllegalArgumentException();
        }

        this.desc = desc;
        this.precoBase = precoBase;
    }
    public abstract double calcularPrecoBase();    

}
