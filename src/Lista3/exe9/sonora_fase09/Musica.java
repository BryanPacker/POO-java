package Lista3.exe9.sonora_fase09;

public class Musica extends Conteudo {
    private String artista;
    private String album;

    public Musica(String titulo, int duracaoSegundos, String artista, String album) {
        super(titulo, duracaoSegundos);
        setArtista(artista);
        setAlbum(album);
    }

    public void setArtista(String artista) {
        if (artista == null || artista.isBlank()) {
            throw new IllegalArgumentException("Nome do artista deve conter ao menos um caractere válido");
        }

        this.artista = artista;
    }

    public String getArtista() {
        return artista;
    }

    public void setAlbum(String album) {
        if (album == null || album.isBlank()) {
            throw new IllegalArgumentException("Nome do álbum deve conter ao menos um caractere válido");
        }

        this.album = album;
    }

    public String getAlbum() {
        return album;
    }

    @Override
    public String getCreditos() {
        return artista + " (" + album + ")";
    }

    public String getDuracaoFormatada() {
        String duracaoFormatada;
        int duracaoSegundos = getDuracaoSegundos();

        if (duracaoSegundos >= 60) {
            int duracaoMinutos = duracaoSegundos / 60;
            int segundos = duracaoSegundos % 60;

            if (duracaoMinutos < 10 && segundos < 10) {
                duracaoFormatada = "0" + duracaoMinutos + ":" + "0" + segundos;
                return duracaoFormatada;
            } else if (duracaoMinutos < 10 && segundos >= 10) {
                duracaoFormatada = "0" + duracaoMinutos + ":" + segundos;
                return duracaoFormatada;
            } else if (duracaoMinutos >= 10 && segundos < 10) {
                duracaoFormatada = duracaoMinutos + ":" + "0" + segundos;
                return duracaoFormatada;
            } else {
                duracaoFormatada = duracaoMinutos + ":" + segundos;
                return duracaoFormatada;
            }
        } else if (duracaoSegundos < 10) {
            duracaoFormatada = "00:0" + duracaoSegundos;
            return duracaoFormatada;
        } else {
            duracaoFormatada = "00:" + duracaoSegundos;
            return duracaoFormatada;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " - " + getCreditos();
    }
}

