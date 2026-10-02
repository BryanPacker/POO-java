package Lista3.exe9.sonora_fase09;

public class Usuario {
    private static int ultimoID;
    private final int id;
    private String nome;
    private String email;
    private Plano plano;

    public Usuario(String nome, String email) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome precisa conter ao menos 1 caractere válido");
        }
        if (email == null || email.isBlank() || !email.contains("@")) {
            throw new IllegalArgumentException("Email precisa conter ao menos 1 caractere válido e um @");
        }

        ultimoID++;

        this.nome = nome;
        this.email = email;
        this.id = ultimoID;
        this.plano = new PlanoGratuito();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome precisa conter ao menos 1 caractere válido");
        }

        this.nome = nome;
    }

    public void setEmail(String email) {
        if (email == null || email.isBlank() || !email.contains("@")) {
            throw new IllegalArgumentException("Email precisa conter ao menos 1 caractere válido e um @");
        }

        this.email = email;
    }

    public void assinar(Plano novoPlano) {
        if (novoPlano == null) {
            throw new IllegalArgumentException("Plano inválido");
        }

        this.plano = novoPlano;
    }

    public String getResumoPlano() {
        return plano.resumo();
    }
}

