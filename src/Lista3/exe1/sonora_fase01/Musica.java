package Lista3.exe1.sonora_fase01;

public class Musica {
    private static int id;
    private int duracaoSegundos;
    private int reproducoes;
    private String artista;
    private String titulo;

    public Musica(String titulo, String artista, int duracaoSegundos){
        this.titulo = titulo;
        this.artista = artista;
        this.duracaoSegundos = duracaoSegundos;
        this.id++;
    }

    public void reproduzir(){
        reproducoes++;
    }

    public String getDuracaoFormatada(){
    
        String duracaoFormatada;
        
        if (duracaoSegundos > 60) {
            
            int duracaoMinutos = duracaoSegundos / 60; 
            duracaoSegundos = duracaoSegundos % 60;
        
            if (duracaoMinutos < 10 && duracaoSegundos < 10 ) {
                duracaoFormatada = "0"+duracaoMinutos+":"+"0"+duracaoSegundos;
                return duracaoFormatada;
            }
            else if (duracaoMinutos < 10 && duracaoSegundos > 10) {
                duracaoFormatada = "0"+duracaoMinutos+":"+duracaoSegundos;                
                return duracaoFormatada;
            }
            else if (duracaoMinutos > 10 && duracaoSegundos < 10) {
                duracaoFormatada = duracaoMinutos+":"+"0"+duracaoSegundos;                
                return duracaoFormatada;
            }
            else{
                duracaoFormatada = duracaoMinutos+":"+duracaoSegundos;                
                return duracaoFormatada;
            }

        }

        else {
            duracaoFormatada = "00:"+duracaoSegundos;
            return duracaoFormatada;
        }
    }

    // Retorna ID
    public int getId() {
        return id;
    }

    // Duração em segundos
    public int getReproducoes() {
        return reproducoes;
    }

    // Duração em segundos
    public void setDuracaoSegundos(int duracaoSegundos) {
        if (duracaoSegundos > 0) {
            this.duracaoSegundos = duracaoSegundos;        
        }
        else{
            throw new IllegalArgumentException("Duração precisa ser maior que 0!");
        }
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    // Infs Artista
    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getArtista() {
        return artista;
    }

    // Infs Titulo
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }    
}
