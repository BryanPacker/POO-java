package estudos;

public class Senha {
    
    private int numero;
    private static int totalEmitidas;
    private String setor;

    public Senha(String setor){
        
        if (setor == null || setor.isBlank()) {
            throw new IllegalArgumentException("setor obrigatório");
        }
        
        this.numero = totalEmitidas += 1;
        totalEmitidas = numero;
        this.setor = setor;
    }

    public int getNumero() {
        return numero;
    }

    public String getSetor() {
        return setor;
    }

    public static int getTotalEmitidas() {
        return totalEmitidas;
    }

    @Override
    public String toString() {
        return (numero + " - " + setor);
    }
}
