package Lista4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SobremesaTest {
    Sobremesa pudim;

    @BeforeEach
    public void preparar() {
        pudim = new Sobremesa("Pudim", 8, 150);
    }

    @Test
    @DisplayName("Pudim de 8,00 por 100 g com 150 g custa 12,00")
    public void precoPorPeso() {
        assertEquals(12.0, pudim.calcularPreco(), 0.001);
    }

    // Casos próprios

    @Test
    @DisplayName("Peso negativo deve ser rejeitado")
    public void pesoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Sobremesa("Pudim", 8, -50);
        });
    }

    @Test
    @DisplayName("Desconto de 50% vale para sobremesa também")
    public void descontoSobremesa() {
        assertEquals(6.0, pudim.calcularPrecoComDesconto(50), 0.001);
    }

    @Test
    @DisplayName("toString mostra o peso")
    public void toStringSobremesa() {
        assertEquals("Pudim - R$ 12,00 (150 g)", pudim.toString());
    }
}
