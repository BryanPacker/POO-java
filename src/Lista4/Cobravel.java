package Lista4;

import java.util.Locale;

public interface Cobravel {

    double calcularValorCobrar();

    default String gerarComprovante() {
        return String.format(Locale.of("pt", "BR"), "Valor a cobrar: R$ %.2f", calcularValorCobrar());
    }
}
