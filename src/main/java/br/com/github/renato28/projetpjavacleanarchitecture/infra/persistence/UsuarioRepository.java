package br.com.github.renato28.projetpjavacleanarchitecture.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
