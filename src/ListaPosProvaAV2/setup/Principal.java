package ListaPosProvaAV2.setup;

public class Principal {

    public static void main(String[] args) {
        System.out.println("Itens criados: " + ItemSetup.getTotalItens());

        Cliente marina = new Cliente("Marina Souza", "123.456.789-00");
        Orcamento orcamento = new Orcamento(marina, "Blumenau", 7);

        ItemSetup placa = new Peca("Placa de vídeo", 2500.0, 1);
        ItemSetup monitor = new Peca("Monitor 27 polegadas", 1200.0, 3);
        ItemSetup montagem = new Montagem("Montagem e cabeamento", 80.0, 2);

        orcamento.adicionarItem(placa);
        orcamento.adicionarItem(monitor);
        orcamento.adicionarItem(montagem);

        System.out.println("Solicitante: " + orcamento.getSolicitante().getNome());
        System.out.println("Entrega: " + orcamento.getCidadeEntrega() + ", em " + orcamento.getPrazoEntrega() + " dias");

        for (ItemSetup item : orcamento.getItens()) {
            System.out.println(item);
        }

        System.out.println("Valor total: R$ " + orcamento.calcularValorTotal());
        System.out.println("Garantia estendida: R$ " + orcamento.calcularTotalGarantia());

        try {
            orcamento.adicionarItem(placa);
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            ItemSetup montagem2 = new Montagem("Montagem rápida", 80.0, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("Itens criados: " + ItemSetup.getTotalItens());

        /* deu 4 por que o preço base da montagem é valido, entao o ItemSetup ja aumentou o contador no super() e so depois
           a Montagem viu que as horas tavam erradas. Na A1 a validação fica antes do contador no mesmo construtor, aqui quem
           valida as horas é a subclasse depois do super entao nao tem como evitar */

        // bonus
        ItemSetup sistema = new Software("Sistema operacional", 300.0, 2);
        orcamento.adicionarItem(sistema);
        System.out.println("Valor total: R$ " + orcamento.calcularValorTotal());
        System.out.println("Garantia estendida: R$ " + orcamento.calcularTotalGarantia());
        /* deu 951 sem mexer no Orcamento por que o instanceof usa a interface, se fosse com Peca ia continuar 861 */
    }
}
