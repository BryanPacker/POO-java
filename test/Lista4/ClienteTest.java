package Lista4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClienteTest {
    Cliente ana;

    @BeforeEach
    public void preparar() {
        ana = new Cliente("Ana Souza", "ana@furb.br", 20);
    }

    @Test
    @DisplayName("Idade -1 deve ser rejeitada")
    public void idadeNegativa() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("Ana Souza", "ana@furb.br", -1);
        });
    }

    @Test
    @DisplayName("E-mail sem @ deve ser rejeitado")
    public void emailSemArroba() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("Ana Souza", "ana.furb.br", 20);
        });
    }

    @Test
    @DisplayName("Indicar um amigo credita R$ 10,00 para quem indicou")
    public void indicacaoCreditaCashback() {
        new Cliente("Beto Lima", "beto@furb.br", 17, ana);
        assertEquals(10.0, ana.getSaldoCashback(), 0.001);
    }

    @Test
    @DisplayName("Usar mais cashback do que tem lança SaldoInsuficienteException")
    public void usarCashbackSemSaldo() {
        ana.creditarCashback(10);
        assertThrows(SaldoInsuficienteException.class, () -> {
            ana.usarCashback(15);
        });
    }

    @Test
    @DisplayName("Clientes com o mesmo e-mail em caixas diferentes são iguais")
    public void equalsIgnoraCaixa() {
        Cliente outra = new Cliente("Ana S.", "ANA@FURB.BR", 30);
        assertTrue(ana.equals(outra));
    }

    // Casos próprios

    @Test
    @DisplayName("Indicador nulo deve ser rejeitado")
    public void indicadorNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("Beto Lima", "beto@furb.br", 17, null);
        });
    }

    @Test
    @DisplayName("Usar cashback com saldo suficiente desconta do saldo")
    public void usarCashbackComSaldo() throws SaldoInsuficienteException {
        ana.creditarCashback(10);
        ana.usarCashback(4);
        assertEquals(6.0, ana.getSaldoCashback(), 0.001);
    }

    @Test
    @DisplayName("Cliente de 17 anos não é maior de idade")
    public void menorDeIdade() {
        Cliente beto = new Cliente("Beto Lima", "beto@furb.br", 17);
        assertFalse(beto.isMaiorDeIdade());
    }

    @Test
    @DisplayName("Creditar valor zero deve ser rejeitado")
    public void creditarZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            ana.creditarCashback(0);
        });
    }

    @Test
    @DisplayName("toString mostra nome e e-mail")
    public void toStringCliente() {
        assertEquals("Ana Souza <ana@furb.br>", ana.toString());
    }
}
