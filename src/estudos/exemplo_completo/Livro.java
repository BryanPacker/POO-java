package estudos.exemplo_completo;

// Classe modelo: Livro com múltiplos atributos
public class Livro {
    private static int proximoId = 1; // Contador automático de IDs

    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private double preco;
    private int ano;
    private boolean disponivel;

    // Construtor
    public Livro(String titulo, String autor, String isbn, double preco, int ano) {
        this.id = proximoId++;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.preco = preco;
        this.ano = ano;
        this.disponivel = true;
    }

    // Construtor auxiliar (para carregar do arquivo com ID)
    public Livro(int id, String titulo, String autor, String isbn, double preco, int ano, boolean disponivel) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.preco = preco;
        this.ano = ano;
        this.disponivel = disponivel;
        if (id >= proximoId) proximoId = id + 1; // Atualiza contador
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }
    public double getPreco() { return preco; }
    public int getAno() { return ano; }
    public boolean isDisponivel() { return disponivel; }

    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
    public void setPreco(double preco) { this.preco = preco; }

    // Formata para exibição na interface
    @Override
    public String toString() {
        return String.format("[%d] %s - %s (%d) | R$%.2f | %s",
            id, titulo, autor, ano, preco,
            disponivel ? "✓ Disponível" : "✗ Emprestado");
    }

    // Formata para salvar em arquivo (formato CSV)
    public String paraArquivo() {
        return id + "," + titulo + "," + autor + "," + isbn + "," + preco + "," + ano + "," + disponivel;
    }

    // Reconstrói Livro a partir de linha do arquivo
    public static Livro deArquivo(String linha) {
        try {
            String[] partes = linha.split(",");
            if (partes.length == 7) {
                return new Livro(
                    Integer.parseInt(partes[0]),
                    partes[1],
                    partes[2],
                    partes[3],
                    Double.parseDouble(partes[4]),
                    Integer.parseInt(partes[5]),
                    Boolean.parseBoolean(partes[6])
                );
            }
        } catch (NumberFormatException e) {
            System.err.println("Erro ao ler linha: " + linha);
        }
        return null;
    }
}
