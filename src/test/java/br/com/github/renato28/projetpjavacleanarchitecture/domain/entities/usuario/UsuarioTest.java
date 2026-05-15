package br.com.github.renato28.projetpjavacleanarchitecture.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {

    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
            new Usuario("123456.789-99", "Renato", LocalDate.parse("1992-08-04"), "teste@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class, () ->
           new Usuario("12345678999", "Renato", LocalDate.parse("1988-10-05"), "teste@email.com"));

    }

    @Test
    public void deveCadastrarUsuarioFabricaDeUsuario() {
        FabricaDeUsuario fabrica =  new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimento("Joao", "456.365.671-34",
                LocalDate.parse("2001-11-02"));

        Assertions.assertEquals("Joao", usuario.getNome());

        usuario = fabrica.incluiEndereco("45665-888", 40, "apto 123");

        Assertions.assertEquals("apto 123", usuario.getEndereco().getComplemento());
    }
}
