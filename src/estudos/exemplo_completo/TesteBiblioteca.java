package estudos.exemplo_completo;

import java.util.ArrayList;

/**
 * Classe de teste para demonstrar o funcionamento da Biblioteca
 * Sem GUI - teste básico de lógica
 */
public class TesteBiblioteca {

    public static void main(String[] args) {
        System.out.println("🧪 TESTE DE BIBLIOTECA\n");

        // Cria a biblioteca
        Biblioteca bib = new Biblioteca("biblioteca_teste.txt");

        // ===== TESTE 1: ADICIONAR LIVROS =====
        System.out.println("1️⃣ Adicionando livros...");
        bib.adicionarLivro(new Livro("1984", "George Orwell", "ISBN001", 45.90, 1949));
        bib.adicionarLivro(new Livro("Dom Casmurro", "Machado de Assis", "ISBN002", 32.50, 1899));
        bib.adicionarLivro(new Livro("O Cortiço", "Aluísio Azevedo", "ISBN003", 28.00, 1890));
        bib.adicionarLivro(new Livro("Grande Sertão: Veredas", "Guimarães Rosa", "ISBN004", 55.00, 1956));
        bib.adicionarLivro(new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", "ISBN005", 50.00, 1881));

        System.out.println("✅ " + bib.obterTodosLivros().size() + " livros adicionados\n");

        // ===== TESTE 2: LISTAR TUDO =====
        System.out.println("2️⃣ Listando todos os livros:");
        for (Livro l : bib.obterTodosLivros()) {
            System.out.println("   " + l);
        }
        System.out.println();

        // ===== TESTE 3: BUSCAR POR AUTOR =====
        System.out.println("3️⃣ Buscando livros de 'Machado de Assis':");
        ArrayList<Livro> porAutor = bib.buscarPorAutor("Machado");
        for (Livro l : porAutor) {
            System.out.println("   " + l);
        }
        System.out.println();

        // ===== TESTE 4: BUSCAR POR TÍTULO =====
        System.out.println("4️⃣ Buscando livros com 'dom' no título:");
        ArrayList<Livro> porTitulo = bib.buscarPorTitulo("dom");
        for (Livro l : porTitulo) {
            System.out.println("   " + l);
        }
        System.out.println();

        // ===== TESTE 5: ESTATÍSTICAS =====
        System.out.println("5️⃣ Estatísticas:");
        System.out.println("   Total de livros: " + bib.obterTodosLivros().size());
        System.out.println("   Livros disponíveis: " + bib.contarDisponiveis());
        System.out.println("   Valor total do acervo: R$ " + String.format("%.2f", bib.calcularValorTotal()));
        System.out.println();

        // ===== TESTE 6: SIMULAR EMPRÉSTIMO =====
        System.out.println("6️⃣ Simulando empréstimo...");
        Livro livro1 = bib.buscarPorId(1);
        if (livro1 != null) {
            System.out.println("   Antes: " + livro1);
            livro1.setDisponivel(false);
            System.out.println("   Depois: " + livro1);
            System.out.println("   Livros disponíveis agora: " + bib.contarDisponiveis());
        }
        System.out.println();

        // ===== TESTE 7: SALVAR EM ARQUIVO =====
        System.out.println("7️⃣ Salvando em arquivo...");
        if (bib.salvar()) {
            System.out.println("   ✅ Salvo em 'biblioteca_teste.txt'");
        }
        System.out.println();

        // ===== TESTE 8: LIMPAR MEMÓRIA E CARREGAR =====
        System.out.println("8️⃣ Limpando memória e carregando do arquivo...");
        Biblioteca bib2 = new Biblioteca("biblioteca_teste.txt");
        bib2.carregar();
        System.out.println("   Carregados " + bib2.obterTodosLivros().size() + " livros");
        System.out.println("   Primeiro livro: " + bib2.buscarPorId(1));
        System.out.println();

        // ===== TESTE 9: REMOVER LIVRO =====
        System.out.println("9️⃣ Removendo livro com ID 3...");
        if (bib.removerLivroPorId(3)) {
            System.out.println("   ✅ Livro removido");
            System.out.println("   Total agora: " + bib.obterTodosLivros().size());
        }
        System.out.println();

        System.out.println("✨ FIM DOS TESTES");
    }
}
