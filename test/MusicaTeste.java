import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import Lista3.exe3.sonora_fase03.Musica;

public class MusicaTeste {

    @Test
    public void testeCriacaoMusica(){
        Musica musica = new Musica("titulo", "Artista", 120);
        assertNotNull(musica);
    }
    @Test
    public void testTituloInvalido(){
        assertThrows(IllegalArgumentException.class, () -> {
            Musica musica = new Musica(" ", "Artista", 120);

        });
    }
    @Test
    public void testDuracaoInvalido(){
        assertThrows(IllegalArgumentException.class, () -> {
            Musica musica = new Musica("Titulo", "Artista", -120);

        });
    }
    @Test
    public void testArtistaInvalido(){
        assertThrows(IllegalArgumentException.class, () -> {
            Musica musica = new Musica("Titulo", " ", 120);
        });
    }

}
