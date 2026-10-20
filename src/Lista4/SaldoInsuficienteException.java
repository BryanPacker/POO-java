package Lista4;

import java.util.Locale;

public class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException(double saldo, double valorSolicitado) {
        super(String.format(Locale.of("pt", "BR"), "Saldo insuficiente: disponível R$ %.2f, solicitado R$ %.2f", saldo, valorSolicitado));
    }
}
