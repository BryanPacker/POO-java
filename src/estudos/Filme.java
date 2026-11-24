package estudos;

public class Filme extends Midia{

    public Filme(String desc, double precoBase){
        super(desc, precoBase);
    }

    @Override
    public double calcularPrecoBase() {
        return precoBase;
    }
    
    }
