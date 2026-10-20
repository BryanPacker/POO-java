package Lista4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PedidoTest {
    Cliente ana;
    Cliente beto;
    Pedido pedido;
    Prato xis;
    Bebida refri;
    Bebida chopp;
    Sobremesa pudim;

    @BeforeEach
    public void preparar() {
        ana = new Cliente("Ana Souza", "ana@furb.br", 20);
        beto = new Cliente("Beto Lima", "beto@furb.br", 17);
        pedido = new Pedido(ana);
        xis = new Prato("Xis Salada", 30, 'M');
        refri = new Bebida("Refri", 6, 350, false);
        chopp = new Bebida("Chopp", 12, 500, true);
        pudim = new Sobremesa("Pudim", 8, 150);
    }

    @Test
    @DisplayName("Xis M + Refri + Pudim: subtotal 57,00, taxa 7,00, total 64,00")
    public void pedidoComTaxa() {
        pedido.adicionarItem(xis);
        pedido.adicionarItem(refri);
        pedido.adicionarItem(pudim);
        assertEquals(57.0, pedido.calcularSubtotal(), 0.001);
        assertEquals(7.0, pedido.calcularTaxaEntrega(), 0.001);
        assertEquals(64.0, pedido.calcularValorCobrar(), 0.001);
    }

    @Test
    @DisplayName("Dois Xis G de 40,00 ganham frete grátis")
    public void pedidoFreteGratis() {
        pedido.adicionarItem(new Prato("Xis", 40, 'G'), 2);
        assertEquals(0.0, pedido.calcularTaxaEntrega(), 0.001);
        assertEquals(128.0, pedido.calcularValorCobrar(), 0.001);
    }

    @Test
    @DisplayName("Cliente de 17 anos não pode pedir chopp")
    public void menorPedeChopp() {
        Pedido pedidoBeto = new Pedido(beto);
        assertThrows(IllegalArgumentException.class, () -> {
            pedidoBeto.adicionarItem(chopp);
        });
    }

    @Test
    @DisplayName("Quantidade 0 deve ser rejeitada")
    public void quantidadeZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            pedido.adicionarItem(xis, 0);
        });
    }

    @Test
    @DisplayName("Finalizar pedido sem itens deve ser rejeitado")
    public void finalizarSemItens() {
        assertThrows(IllegalStateException.class, () -> {
            pedido.finalizar();
        });
    }

    @Test
    @DisplayName("Finalizar pedido de 57,00 dá 2,85 de cashback")
    public void finalizarDaCashback() {
        pedido.adicionarItem(xis);
        pedido.adicionarItem(refri);
        pedido.adicionarItem(pudim);
        double saldoAntes = ana.getSaldoCashback();
        pedido.finalizar();
        assertEquals(2.85, ana.getSaldoCashback() - saldoAntes, 0.001);
    }

    @Test
    @DisplayName("Dois pedidos criados em sequência têm números consecutivos")
    public void numerosConsecutivos() {
        Pedido primeiro = new Pedido(ana);
        Pedido segundo = new Pedido(ana);
        assertEquals(1, segundo.getNumero() - primeiro.getNumero());
    }

    // Casos próprios

    @Test
    @DisplayName("Pedido sem cliente deve ser rejeitado")
    public void pedidoSemCliente() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Pedido(null);
        });
    }

    @Test
    @DisplayName("Adicionar item em pedido finalizado deve ser rejeitado")
    public void adicionarEmFinalizado() {
        pedido.adicionarItem(xis);
        pedido.finalizar();
        assertThrows(IllegalStateException.class, () -> {
            pedido.adicionarItem(refri);
        });
    }

    @Test
    @DisplayName("Finalizar duas vezes deve ser rejeitado")
    public void finalizarDuasVezes() {
        pedido.adicionarItem(xis);
        pedido.finalizar();
        assertTrue(pedido.isFinalizado());
        assertThrows(IllegalStateException.class, () -> {
            pedido.finalizar();
        });
    }

    @Test
    @DisplayName("Maior de idade pode pedir chopp")
    public void maiorPedeChopp() {
        pedido.adicionarItem(chopp);
        assertEquals(1, pedido.getQuantidadeItens());
    }

    @Test
    @DisplayName("Total de pedidos criados aumenta a cada pedido")
    public void totalPedidosCriados() {
        int antes = Pedido.getTotalPedidosCriados();
        new Pedido(ana);
        assertEquals(antes + 1, Pedido.getTotalPedidosCriados());
    }
}
