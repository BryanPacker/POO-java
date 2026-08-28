package Lista3.exe2.sonora_fase02;

public class Usuario {
    private static int ultimoID;
    private final int id;
    private String nome;
    private String email;

    public Usuario(String nome, String email){
        ultimoID++;

        if (nome.isBlank() || nome == null) {
            throw new IllegalArgumentException("Nome precisa conter ao menos 1 caracterie válido")
        }
        if (email.isBlank() || email == null) {
            throw new IllegalArgumentException("Email precisa conter ao menos 1 caracterie válido")
        }

        this.nome = nome;
        this.email = email;
        this.id = ultimoID;
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

    public void setNome(String nome){
        if (nome.isBlank() || nome == null) {
            throw new IllegalArgumentException("Nome precisa conter ao menos 1 caracterie válido")
        }
        
        this.nome = nome;
    }

    public void setEmail(String email){
        if (email.isBlank() || email == null) {
            throw new IllegalArgumentException("Email precisa conter ao menos 1 caracterie válido")
        }

        this.email = email;
    }
}
