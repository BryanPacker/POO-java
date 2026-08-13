package Lista2.listaexe.q2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Produto p1 = new Produto();
        p1.repor(10);
        p1.setPreco(-1);
        p1.setNome("sdfbfd");
        Produto p2 = new Produto();
        p2.repor(10);
        p2.setPreco(10);
        p2.setNome("Bolacha");
        System.out.println("o produto " + p1.getNome() + " tem o preço " + p1.getPreco() + " e tem um estoque igual a " + p1.getEstoque());
        System.out.println("o produto " +  p2.getNome() + " tem o preço " + p2.getPreco() + " e tem um estoque igual a " + p2.getEstoque());        
    }
}
