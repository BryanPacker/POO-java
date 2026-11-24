package estudos;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        /*
         * System.out.println(Senha.getTotalEmitidas());
         * Senha p1 = new Senha("Caixa");
         * System.out.println(p1);
         * Senha p2 = new Senha("Gerencia");
         * System.out.println(p2);
         * Senha p3 = new Senha("Caixa");
         * System.out.println(p3);
         * 
         * try {
         * Senha p4 = new Senha(" ");
         * System.out.println(p4);
         * 
         * } catch (Exception e) {
         * System.out.println(e.getMessage());
         * }
         * Senha p5 = new Senha("Caixa");
         * System.out.println(p5);
         * 
         * System.out.println("Emitidas: " + Senha.getTotalEmitidas());
         */

        // Declarar como Midia ao invés de Filme/Serie permite:
        // 1. Polymorfismo: mesmo tipo para diferentes subclasses
        // 2. Flexibilidade: posso trocar a implementação sem mudar o tipo
        // 3. Extensibilidade: novas classes que herdam de Midia funcionam automaticamente
        Midia f = new Filme("Interestelar", 20.0);
        Midia s = new Serie("Dark", 15.0, 3);
        Midia d = new Documentario("Planet Earth", 10.0);

        ArrayList<Midia> catalogo = new ArrayList<>();
        catalogo.add(f);
        catalogo.add(s);
        catalogo.add(d);

        double totalLegenda = 0;
        for (Midia m : catalogo) {
            if (m instanceof Legendavel) {
                totalLegenda += ((Legendavel) m).calcularCustoLegenda();
            }
        }

        System.out.println("Total de custo de legenda: " + totalLegenda);
    }
}
