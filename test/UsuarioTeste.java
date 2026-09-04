import Lista3.exe3.sonora_fase03.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UsuarioTeste {

    @Test
    public void TesteCriacaoUsuario() {
        Usuario user = new Usuario( "bryan", "bryanpacker74@gmail.com");
        assertNotNull(user);
    }

    @Test
    public void TesteNomeInvalido(){
        assertThrows(IllegalArgumentException.class, () -> {
            Usuario user = new Usuario(" ", "bryanpacker74@gmail.com");
        });
    }

    @Test
    public void TesteEmailInvalido(){
        assertThrows(IllegalArgumentException.class, () -> {
            Usuario user = new Usuario("bryan", " ");
        });
    }

}
