package Lista3.exe5.sonora_fase05;

public class Conteudo {
    private static int ultimoID;
    protected final int id;
    protected String titulo;
    protected int duracaoSegundos;

    public Conteudo(String titulo, int duracaoSegundos){
        
        if (titulo.isBlank() || titulo == null) {
            throw new IllegalArgumentException("Titulo inválido");
        }
        if (duracaoSegundos < 1) {
            throw new IllegalArgumentException("Duração inválida");
        }

        ultimoID++;
        this.id = ultimoID;
        this.titulo = titulo;
        this.duracaoSegundos = duracaoSegundos;
        
    }
    
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo.isBlank() || titulo == null) {
            throw new IllegalArgumentException("Titulo inválido");
        }

        this.titulo = titulo;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        if (duracaoSegundos < 1) {
            throw new IllegalArgumentException("Duração inválida");
        }
        this.duracaoSegundos = duracaoSegundos;
    }

    public void reproduzir(String titulo){
        System.out.println("Reproduzindo : " + titulo);
    }

    @Override
    public String toString() {
    return "[" + getId() + "] " + titulo + " (" + duracaoSegundos + "s)";
    }
    
}
