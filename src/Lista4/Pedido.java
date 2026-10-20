package Lista4;

import java.util.ArrayList;

public class Pedido implements Cobravel {
    public static final double TAXA_ENTREGA = 7.0;
    public static final double VALOR_FRETE_GRATIS = 100.0;
    private static int proximoNumero = 1;
    private int numero;
    private boolean finalizado;
    private Cliente cliente;
    private ArrayList<ItemCardapio> itens = new ArrayList<>();

    public Pedido(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Necessário passar cliente válido");
        }

        this.cliente = cliente;
        numero = proximoNumero;
        proximoNumero++;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void adicionarItem(ItemCardapio item) {
        if (item == null) {
            throw new IllegalArgumentException("Item não pode ser nulo");
        }

        if (finalizado) {
            throw new IllegalStateException("Pedido " + numero + " já foi finalizado");
        }

        if (item instanceof Bebida) {
            Bebida bebida = (Bebida) item;
            if (bebida.isAlcoolica() && !cliente.isMaiorDeIdade()) {
                throw new IllegalArgumentException("Bebida alcoólica não pode ser vendida para menor de idade");
            }
        }

        itens.add(item);
    }

    public void adicionarItem(ItemCardapio item, int quantidade) {
        if (quantidade < 1) {
            throw new IllegalArgumentException("Quantidade inválida: " + quantidade + ". Precisa ser maior que 0!");
        }

        for (int i = 0; i < quantidade; i++) {
            adicionarItem(item);
        }
    }

    public int getQuantidadeItens() {
        return itens.size();
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (ItemCardapio item : itens) {
            subtotal += item.calcularPreco();
        }
        return subtotal;
    }

    public double calcularTaxaEntrega() {
        if (calcularSubtotal() >= VALOR_FRETE_GRATIS) {
            return 0;
        }

        return TAXA_ENTREGA;
    }

    @Override
    public double calcularValorCobrar() {
        return calcularSubtotal() + calcularTaxaEntrega();
    }

    public void finalizar() {
        if (finalizado) {
            throw new IllegalStateException("Pedido " + numero + " já foi finalizado");
        }

        if (itens.isEmpty()) {
            throw new IllegalStateException("Pedido " + numero + " não tem itens");
        }

        cliente.creditarCashback(calcularSubtotal() * 0.05);
        finalizado = true;
    }

    public static int getTotalPedidosCriados() {
        return proximoNumero - 1;
    }
}
