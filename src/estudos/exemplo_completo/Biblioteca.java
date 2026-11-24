package estudos.exemplo_completo;

import java.io.*;
import java.util.ArrayList;

// Classe que gerencia persistência em arquivo
public class Biblioteca {
    private ArrayList<Livro> livros;
    private String nomeArquivo;

    // Construtor
    public Biblioteca(String nomeArquivo) {
        this.livros = new ArrayList<>();
        this.nomeArquivo = nomeArquivo;
    }

    // ===== OPERAÇÕES COM DADOS =====

    // Adiciona livro à lista
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    // Remove livro por ID
    public boolean removerLivroPorId(int id) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getId() == id) {
                livros.remove(i);
                return true;
            }
        }
        return false;
    }

    // Busca livro por ID
    public Livro buscarPorId(int id) {
        for (Livro l : livros) {
            if (l.getId() == id) return l;
        }
        return null;
    }

    // Busca livros por título (parcial)
    public ArrayList<Livro> buscarPorTitulo(String titulo) {
        ArrayList<Livro> resultado = new ArrayList<>();
        for (Livro l : livros) {
            if (l.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    // Busca livros por autor
    public ArrayList<Livro> buscarPorAutor(String autor) {
        ArrayList<Livro> resultado = new ArrayList<>();
        for (Livro l : livros) {
            if (l.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    // Retorna todos os livros
    public ArrayList<Livro> obterTodosLivros() {
        return livros;
    }

    // Conta livros disponíveis
    public int contarDisponiveis() {
        int count = 0;
        for (Livro l : livros) {
            if (l.isDisponivel()) count++;
        }
        return count;
    }

    // Calcula valor total do acervo
    public double calcularValorTotal() {
        double total = 0;
        for (Livro l : livros) {
            total += l.getPreco();
        }
        return total;
    }

    // ===== ARQUIVO: SALVAR =====
    public boolean salvar() {
        try {
            FileWriter fw = new FileWriter(nomeArquivo);
            PrintWriter pw = new PrintWriter(fw);

            // Escreve cabeçalho
            pw.println("ID,TITULO,AUTOR,ISBN,PRECO,ANO,DISPONIVEL");

            // Escreve cada livro
            for (Livro l : livros) {
                pw.println(l.paraArquivo());
            }

            pw.close();
            fw.close();
            return true;

        } catch (IOException e) {
            System.err.println("Erro ao salvar: " + e.getMessage());
            return false;
        }
    }

    // ===== ARQUIVO: CARREGAR =====
    public boolean carregar() {
        File arquivo = new File(nomeArquivo);

        // Se não existe, retorna vazio mas sem erro
        if (!arquivo.exists()) {
            System.out.println("Arquivo não encontrado. Iniciando com biblioteca vazia.");
            return true;
        }

        try {
            FileReader fr = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(fr);

            livros.clear();

            String linha;
            boolean primeiraLinha = true; // Pula cabeçalho

            while ((linha = br.readLine()) != null) {
                // Pula a linha de cabeçalho
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                // Carrega livro da linha
                Livro l = Livro.deArquivo(linha);
                if (l != null) {
                    livros.add(l);
                }
            }

            br.close();
            fr.close();
            return true;

        } catch (IOException e) {
            System.err.println("Erro ao carregar: " + e.getMessage());
            return false;
        }
    }
}
