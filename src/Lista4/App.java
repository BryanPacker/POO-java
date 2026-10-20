package Lista4;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class App {
    private static final Locale BR = Locale.of("pt", "BR");
    private final Scanner prompt = new Scanner(System.in);
    private final ArrayList<ItemCardapio> cardapio = new ArrayList<>();
    private final CentralCobranca central = new CentralCobranca();
    private Cliente ana;
    private Cliente beto;
    private Pedido pedidoBeto;
    private Pedido pedidoAna;

    // ItemCardapio i = new ItemCardapio("Generico", 10);
    // Erro: ItemCardapio is abstract; cannot be instantiated

    public void simularDia() {
        System.out.println("------------ RangoJá ------------");
        montarCardapio();
        cadastrarClientes();
        abrirPedidoBeto();
        adicionarChoppBeto();
        abrirPedidoAna();
        usarCashbackAna();
        gerarCobrancas();
        System.out.println("Bye bye!");
    }

    // Passo 1
    public void montarCardapio() {
        System.out.println("------ Cardápio ------");
        try {
            cardapio.add(new Prato("Xis Salada", 30, 'M'));
            cardapio.add(new Prato("Xis Bacon", 40, 'G'));
            cardapio.add(new Bebida("Refri", 6, 350, false));
            cardapio.add(new Bebida("Chopp", 12, 500, true));
            cardapio.add(new Sobremesa("Pudim", 8, 150));

            for (ItemCardapio item : cardapio) {
                System.out.println(item);
            }
        } catch (IllegalArgumentException error) {
            System.out.println("Erro: " + error.getMessage());
        }
    }

    // Passo 2
    public void cadastrarClientes() {
        System.out.println("------ Clientes ------");
        try {
            ana = new Cliente("Ana Souza", "ana@furb.br", 20);
            beto = new Cliente("Beto Lima", "beto@furb.br", 17, ana);
            System.out.println("Clientes cadastrados: " + ana + " e " + beto);
            System.out.printf(BR, "Saldo de cashback da Ana: R$ %.2f%n", ana.getSaldoCashback());
        } catch (IllegalArgumentException error) {
            System.out.println("Erro: " + error.getMessage());
        }
    }

    // Passo 3
    public void abrirPedidoBeto() {
        System.out.println("------ Pedido do Beto ------");
        pedidoBeto = new Pedido(beto);
        boolean adicionou = false;
        while (!adicionou) {
            try {
                System.out.println("Quantos " + cardapio.get(0).getNome() + " o Beto vai querer?");
                int quantidade = Integer.parseInt(prompt.nextLine());
                pedidoBeto.adicionarItem(cardapio.get(0), quantidade);
                adicionou = true;
            } catch (NumberFormatException error) {
                System.out.println("A quantidade precisa ser um número");
            } catch (IllegalArgumentException error) {
                System.out.println("Erro: " + error.getMessage());
            }
        }
        System.out.println("Itens no pedido " + pedidoBeto.getNumero() + ": " + pedidoBeto.getQuantidadeItens());
    }

    // Passo 4
    public void adicionarChoppBeto() {
        try {
            pedidoBeto.adicionarItem(cardapio.get(3));
        } catch (IllegalArgumentException error) {
            System.out.println("Não foi possível adicionar o chopp: " + error.getMessage());
        }

        try {
            pedidoBeto.finalizar();
            System.out.println("Pedido " + pedidoBeto.getNumero() + " finalizado");
        } catch (IllegalStateException error) {
            System.out.println("Erro: " + error.getMessage());
        }
    }

    // Passo 5
    public void abrirPedidoAna() {
        System.out.println("------ Pedido da Ana ------");
        pedidoAna = new Pedido(ana);
        try {
            pedidoAna.adicionarItem(cardapio.get(0));
            pedidoAna.adicionarItem(cardapio.get(2));
            pedidoAna.adicionarItem(cardapio.get(4));
            pedidoAna.finalizar();
            System.out.printf(BR, "Pedido %d finalizado. Subtotal R$ %.2f, taxa R$ %.2f, total R$ %.2f%n",
                    pedidoAna.getNumero(), pedidoAna.calcularSubtotal(), pedidoAna.calcularTaxaEntrega(), pedidoAna.calcularValorCobrar());
        } catch (IllegalArgumentException | IllegalStateException error) {
            System.out.println("Erro: " + error.getMessage());
        }

        try {
            pedidoAna.finalizar();
        } catch (IllegalStateException error) {
            System.out.println("Erro: " + error.getMessage());
        }
    }

    // Passo 6
    public void usarCashbackAna() {
        System.out.println("------ Cashback da Ana ------");
        try {
            ana.usarCashback(100);
            System.out.println("Cashback usado com sucesso");
        } catch (SaldoInsuficienteException error) {
            System.out.println("Erro: " + error.getMessage());
        } finally {
            System.out.printf(BR, "Saldo atual da Ana: R$ %.2f%n", ana.getSaldoCashback());
        }
    }

    // Passo 7
    public void gerarCobrancas() {
        System.out.println("------ Central de cobrança ------");
        try {
            AssinaturaClube assinaturaAna = new AssinaturaClube(ana, 19.90, 12);
            central.registrar(assinaturaAna);
            central.registrar(pedidoBeto);
            central.registrar(pedidoAna);
            System.out.println(central.gerarRelatorio());
        } catch (IllegalArgumentException error) {
            System.out.println("Erro: " + error.getMessage());
        }
    }

    public static void main(String[] args) {
        App exe = new App();
        exe.simularDia();
    }
}
