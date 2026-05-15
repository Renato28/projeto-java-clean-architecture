package br.com.github.renato28.projetpjavacleanarchitecture.infra.controller;

import br.com.github.renato28.projetpjavacleanarchitecture.application.usecases.CriarUsuario;
import br.com.github.renato28.projetpjavacleanarchitecture.application.usecases.ListaUsuario;
import br.com.github.renato28.projetpjavacleanarchitecture.domain.entities.usuario.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuario criarUsuario;
    private final ListaUsuario listaUsuario;


    public UsuarioController(CriarUsuario criarUsuario, ListaUsuario listaUsuario) {
        this.criarUsuario = criarUsuario;
        this.listaUsuario = listaUsuario;
    }

    @PostMapping
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto usuarioDto) {
        Usuario usuarioSalvo = criarUsuario.cadastroUsuario(new Usuario(usuarioDto.cpf(), usuarioDto.nome(),
                usuarioDto.nascimento(), usuarioDto.email()));
        return new UsuarioDto(usuarioSalvo.getCpf(), usuarioSalvo.getNome(),
                usuarioSalvo.getNascimento(), usuarioSalvo.getEmail());
    }

    @GetMapping
    public List<UsuarioDto> listarUsuario() {
        return listaUsuario.listarUsuarios().stream()
                .map(u -> new UsuarioDto(u.getCpf(),
                        u.getNome(), u.getNascimento(), u.getEmail()))
                .collect(Collectors.toList());
    }
}
