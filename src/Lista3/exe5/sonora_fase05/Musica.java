package Lista3.exe5.sonora_fase05;

public class Musica extends Conteudo{
    private int reproducoes;
    private String artista;
    private String album;

    // Construtor
    public Musica(String titulo, int duracaoSegundos, String artista, String album){
        super(titulo, duracaoSegundos);
        setArtista(artista);
        setAlbum(album);
    }

    // Reproduções
    public int getReproducoes() {
        return reproducoes;
    }

    // Infs Artista
    public void setArtista(String artista) {
        if (artista == null || artista.isBlank() ) {
            throw new IllegalArgumentException("Nome do artista deve conter ao menos um caractere válido");
        }

        this.artista = artista;
    }

    public String getArtista() {
        return artista;
    }

    // Infs Album
    public void setAlbum(String album) {
        if (album == null || album.isBlank() ) {
            throw new IllegalArgumentException("Nome do álbum deve conter ao menos um caractere válido");
        }

        this.album = album;
    }

    public String getAlbum() {
        return album;
    }

    @Override
    public void reproduzir(){
        super.reproduzir();
        reproducoes++;
    }

    public String getDuracaoFormatada(){

        String duracaoFormatada;
        int duracaoSegundos = getDuracaoSegundos();

        if (duracaoSegundos >= 60) {

            int duracaoMinutos = duracaoSegundos / 60;
            int segundos = duracaoSegundos % 60;

            if (duracaoMinutos < 10 && segundos < 10 ) {
                duracaoFormatada = "0"+duracaoMinutos+":"+"0"+segundos;
                return duracaoFormatada;
            }
            else if (duracaoMinutos < 10 && segundos >= 10) {
                duracaoFormatada = "0"+duracaoMinutos+":"+segundos;
                return duracaoFormatada;
            }
            else if (duracaoMinutos >= 10 && segundos < 10) {
                duracaoFormatada = duracaoMinutos+":"+"0"+segundos;
                return duracaoFormatada;
            }
            else{
                duracaoFormatada = duracaoMinutos+":"+segundos;
                return duracaoFormatada;
            }

        }

        else if (duracaoSegundos < 10) {
            duracaoFormatada = "00:0"+duracaoSegundos;
            return duracaoFormatada;
        }
        else {
            duracaoFormatada = "00:"+duracaoSegundos;
            return duracaoFormatada;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " - " + artista + " (" + album + ")";
    }
}
