import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Lista3.exe3.sonora_fase03.Musica;
import Lista3.exe3.sonora_fase03.Plataforma;
import Lista3.exe3.sonora_fase03.Usuario;

public class PlataformaTeste {
    Plataforma p1;
    Musica m1;
    Musica m2;
    Usuario user;

    @BeforeEach
    public void preparar(){
        p1 = new Plataforma();
        m1 = new Musica("titulo", "Artista", 120);
        m2 = new Musica("outra", "Artista", 200);
        user = new Usuario("bryan", "bryanpacker74@gmail.com");
        p1.cadastrarMusica(m1);
        p1.cadastrarMusica(m2);
        p1.cadastrarUsuario(user);
    }

    @Test
    @DisplayName("Buscar por título cadastrado devolve a música")
    public void testeBuscarMusicaPorTitulo(){
        assertEquals(m1, p1.buscarMusica("titulo"));
    }
    @Test
    @DisplayName("Buscar por id cadastrado devolve a música")
    public void testeBuscarMusicaPorId(){
        assertEquals(m2, p1.buscarMusicaPorId(m2.getId()));
    }
    @Test
    @DisplayName("Buscar por título inexistente devolve null")
    public void testeBuscarMusicaTituloInexistente(){
        assertNull(p1.buscarMusica("nao existe"));
    }
    @Test
    @DisplayName("Buscar por id inexistente devolve null")
    public void testeBuscarMusicaIdInexistente(){
        assertNull(p1.buscarMusicaPorId(-1));
    }
    @Test
    @DisplayName("Plataforma sem músicas devolve null")
    public void testeBuscarMusicaPlataformaVazia(){
        Plataforma p2 = new Plataforma();
        assertNull(p2.buscarMusica("titulo"));
        assertNull(p2.buscarMusicaPorId(m1.getId()));
    }
    @Test
    @DisplayName("Cadastrar música retorna true e aumenta o total")
    public void testeCadastrarMusica(){
        Musica mus = new Musica("nova", "Artista", 90);
        assertTrue(p1.cadastrarMusica(mus));
        assertEquals(3, p1.getTotalMusicas());
    }
    @Test
    @DisplayName("Cadastrar música nula retorna false")
    public void testeCadastrarMusicaNula(){
        assertFalse(p1.cadastrarMusica(null));
        assertEquals(2, p1.getTotalMusicas());
    }
    @Test
    @DisplayName("Cadastrar música com estrutura cheia retorna false")
    public void testeCadastrarMusicaCheia(){
        for (int i = p1.getTotalMusicas(); i < 500; i++) {
            p1.cadastrarMusica(new Musica("1", "asd", i + 1));
        }
        Musica mus = new Musica("501", "asd", 60);
        assertFalse(p1.cadastrarMusica(mus));
        assertEquals(500, p1.getTotalMusicas());
    }
    @Test
    @DisplayName("Cadastrar usuário retorna true e aumenta o total")
    public void testeCadastrarUsuario(){
        Usuario u2 = new Usuario("ana", "ana@gmail.com");
        assertTrue(p1.cadastrarUsuario(u2));
        assertEquals(2, p1.getTotalUsuarios());
    }
    @Test
    @DisplayName("Cadastrar usuário nulo retorna false")
    public void testeCadastrarUsuarioNulo(){
        assertFalse(p1.cadastrarUsuario(null));
        assertEquals(1, p1.getTotalUsuarios());
    }
    @Test
    @DisplayName("Cadastrar usuário com estrutura cheia retorna false")
    public void testeCadastrarUsuarioCheia(){
        for (int i = p1.getTotalUsuarios(); i < 500; i++) {
            p1.cadastrarUsuario(new Usuario("bryan", "bryanpacker74@gmail.com"));
        }
        Usuario u2 = new Usuario("ana", "ana@gmail.com");
        assertFalse(p1.cadastrarUsuario(u2));
        assertEquals(500, p1.getTotalUsuarios());
    }
    @Test
    @DisplayName("Buscar usuário por nome cadastrado devolve o usuário")
    public void testeBuscarUsuarioPorNome(){
        assertEquals(user, p1.buscarUsuario("bryan"));
    }
    @Test
    @DisplayName("Buscar usuário por id cadastrado devolve o usuário")
    public void testeBuscarUsuarioPorId(){
        assertEquals(user, p1.buscarUsuario(user.getId()));
    }
    @Test
    @DisplayName("Buscar usuário inexistente devolve null")
    public void testeBuscarUsuarioInexistente(){
        assertNull(p1.buscarUsuario("ninguem"));
        assertNull(p1.buscarUsuario(-1));
    }
}
