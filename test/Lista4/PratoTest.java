package Lista4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PratoTest {
    Prato xis;

    @BeforeEach
    public void preparar() {
        xis = new Prato("Xis Salada", 30, 'M');
    }

    @Test
    @DisplayName("Tamanho X deve ser rejeitado")
    public void tamanhoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Prato("Xis Salada", 30, 'X');
        });
    }

    @Test
    @DisplayName("Prato de 30,00 tamanho M com 10% de desconto custa 35,10")
    public void descontoTamanhoM() {
        assertEquals(35.10, xis.calcularPrecoComDesconto(10), 0.001);
    }

    @Test
    @DisplayName("Desconto de 120% deve ser rejeitado")
    public void descontoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            xis.calcularPrecoComDesconto(120);
        });
    }

    // Casos próprios

    @Test
    @DisplayName("Prato P custa o preço base")
    public void precoTamanhoP() {
        Prato prato = new Prato("Xis Salada", 30, 'P');
        assertEquals(30.0, prato.calcularPreco(), 0.001);
    }

    @Test
    @DisplayName("Prato G custa 60% a mais")
    public void precoTamanhoG() {
        Prato prato = new Prato("Xis Bacon", 40, 'G');
        assertEquals(64.0, prato.calcularPreco(), 0.001);
    }

    @Test
    @DisplayName("Preço base zero deve ser rejeitado")
    public void precoBaseZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Prato("Xis Salada", 0, 'P');
        });
    }

    @Test
    @DisplayName("toString mostra nome, preço e tamanho")
    public void toStringPrato() {
        assertEquals("Xis Salada - R$ 39,00 (tamanho M)", xis.toString());
    }
}
