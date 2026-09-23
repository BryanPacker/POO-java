package Lista3.exe5.sonora_fase05;

public class Podcast extends Conteudo {
    private String apresentador;
    private int numeroEpisodio;    

    public Podcast(String titulo, int duracaoSegundos){
        super(titulo, duracaoSegundos);
    }

    public String getApresentador() {
        return apresentador;
    }

    public void setApresentador(String apresentador) {
        this.apresentador = apresentador;
    }

    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio) {
        for(numeroEpisodio < 1){
            throw new IllegalArgumentException("Número de episódio inválido");
        }
        this.numeroEpisodio = numeroEpisodio;
    }

    
}
