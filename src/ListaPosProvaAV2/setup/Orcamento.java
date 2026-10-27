package ListaPosProvaAV2.setup;

import java.util.ArrayList;

public class Orcamento {
    private Cliente solicitante;
    private Entrega entrega;
    private ArrayList<ItemSetup> itens = new ArrayList<>();

    public Orcamento(Cliente solicitante, String cidade, int prazoDias) {
        setSolicitante(solicitante);
        entrega = new Entrega(cidade, prazoDias);
    }

    public Cliente getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Cliente solicitante) {
        if (solicitante == null) {
            throw new IllegalArgumentException("solicitante não pode ser nulo");
        }

        this.solicitante = solicitante;
    }

    public String getCidadeEntrega() {
        return entrega.getCidade();
    }

    public int getPrazoEntrega() {
        return entrega.getPrazoDias();
    }

    public ArrayList<ItemSetup> getItens() {
        return itens;
    }

    public void adicionarItem(ItemSetup item) {
        if (item == null) {
            throw new IllegalArgumentException("item nulo");
        }

        if (itens.contains(item)) {
            throw new IllegalStateException("item já está no orçamento");
        }

        if (itens.size() == 5) {
            throw new IllegalStateException("orçamento cheio");
        }

        itens.add(item);
    }

    public void removerItem(ItemSetup item) {
        boolean removeu = itens.remove(item);

        if (!removeu) {
            throw new IllegalStateException("item não encontrado");
        }
    }

    public double calcularValorTotal() {
        double total = 0;
        for (ItemSetup item : itens) {
            total += item.calcularPreco();
        }
        return total;
    }

    /* o cast é pra ComGarantia e nao pra Peca por que se fosse Peca qualquer outra classe com garantia ficava de fora */
    public double calcularTotalGarantia() {
        double total = 0;
        for (ItemSetup item : itens) {
            if (item instanceof ComGarantia) {
                total += ((ComGarantia) item).calcularGarantiaEstendida();
            }
        }
        return total;
    }
}
