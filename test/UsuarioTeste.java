import Lista3.exe3.sonora_fase03.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsuarioTeste {
    Usuario user;

    @BeforeEach
    public void preparar(){
        user = new Usuario("bryan", "bryanpacker74@gmail.com");
    }

    @Test
    @DisplayName("Usuário válido é criado")
    public void TesteCriacaoUsuario() {
        Usuario user = new Usuario( "bryan", "bryanpacker74@gmail.com");
        assertNotNull(user);
    }

    @Test
    @DisplayName("Nome em branco deve ser rejeitado")
    public void TesteNomeInvalido(){
        assertThrows(IllegalArgumentException.class, () -> {
            Usuario user = new Usuario(" ", "bryanpacker74@gmail.com");
        });
    }

    @Test
    @DisplayName("Email em branco deve ser rejeitado")
    public void TesteEmailInvalido(){
        assertThrows(IllegalArgumentException.class, () -> {
            Usuario user = new Usuario("bryan", " ");
        });
    }

    @Test
    @DisplayName("Nome nulo deve ser rejeitado")
    public void TesteNomeNulo(){
        assertThrows(IllegalArgumentException.class, () -> {
            Usuario user = new Usuario(null, "bryanpacker74@gmail.com");
        });
    }

    @Test
    @DisplayName("Email nulo deve ser rejeitado")
    public void TesteEmailNulo(){
        assertThrows(IllegalArgumentException.class, () -> {
            Usuario user = new Usuario("bryan", null);
        });
    }

    @Test
    @DisplayName("Email sem @ deve ser rejeitado")
    public void TesteEmailSemArroba(){
        assertThrows(IllegalArgumentException.class, () -> {
            Usuario user = new Usuario("bryan", "bryanpacker74gmail.com");
        });
    }

    @Test
    @DisplayName("Usuário criado tem id maior que zero")
    public void TesteIdUsuario(){
        assertTrue(user.getId() > 0);
    }

    @Test
    @DisplayName("Setter de nome vazio deve ser rejeitado")
    public void TesteSetNomeVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            user.setNome("");
        });
    }

    @Test
    @DisplayName("Setter de email vazio deve ser rejeitado")
    public void TesteSetEmailVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            user.setEmail("");
        });
    }

    @Test
    @DisplayName("Setters válidos alteram o usuário")
    public void TesteSettersValidos(){
        user.setNome("bryan");
        user.setEmail("bryan@gmail.com");
        assertEquals("bryan", user.getNome());
        assertEquals("bryan@gmail.com", user.getEmail());
    }

}
