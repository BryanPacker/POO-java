package Lista4;

import java.util.ArrayList;
import java.util.Locale;

public class CentralCobranca {

    private ArrayList<Cobravel> cobrancas = new ArrayList<>();

    public void registrar(Cobravel cobranca) {
        if (cobranca == null) {
            throw new IllegalArgumentException("Cobrança não pode ser nula");
        }

        cobrancas.add(cobranca);
    }

    public double calcularTotalAReceber() {
        double total = 0;
        for (Cobravel cobranca : cobrancas) {
            total += cobranca.calcularValorCobrar();
        }
        return total;
    }

    public int getQuantidadeCobrancas() {
        return cobrancas.size();
    }

    public String gerarRelatorio() {
        String relatorio = "";
        for (Cobravel cobranca : cobrancas) {
            relatorio += cobranca.gerarComprovante() + "\n";
        }
        relatorio += String.format(Locale.of("pt", "BR"), "Total a receber: R$ %.2f", calcularTotalAReceber());
        return relatorio;
    }
}
