package Lista3.exe3.sonora_fase03;

public class Plataforma {
    Musica[] musicas = new Musica[500];
    Usuario[] usuarios = new Usuario[500];
    private int quantidadeMusica;
    private int quantidadeUsuario;

    public boolean cadastrarMusica(Musica musica){
        if (musica == null || quantidadeMusica > 499) {
            return false;
        }
        else{
            musicas[quantidadeMusica] = musica;
            quantidadeMusica++;
            return true;
        }
    }

    public boolean cadastrarUsuario(Usuario usuario){
        if (usuario == null || quantidadeUsuario > 499) {
            return false;
        }
        else{
            usuarios[quantidadeUsuario] = usuario;
            quantidadeUsuario++;
            return true;
        }
    }

    public Musica buscarMusicaPorId(int id){
        for (int i = 0; i < quantidadeMusica; i++) {
            int idMusica = musicas[i].getId();
            if (idMusica == id) {
                return musicas[i];
            }
        }
        return null;
    }

    public Musica buscarMusica(String titulo){
        for (int i = 0; i < quantidadeMusica; i++) {
            String tituloMusica = musicas[i].getTitulo();
            if (tituloMusica.equals(titulo)) {
                return musicas[i];
            }
        }
        return null;
    }

    public Usuario buscarUsuario(int id){
        for (int i = 0; i < quantidadeUsuario; i++) {
            int ids = usuarios[i].getId();
            if (ids == id) {
                return usuarios[i];
            }
        }
        return null;
    }

    public Usuario buscarUsuario(String nomeUsuario){
        for (int i = 0; i < quantidadeUsuario; i++) {
            String nomes = usuarios[i].getNome();
            if (nomes.equals(nomeUsuario)) {
                return usuarios[i];
            }
        }
        return null;
    }

    public int getTotalMusicas(){
        return quantidadeMusica;
    }

    public int getTotalUsuarios(){
        return quantidadeUsuario;
    }
}
