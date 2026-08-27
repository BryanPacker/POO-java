package Lista3.exe2.sonora_fase01;

public class Playlist {
    private Musica[] musicas = new Musica[100];
    private String nome;
    private Usuario dono;
    private int quantidade;

    public Playlist(String nome, Usuario dono){
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
        if (musica != null && quantidade < musicas.length) {
            musicas[quantidade] = musica;
            quantidade++;
            return true;
        }
        else{
            return false;
        }
    }
    
    public Musica getNaPosicao(int indice){
        if (indice >= 0 && indice < quantidade) {
            return musicas[indice];  
        }   
        else{
            return null;
        }
    }

    public boolean removerNaPosicao(int indice) {
        if (indice < 0 || indice >= quantidade) {
            return false;
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