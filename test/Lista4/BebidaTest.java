package Lista4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BebidaTest {
    Bebida chopp;
    Bebida refri;

    @BeforeEach
    public void preparar() {
        chopp = new Bebida("Chopp", 12, 500, true);
        refri = new Bebida("Refri", 6, 350, false);
    }

    @Test
    @DisplayName("Chopp de 12,00 alcoólico custa 15,00")
    public void precoAlcoolica() {
        assertEquals(15.0, chopp.calcularPreco(), 0.001);
    }

    // Casos próprios

    @Test
    @DisplayName("Bebida sem álcool custa o preço base")
    public void precoSemAlcool() {
        assertEquals(6.0, refri.calcularPreco(), 0.001);
    }

    @Test
    @DisplayName("Volume zero deve ser rejeitado")
    public void volumeZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Bebida("Refri", 6, 0, false);
        });
    }

    @Test
    @DisplayName("toString marca a bebida alcoólica")
    public void toStringAlcoolica() {
        assertEquals("Chopp - R$ 15,00 (500 ml) [alcoólica]", chopp.toString());
    }
}
