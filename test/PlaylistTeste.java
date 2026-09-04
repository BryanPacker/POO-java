import Lista3.exe3.sonora_fase03.Usuario;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import Lista3.exe1.sonora_fase01.Musica;
import Lista3.exe3.sonora_fase03.Playlist;

public class PlaylistTeste {
    public void criarPlaylist(){
        Playlist p1 = new Playlist("legal", new Usuario("bryan", "bryanpacker74@gmail.com"));
        assertNotNull(p1);
    }
    public void criarPlaylistNomeInvalido(){
        assertThrows(IllegalArgumentException.class, () -> {
            Playlist p1 = new Playlist(" ", new Usuario("bryan", "bryanpacker74@gmail.com"));
        });
    }
    public void pesquisarPlaylistCheia(){
        Musica[] musicas = new Musica[100];
        Playlist p1 = new Playlist("legal", new Usuario("bryan", "bryanpacker74@gmail.com"));
        for (int i = 0; i < 100; i++) {
            musicas[i] = new Musica("1", "asd", i);
        }
        p1.getNaPosicao(101);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            Playlist p1 = new Playlist("legal", new Usuario("bryan", "bryanpacker74@gmail.com"));
            Musica mus = new Musica("1", "asd", 15);
            p1.adicionar(mus);
            p1.getNaPosicao(1);        
        })
    }
}
