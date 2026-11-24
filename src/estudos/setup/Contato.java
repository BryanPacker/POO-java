package estudos.setup;

// Classe simples que representa um Contato
public class Contato {
    private String nome;
    private String email;
    private String telefone;

    // Construtor
    public Contato(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    // toString para exibir de forma formatada
    @Override
    public String toString() {
        return nome + " | " + email + " | " + telefone;
    }

    // Método para formatar em linha para salvar em arquivo
    public String paraArquivo() {
        return nome + ";" + email + ";" + telefone;
    }

    // Método estático para criar Contato a partir de uma linha do arquivo
    public static Contato deArquivo(String linha) {
        String[] partes = linha.split(";");
        if (partes.length == 3) {
            return new Contato(partes[0], partes[1], partes[2]);
        }
        return null;
    }
}
