package Lista3.exe5.sonora_fase05;

public class Podcast extends Conteudo {
    private String apresentador;
    private int numeroEpisodio;

    public Podcast(String titulo, int duracaoSegundos, String apresentador, int numeroEpisodio){
        super(titulo, duracaoSegundos);
        setApresentador(apresentador);
        setNumeroEpisodio(numeroEpisodio);
    }

    public String getApresentador() {
        return apresentador;
    }

    public void setApresentador(String apresentador) {
        if (apresentador == null || apresentador.isBlank()) {
            throw new IllegalArgumentException("Nome do apresentador deve conter ao menos um caractere válido");
        }
        this.apresentador = apresentador;
    }

    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio) {
        if (numeroEpisodio < 1) {
            throw new IllegalArgumentException("Número de episódio inválido: " + numeroEpisodio + ". Precisa ser maior ou igual a 1!");
        }
        this.numeroEpisodio = numeroEpisodio;
    }

    @Override
    public String toString() {
        return super.toString() + " - Ep. " + numeroEpisodio + " com " + apresentador;
    }
}
