package Lista3.exe2.sonora_fase01;

public class Usuario {
    private static int ultimoID;
    private final int id;
    private String nome;
    private String email;

    public Usuario(String nome, String email){
        ultimoID++;
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
        this.nome = nome;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
