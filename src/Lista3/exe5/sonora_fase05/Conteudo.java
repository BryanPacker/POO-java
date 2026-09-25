package Lista3.exe5.sonora_fase05;

public class Conteudo {
    private static int ultimoID;
    private int id;
    private String titulo;
    private int duracaoSegundos;

    public Conteudo(String titulo, int duracaoSegundos){
        ultimoID++;
        this.id = ultimoID;
        setTitulo(titulo);
        setDuracaoSegundos(duracaoSegundos);
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Título deve conter ao menos um caractere válido");
        }

        this.titulo = titulo;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        if (duracaoSegundos < 1) {
            throw new IllegalArgumentException("Duração inválida: " + duracaoSegundos + ". Precisa ser maior que 0!");
        }
        this.duracaoSegundos = duracaoSegundos;
    }

    public void reproduzir(){
        System.out.println("Reproduzindo: " + toString());
    }

    @Override
    public String toString() {
        return "[" + getId() + "] " + titulo + " (" + duracaoSegundos + "s)";
    }

}
