import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Lista3.exe3.sonora_fase03.Musica;
import Lista3.exe3.sonora_fase03.Usuario;

public class MusicaTeste {
    Musica musica;
    
    @BeforeEach
    public void preparar(){
        musica = new Musica("titulo", "Artista", 120);
    }

    @Test
    @DisplayName("Música válida é criada")
    public void testeCriacaoMusica(){
        Musica musica = new Musica("titulo", "Artista", 120);
        assertNotNull(musica);
    }
    @Test
    @DisplayName("Título em branco deve ser rejeitado")
    public void testTituloInvalido(){
        assertThrows(IllegalArgumentException.class, () -> {
            Musica musica = new Musica(" ", "Artista", 120);

        });
    }
    @Test
    @DisplayName("Duração inválida deve ser rejeitada")
    public void testDuracaoInvalido(){
        assertThrows(IllegalArgumentException.class, () -> {
            Musica musica = new Musica("Titulo", "Artista", -120);

        });
    }
    @Test
    @DisplayName("Artista em branco deve ser rejeitado")
    public void testArtistaInvalido(){
        assertThrows(IllegalArgumentException.class, () -> {
            Musica musica = new Musica("Titulo", " ", 120);
        });
    }
    @Test
    @DisplayName("Duração com minutos e segundos")
    public void testeDuracaoMinutosSegundos(){
        Musica mus = new Musica("titulo", "Artista", 125);
        assertEquals("02:05", mus.getDuracaoFormatada());
    }
    @Test
    @DisplayName("Duração redonda em minutos")
    public void testeDuracaoRedonda(){
        Musica mus = new Musica("titulo", "Artista", 90);
        assertEquals("01:30", mus.getDuracaoFormatada());
    }
    @Test
    @DisplayName("Menos de um minuto, com zero a esquerda")
    public void testeDuracaoMenosDeUmMinuto(){
        Musica mus = new Musica("titulo", "Artista", 5);
        assertEquals("00:05", mus.getDuracaoFormatada());
    }
    @Test
    @DisplayName("Dois dígitos nos minutos")
    public void testeDuracaoDoisDigitosMinutos(){
        Musica mus = new Musica("titulo", "Artista", 600);
        assertEquals("10:00", mus.getDuracaoFormatada());
    }
    @Test
    @DisplayName("Valor logo abaixo de dez minutos")
    public void testeDuracaoAbaixoDezMinutos(){
        Musica mus = new Musica("titulo", "Artista", 599);
        assertEquals("09:59", mus.getDuracaoFormatada());
    }
    @Test
    @DisplayName("Título vazio deve ser rejeitado")
    public void testeTituloVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            Musica mus = new Musica("", "Queen", 355);
        });
    }
    @Test
    @DisplayName("Título nulo deve ser rejeitado")
    public void testeTituloNulo(){
        assertThrows(IllegalArgumentException.class, () -> {
            Musica mus = new Musica(null, "Queen", 355);
        });
    }
    @Test
    @DisplayName("Artista vazio deve ser rejeitado")
    public void testeArtistaVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            Musica mus = new Musica("Bohemian Rhapsody", "", 355);
        });
    }
    @Test
    @DisplayName("Duração zero deve ser rejeitada")
    public void testeDuracaoZero(){
        assertThrows(IllegalArgumentException.class, () -> {
            Musica mus = new Musica("Bohemian Rhapsody", "Queen", 0);
        });
    }
    @Test
    @DisplayName("Duração negativa deve ser rejeitada")
    public void testeDuracaoNegativa(){
        assertThrows(IllegalArgumentException.class, () -> {
            Musica mus = new Musica("Bohemian Rhapsody", "Queen", -10);
        });
    }
    @Test
    @DisplayName("Dados validos criam a música")
    public void testeDadosValidos(){
        Musica mus = new Musica("Bohemian Rhapsody", "Queen", 355);
        assertNotNull(mus);
        assertTrue(mus.getId() > 0);
    }
    @Test
    @DisplayName("Setter de título vazio deve ser rejeitado")
    public void testeSetTituloVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            musica.setTitulo("");
        });
    }
    @Test
    @DisplayName("Setter de artista nulo deve ser rejeitado")
    public void testeSetArtistaNulo(){
        assertThrows(IllegalArgumentException.class, () -> {
            musica.setArtista(null);
        });
    }
    @Test
    @DisplayName("Setter de duração zero deve ser rejeitado")
    public void testeSetDuracaoZero(){
        assertThrows(IllegalArgumentException.class, () -> {
            musica.setDuracaoSegundos(0);
        });
    }
    @Test
    @DisplayName("Setters válidos alteram a música")
    public void testeSettersValidos(){
        musica.setTitulo("novo");
        musica.setArtista("outro");
        musica.setDuracaoSegundos(300);
        assertEquals("novo", musica.getTitulo());
        assertEquals("outro", musica.getArtista());
        assertEquals(300, musica.getDuracaoSegundos());
    }
    @Test
    @DisplayName("Música nova começa com zero reproduções")
    public void testeReproducoesIniciais(){
        assertEquals(0, musica.getReproducoes());
    }
    @Test
    @DisplayName("Uma reprodução deixa o contador em um")
    public void testeReproduzirUmaVez(){
        musica.reproduzir();
        assertEquals(1, musica.getReproducoes());
    }
    @Test
    @DisplayName("Três reproduções deixam o contador em três")
    public void testeReproduzirTresVezes(){
        musica.reproduzir();
        musica.reproduzir();
        musica.reproduzir();
        assertEquals(3, musica.getReproducoes());
    }
    @Test
    @DisplayName("Ids de músicas criadas em sequência são consecutivos")
    public void testeIdsSequenciais(){
        Musica m1 = new Musica("titulo", "Artista", 120);
        Musica m2 = new Musica("titulo", "Artista", 120);
        Musica m3 = new Musica("titulo", "Artista", 120);
        assertEquals(m1.getId() + 1, m2.getId());
        assertEquals(m2.getId() + 1, m3.getId());
    }
    @Test
    @DisplayName("Criar usuário não altera a sequência de ids de música")
    public void testeIdMusicaIndependenteDeUsuario(){
        Musica m1 = new Musica("titulo", "Artista", 120);
        Usuario user = new Usuario("bryan", "bryanpacker74@gmail.com");
        Musica m2 = new Musica("titulo", "Artista", 120);
        assertEquals(m1.getId() + 1, m2.getId());
    }
    @Test
    @DisplayName("Criar música não altera a sequência de ids de usuário")
    public void testeIdUsuarioIndependenteDeMusica(){
        Usuario u1 = new Usuario("bryan", "bryanpacker74@gmail.com");
        Musica mus = new Musica("titulo", "Artista", 120);
        Usuario u2 = new Usuario("bryan", "bryanpacker74@gmail.com");
        assertEquals(u1.getId() + 1, u2.getId());
    }

}
