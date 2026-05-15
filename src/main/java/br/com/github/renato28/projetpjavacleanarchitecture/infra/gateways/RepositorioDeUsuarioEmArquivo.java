package br.com.github.renato28.projetpjavacleanarchitecture.infra.gateways;

import br.com.github.renato28.projetpjavacleanarchitecture.application.gateways.RepositorioDeUsuario;
import br.com.github.renato28.projetpjavacleanarchitecture.domain.entities.usuario.Usuario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeUsuarioEmArquivo implements RepositorioDeUsuario {

    List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        return usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void gravarEmArquivo(String nomeArquivo) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(nomeArquivo);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao criar o arquivo: " + e.getMessage());
        }
        try {
            fileWriter.write(this.usuarios.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao criar o arquivo: " + e.getMessage());
        }
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return List.of();
    }
}
