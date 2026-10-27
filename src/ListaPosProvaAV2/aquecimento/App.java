package ListaPosProvaAV2.aquecimento;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        System.out.println("Emitidas: " + Senha.getTotalEmitidas());
        Senha s = new Senha("Caixa");
        System.out.println(s.toString());
        Senha s1 = new Senha("Gerência");
        System.out.println(s1.toString());
        Senha s2 = new Senha("Caixa");
        System.out.println(s2.toString());

        try {
            Senha s3 = new Senha("");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        Senha s4 = new Senha("Caixa");
        System.out.println(s4.toString());
        System.out.println("Emitidas: " + Senha.getTotalEmitidas());

        /* a) usando o tipo Midia da pra colocar qualquer midia no lugar e o codigo nao depende de Filme ou Serie */
        Midia f = new Filme("Interestelar", 20.0);
        Midia se = new Serie("Dark", 15.0, 3);
        Midia d = new Documentario("Cosmos", 12.0);
        ArrayList<Midia> catalogo = new ArrayList<>();
        catalogo.add(f);
        catalogo.add(se);
        catalogo.add(d);

        /* b) nao entrou, o documentario nao é Serie entao o if pula ele */
        double totalLegenda = 0;
        for (Midia m : catalogo) {
            if (m instanceof Serie) {
                totalLegenda += ((Serie) m).calcularCustoLegenda();
            }
        }
        System.out.println("Legenda colega: " + totalLegenda);

        /* c) o instanceof tem que ser com Legendavel e o cast pra Legendavel tambem, assim qualquer classe que implementar entra */
        totalLegenda = 0;
        for (Midia m : catalogo) {
            if (m instanceof Legendavel) {
                totalLegenda += ((Legendavel) m).calcularCustoLegenda();
            }
        }
        System.out.println("Legenda: " + totalLegenda);

        /* A3
           Gerente e Funcionario - herança, gerente é um funcionario
           Carro e Motor - composição, o motor nao existe sem o carro
           Playlist e Musica - agregação, a musica continua existindo sem a playlist
           Pedido e Endereco de entrega - composição, o endereço é criado junto com o pedido */
        Pedido pedido = new Pedido(new Cliente("Marina"), "Rua XV de Novembro", 100);
        System.out.println("Entrega: " + pedido.getRuaEntrega() + ", " + pedido.getNumeroEntrega());
    }

}
