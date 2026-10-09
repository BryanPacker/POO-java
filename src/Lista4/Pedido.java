package Lista4;

public class Pedido {
    public final double taxaEntrega = 7;
    public final double valorFreteGratis = 100;
    private int proximoNumero = 1;
    private int numero;
    private boolean finalizado;

    public Pedido(Cliente cliente){
        if (cliente == null) {
            throw new IllegalArgumentException("Necessário passar cliente válido");
        }
    }

    public void finalizar(){
        finalizado = true;
    } 
}
