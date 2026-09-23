package Lista3.exe5.sonora_fase05;

public class Musica extends Conteudo{
    private int reproducoes;
    private String artista;
    
    // Construtor
    public Musica(String titulo, int duracaoSegundos){        
        super(titulo, duracaoSegundos);
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
        if (duracaoSegundos < 1) {
            throw new IllegalArgumentException("Duração inválida: " + duracaoSegundos + ". Precisa ser maior que 0!");
        }
        
        this.duracaoSegundos = duracaoSegundos;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
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

    // Infs Titulo
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank() ) {
            throw new IllegalArgumentException("Título deve conter ao menos um caractere válido");
        }

        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }    
    
    public void reproduzir(){
        reproducoes++;
    }

    public String getDuracaoFormatada(){
    
        String duracaoFormatada;
        
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
}
