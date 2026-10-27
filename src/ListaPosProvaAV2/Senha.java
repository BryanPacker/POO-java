package ListaPosProvaAV2;

public class Senha {
    private int numero;
    private String setor;
    private static int totalEmitidas;
    
    /* A variável totalEmitidas precisa ser estático por que ele permite guardar um número específico por instância */

    /*  */
    public Senha(String setor){
        if (setor == null || setor.isBlank()) {
            throw new IllegalArgumentException("setor inválido");
        }
     
        this.totalEmitidas++;
        this.setor = setor;
        this.numero = totalEmitidas;
    }

    public int getNumero() {
        return numero;
    }

    public String getSetor() {
        return setor;
    }

    public int getTotalEmitidas() {
        return totalEmitidas;
    }

    @Override
    public String toString() {
        return this.numero + " - " + this.setor;
    }
}
