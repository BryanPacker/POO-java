package Lista4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssinaturaClubeTest {
    Cliente ana;

    @BeforeEach
    public void preparar() {
        ana = new Cliente("Ana Souza", "ana@furb.br", 20);
    }

    @Test
    @DisplayName("Assinatura de 3 meses não tem desconto")
    public void semDesconto() {
        AssinaturaClube assinatura = new AssinaturaClube(ana, 20, 3);
        assertEquals(60.0, assinatura.calcularValorCobrar(), 0.001);
    }

    @Test
    @DisplayName("Assinatura de 12 meses tem 15% de desconto")
    public void comDesconto() {
        AssinaturaClube assinatura = new AssinaturaClube(ana, 19.90, 12);
        assertEquals(202.98, assinatura.calcularValorCobrar(), 0.001);
    }

    @Test
    @DisplayName("Assinatura com 0 meses deve ser rejeitada")
    public void zeroMeses() {
        assertThrows(IllegalArgumentException.class, () -> {
            new AssinaturaClube(ana, 19.90, 0);
        });
    }

    @Test
    @DisplayName("Assinatura sem cliente deve ser rejeitada")
    public void semCliente() {
        assertThrows(IllegalArgumentException.class, () -> {
            new AssinaturaClube(null, 19.90, 12);
        });
    }

    @Test
    @DisplayName("Comprovante usa o método default da interface")
    public void comprovante() {
        AssinaturaClube assinatura = new AssinaturaClube(ana, 20, 3);
        assertEquals("Valor a cobrar: R$ 60,00", assinatura.gerarComprovante());
    }
}
