import org.junit.jupiter.api.Test;

import Lista3.exe1.sonora_fase01.Musica;

public class MusicaTeste {

    @Test
    public void testeCriacaoMusica(){
        Musica musica = new Musica("titulo", "Artista", 120);
        AssertNotNull(musica);
    }
    @Test
    public void testTituloInvalido(){
        AssertThrows(IllegalArgumentException.class, () -> {
            Musica musica = new Musica(" ", "Artista", 120);

        });
    }
    @Test
    public void testDuracaoInvalido(){
        AssertThrows(IllegalArgumentException.class, () -> {
            Musica musica = new Musica("Titulo", "Artista", -120);

        });
    }
    @Test
    public void testArtistaInvalido(){
        AssertThrows(IllegalArgumentException.class, () -> {
            Musica musica = new Musica("Titulo", " ", 120);
        });
    }

}
