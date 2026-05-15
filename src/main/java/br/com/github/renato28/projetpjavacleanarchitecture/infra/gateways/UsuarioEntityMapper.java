package br.com.github.renato28.projetpjavacleanarchitecture.infra.gateways;

import br.com.github.renato28.projetpjavacleanarchitecture.domain.entities.usuario.Usuario;
import br.com.github.renato28.projetpjavacleanarchitecture.infra.persistence.UsuarioEntity;

public class UsuarioEntityMapper {

    public UsuarioEntity toEntity(Usuario usuario) {
        return new UsuarioEntity(usuario.getCpf(), usuario.getNome(),
                usuario.getNascimento(), usuario.getEmail());
    }

    public Usuario toDomain(UsuarioEntity usuarioEntity) {
        return new Usuario(usuarioEntity.getCpf(), usuarioEntity.getNome(),
                usuarioEntity.getNascimento(), usuarioEntity.getEmail());
    }
}
