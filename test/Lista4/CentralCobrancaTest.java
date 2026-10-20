package Lista4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CentralCobrancaTest {
    CentralCobranca central;
    Cliente ana;
    Pedido pedido;
    AssinaturaClube assinatura;

    @BeforeEach
    public void preparar() {
        central = new CentralCobranca();
        ana = new Cliente("Ana Souza", "ana@furb.br", 20);
        pedido = new Pedido(ana);
        pedido.adicionarItem(new Prato("Xis Salada", 30, 'M'));
        pedido.adicionarItem(new Bebida("Refri", 6, 350, false));
        pedido.adicionarItem(new Sobremesa("Pudim", 8, 150));
        assinatura = new AssinaturaClube(ana, 19.90, 12);
    }

    @Test
    @DisplayName("Pedido de 64,00 + assinatura de 19,90 por 12 meses dá 266,98")
    public void totalAReceber() {
        central.registrar(pedido);
        central.registrar(assinatura);
        assertEquals(266.98, central.calcularTotalAReceber(), 0.001);
    }

    // Casos próprios

    @Test
    @DisplayName("Registrar cobrança nula deve ser rejeitado")
    public void registrarNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            central.registrar(null);
        });
    }

    @Test
    @DisplayName("Quantidade de cobranças aumenta ao registrar")
    public void quantidadeCobrancas() {
        central.registrar(pedido);
        central.registrar(assinatura);
        assertEquals(2, central.getQuantidadeCobrancas());
    }

    @Test
    @DisplayName("Relatório termina com o total a receber")
    public void relatorio() {
        central.registrar(pedido);
        central.registrar(assinatura);
        String relatorio = central.gerarRelatorio();
        assertTrue(relatorio.contains("Valor a cobrar: R$ 64,00"));
        assertTrue(relatorio.endsWith("Total a receber: R$ 266,98"));
    }

    @Test
    @DisplayName("Central vazia tem total zero")
    public void centralVazia() {
        assertEquals(0.0, central.calcularTotalAReceber(), 0.001);
    }
}
