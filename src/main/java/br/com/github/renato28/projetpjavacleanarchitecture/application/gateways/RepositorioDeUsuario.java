package br.com.github.renato28.projetpjavacleanarchitecture.application.gateways;

import br.com.github.renato28.projetpjavacleanarchitecture.domain.entities.usuario.Usuario;

import java.util.List;

public interface RepositorioDeUsuario {
    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarUsuarios();
}
