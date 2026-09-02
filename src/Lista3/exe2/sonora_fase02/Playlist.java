package Lista3.exe2.sonora_fase02;

public class Playlist {
    private Musica[] musicas = new Musica[100];
    private String nome;
    private Usuario dono;
    private int quantidade;

    public Playlist(String nome, Usuario dono){
        
        if ( (nome == null || nome.isBlank()) || dono == null) {
            throw new IllegalArgumentException("Playlist precisa de um nome válido e de um dono não nulo");
        }
        this.nome = nome;
        this.dono = dono;

    }
    public String getNome(){
        return nome;
    }

    public Usuario getDono(){
        return dono;
    }
    public int getQuantidade(){
        return quantidade;
    }
    
    public boolean adicionar(Musica musica){
        if (musica == null) {
            throw new IllegalArgumentException("Música não pode ser um objeto nulo");
        }
        if (quantidade < musicas.length) {
            musicas[quantidade] = musica;
            quantidade++;
            return true;
        }

        return false;
        }
    
    public Musica getNaPosicao(int indice){
        if (indice < 0 || indice >= quantidade) {
            throw new IndexOutOfBoundsException("Posição inválida: " + indice + ". Use um número de 0 até " + (quantidade - 1));
        }   
        
        return musicas[indice];  
    }

    public boolean removerNaPosicao(int indice) {
        if (indice < 0 || indice >= quantidade) {
            throw new IndexOutOfBoundsException("Posição inválida: " + indice + ". Use um número de 0 até " + (quantidade - 1));
        }
        for (int i = indice; i < quantidade - 1; i++) {
            musicas[i] = musicas[i + 1];
        }
        quantidade--;
        musicas[quantidade] = null;     
        return true;
    }

    public int getDuracaoTotalSegundos(){
        int duracaoTotalSegundos = 0;
        for (int i = 0; i < quantidade; i++) {
            duracaoTotalSegundos += musicas[i].getDuracaoSegundos();
        }
        return duracaoTotalSegundos;
    }

    public void reproduzirTudo(){
        for (int i = 0; i < quantidade; i++) {
            musicas[i].reproduzir();
        }   
    }
}