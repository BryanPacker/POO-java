package estudos.setup;

import java.util.ArrayList;

public class Orcamento {

    private Cliente solicitante;
    private Entrega entrega;
    private ArrayList<ItemSetup> itens = new ArrayList<>();

    public Orcamento(Cliente solicitante, String cidade, int prazoDias) {

        if (solicitante == null) {
            throw new IllegalArgumentException();
        }

        this.solicitante = solicitante;
        this.entrega = new Entrega(cidade, prazoDias);
    }

    public void setSolicitante(Cliente solicitante) {
        
        if (solicitante == null) {
            throw new IllegalArgumentException();
        }

        this.solicitante = solicitante;
    }

    public Cliente getSolicitante() {
        return solicitante;
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
            throw new IllegalArgumentException();
        }
        
        for (ItemSetup i : itens) {
            if (item == i) {
                throw new IllegalStateException();
            }
        }

        if (itens.size() > 4) {
            throw new IllegalStateException();
        }

        itens.add(item);        
    }

    public void removerItem(ItemSetup item) {
        for (ItemSetup i : itens) {
            if (item == i) {
                itens.remove(item);
                return;
            }
        }

        throw new IllegalStateException();
    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (ItemSetup i : itens) {
            valorTotal += i.calcularPreco();
        }

        return valorTotal;
    }

    public double calcularTotalGarantia() {
        double valorTotal = 0;


        // usar comGarantia ao inves de peca garante que qualquer classe que implemente futuramente a interface consiga receber o calculo sem modificações

        for (ItemSetup i : itens) {
            if (i instanceof comGarantia) {
                valorTotal += ((comGarantia)i).calcularGarantiaEstendida();
            }
        }

        return valorTotal;
    }
}
