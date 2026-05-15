package br.com.github.renato28.projetpjavacleanarchitecture.infra.gateways;

import br.com.github.renato28.projetpjavacleanarchitecture.application.gateways.RepositorioDeUsuario;
import br.com.github.renato28.projetpjavacleanarchitecture.domain.entities.usuario.Usuario;
import br.com.github.renato28.projetpjavacleanarchitecture.infra.persistence.UsuarioEntity;
import br.com.github.renato28.projetpjavacleanarchitecture.infra.persistence.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioEntityMapper mapper;

    public RepositorioUsuarioJpa(UsuarioRepository usuarioRepository, UsuarioEntityMapper mapper) {
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        usuarioRepository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
