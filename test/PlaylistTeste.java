import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Lista3.exe3.sonora_fase03.Musica;
import Lista3.exe3.sonora_fase03.Playlist;
import Lista3.exe3.sonora_fase03.Usuario;

public class PlaylistTeste {
    Playlist p1;
    Musica m1;
    Musica m2;
    Musica m3;

    @BeforeEach
    public void preparar(){
        p1 = new Playlist("legal", new Usuario("bryan", "bryanpacker74@gmail.com"));
        m1 = new Musica("1", "asd", 15);
        m2 = new Musica("2", "asd", 30);
        m3 = new Musica("3", "asd", 45);
        p1.adicionar(m1);
        p1.adicionar(m2);
        p1.adicionar(m3);
    }

    @Test
    @DisplayName("Playlist válida é criada")
    public void criarPlaylist(){
        Playlist p1 = new Playlist("legal", new Usuario("bryan", "bryanpacker74@gmail.com"));
        assertNotNull(p1);
    }
    @Test
    @DisplayName("Nome em branco deve ser rejeitado")
    public void criarPlaylistNomeInvalido(){
        assertThrows(IllegalArgumentException.class, () -> {
            Playlist p1 = new Playlist(" ", new Usuario("bryan", "bryanpacker74@gmail.com"));
        });
    }
    @Test
    @DisplayName("Dono nulo deve ser rejeitado")
    public void criarPlaylistDonoNulo(){
        assertThrows(IllegalArgumentException.class, () -> {
            Playlist p1 = new Playlist("legal", null);
        });
    }
    @Test
    @DisplayName("Posição além da playlist cheia deve ser rejeitada")
    public void pesquisarPlaylistCheia(){
        Playlist p1 = new Playlist("legal", new Usuario("bryan", "bryanpacker74@gmail.com"));
        for (int i = 0; i < 100; i++) {
            p1.adicionar(new Musica("1", "asd", i + 1));
        }
        assertThrows(IndexOutOfBoundsException.class, () -> {
            p1.getNaPosicao(101);
        });
    }
    @Test
    @DisplayName("Adicionar com espaço retorna true")
    public void testeAdicionarComEspaco(){
        Musica mus = new Musica("4", "asd", 60);
        assertTrue(p1.adicionar(mus));
    }
    @Test
    @DisplayName("Adicionar com espaço aumenta a quantidade em um")
    public void testeAdicionarAumentaQuantidade(){
        Musica mus = new Musica("4", "asd", 60);
        p1.adicionar(mus);
        assertEquals(4, p1.getQuantidade());
    }
    @Test
    @DisplayName("Adicionar até encher retorna true em todas")
    public void testeAdicionarAteEncher(){
        boolean adicionou = true;
        for (int i = p1.getQuantidade(); i < 100; i++) {
            adicionou = adicionou && p1.adicionar(new Musica("1", "asd", i + 1));
        }
        assertTrue(adicionou);
        assertEquals(100, p1.getQuantidade());
    }
    @Test
    @DisplayName("Playlist cheia recusa nova música")
    public void testeAdicionarPlaylistCheia(){
        for (int i = p1.getQuantidade(); i < 100; i++) {
            p1.adicionar(new Musica("1", "asd", i + 1));
        }
        Musica mus = new Musica("101", "asd", 60);
        assertFalse(p1.adicionar(mus));
        assertEquals(100, p1.getQuantidade());
    }
    @Test
    @DisplayName("Música nula deve ser rejeitada")
    public void testeAdicionarMusicaNula(){
        assertThrows(IllegalArgumentException.class, () -> {
            p1.adicionar(null);
        });
    }
    @Test
    @DisplayName("Posição válida devolve a música certa")
    public void testeGetNaPosicaoValida(){
        assertEquals(m2, p1.getNaPosicao(1));
    }
    @Test
    @DisplayName("Índice negativo deve ser rejeitado")
    public void testeGetNaPosicaoNegativa(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            p1.getNaPosicao(-1);
        });
    }
    @Test
    @DisplayName("Índice além da quantidade deve ser rejeitado")
    public void testeGetNaPosicaoAlemDaQuantidade(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            p1.getNaPosicao(3);
        });
    }
    @Test
    @DisplayName("Playlist vazia não tem posição zero")
    public void testeGetNaPosicaoPlaylistVazia(){
        Playlist p2 = new Playlist("vazia", new Usuario("bryan", "bryanpacker74@gmail.com"));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            p2.getNaPosicao(0);
        });
    }
    @Test
    @DisplayName("Remover posição válida retorna true e diminui a quantidade")
    public void testeRemoverPosicaoValida(){
        assertTrue(p1.removerNaPosicao(1));
        assertEquals(2, p1.getQuantidade());
    }
    @Test
    @DisplayName("Música seguinte assume a posição removida")
    public void testeRemoverReorganiza(){
        p1.removerNaPosicao(0);
        assertEquals(m2, p1.getNaPosicao(0));
        assertEquals(m3, p1.getNaPosicao(1));
    }
    @Test
    @DisplayName("Remover a última posição não deixa buraco")
    public void testeRemoverUltimaPosicao(){
        p1.removerNaPosicao(2);
        assertEquals(m1, p1.getNaPosicao(0));
        assertEquals(m2, p1.getNaPosicao(1));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            p1.getNaPosicao(2);
        });
    }
    @Test
    @DisplayName("Remover com índice negativo deve ser rejeitado")
    public void testeRemoverPosicaoNegativa(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            p1.removerNaPosicao(-1);
        });
    }
    @Test
    @DisplayName("Remover com índice além da quantidade deve ser rejeitado")
    public void testeRemoverAlemDaQuantidade(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            p1.removerNaPosicao(3);
        });
    }
    @Test
    @DisplayName("Duração total soma todas as músicas")
    public void testeDuracaoTotal(){
        assertEquals(90, p1.getDuracaoTotalSegundos());
    }
    @Test
    @DisplayName("Reproduzir tudo conta uma reprodução em cada música")
    public void testeReproduzirTudo(){
        p1.reproduzirTudo();
        assertEquals(1, m1.getReproducoes());
        assertEquals(1, m2.getReproducoes());
        assertEquals(1, m3.getReproducoes());
    }
}
