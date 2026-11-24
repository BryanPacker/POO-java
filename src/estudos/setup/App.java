package estudos.setup;

public class App {
    public static void main(String[] args) {
        System.out.println(ItemSetup.getTotalItens());
        Cliente c1 = new Cliente("Mariana Souza", "123.456.789-00");
        Orcamento o1 = new Orcamento(c1, "Blumenau", 7);
        ItemSetup i1 = new Peca("placa de video", 2500, 3);
        ItemSetup i2 = new Peca("monitor", 1200, 3);
        ItemSetup i3 = new Montagem("montagem e cabeamento", 80, 2);

        o1.adicionarItem(i1);
        o1.adicionarItem(i2);
        o1.adicionarItem(i3);

        System.out.println(o1.getSolicitante());
        System.out.println(o1.getCidadeEntrega());
        System.out.println(o1.getPrazoEntrega());

        for (ItemSetup i : o1.getItens()) {
            System.out.println(i);
        }

        System.out.println(o1.calcularValorTotal());
        System.out.println(o1.calcularTotalGarantia());

        try {
            ItemSetup i4 = new Peca("placa de video", 2500, 3);
            ItemSetup i5 = new Montagem("montagem e cabeamento", 80, 0);

        } catch (Exception e) {
            System.out.println("Não foi possivel criar os produtos");
        }

        System.out.println(ItemSetup.getTotalItens());
    }
}
