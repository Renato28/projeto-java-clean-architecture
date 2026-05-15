package br.com.github.renato28.projetpjavacleanarchitecture.application.usecases;

import br.com.github.renato28.projetpjavacleanarchitecture.application.gateways.RepositorioDeUsuario;
import br.com.github.renato28.projetpjavacleanarchitecture.domain.entities.usuario.Usuario;

import java.util.List;

public class ListaUsuario {
    private final RepositorioDeUsuario repositorio;

    public ListaUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public List<Usuario> listarUsuarios() {
        return repositorio.listarUsuarios();
    }
}
