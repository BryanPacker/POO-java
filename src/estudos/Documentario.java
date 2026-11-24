package estudos;

public class Documentario extends Midia implements Legendavel{
    public Documentario(String desc, double precoBase){
        super(desc, precoBase);
    }

    @Override
    public double calcularPrecoBase() {
        return precoBase;
    }

    @Override
    public double calcularCustoLegenda() {
        double custoLegenda;
        return custoLegenda = precoBase * 0.1;
    }
}
