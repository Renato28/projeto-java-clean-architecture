package br.com.github.renato28.projetpjavacleanarchitecture.config;

import br.com.github.renato28.projetpjavacleanarchitecture.application.gateways.RepositorioDeUsuario;
import br.com.github.renato28.projetpjavacleanarchitecture.application.usecases.CriarUsuario;
import br.com.github.renato28.projetpjavacleanarchitecture.application.usecases.ListaUsuario;
import br.com.github.renato28.projetpjavacleanarchitecture.infra.gateways.RepositorioUsuarioJpa;
import br.com.github.renato28.projetpjavacleanarchitecture.infra.gateways.UsuarioEntityMapper;
import br.com.github.renato28.projetpjavacleanarchitecture.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    CriarUsuario criarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new CriarUsuario(repositorioDeUsuario);
    }

    @Bean
    ListaUsuario listaUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new ListaUsuario(repositorioDeUsuario);
    }

    @Bean
    RepositorioUsuarioJpa criarRepositorioUsuarioJpa(UsuarioRepository repository, UsuarioEntityMapper mapper) {
        return new RepositorioUsuarioJpa(repository, mapper);
    }

    @Bean
    UsuarioEntityMapper retornarMapper() {
        return new UsuarioEntityMapper();
    }
}
