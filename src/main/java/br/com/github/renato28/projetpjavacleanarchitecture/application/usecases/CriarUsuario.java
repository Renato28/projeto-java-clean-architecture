package br.com.github.renato28.projetpjavacleanarchitecture.application.usecases;

import br.com.github.renato28.projetpjavacleanarchitecture.application.gateways.RepositorioDeUsuario;
import br.com.github.renato28.projetpjavacleanarchitecture.domain.entities.usuario.Usuario;

public class CriarUsuario {
    private final RepositorioDeUsuario repositorio;

    public CriarUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario cadastroUsuario(Usuario usuario) {
        return repositorio.cadastrarUsuario(usuario);
    }
}
