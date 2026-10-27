package ListaPosProvaAV2.aquecimento;

public class Pedido {
    private Cliente comprador;
    private Endereco entrega;

    /* a versão 1 compila mas ta errada por que pedido nao é um endereço, ele tem um endereço, entao nao pode ser herança */
    public Pedido(Cliente comprador, String rua, int numero) {
        this.comprador = comprador;
        entrega = new Endereco(rua, numero);
    }

    public Cliente getComprador() {
        return comprador;
    }

    public String getRuaEntrega() {
        return entrega.getRua();
    }

    public int getNumeroEntrega() {
        return entrega.getNumero();
    }
}
