package com.project_service.project_service.web.controller;

import com.project_service.project_service.entity.Usuario;
import com.project_service.project_service.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        Usuario user = usuarioService.salvar(usuario, true);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id) {
        Usuario user = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        List<Usuario> users = usuarioService.buscarTodos();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable Long id, @RequestBody Usuario updatedUsuario) {
        Usuario user = usuarioService.buscarPorId(id);

        if (user != null) {
            user.setFirstName(updatedUsuario.getFirstName());
            user.setLastName(updatedUsuario.getLastName());
            user.setCpf(updatedUsuario.getCpf());
            user.setBirthdate(updatedUsuario.getBirthdate());
            user.setEmail(updatedUsuario.getEmail());
            user.setCep(updatedUsuario.getCep());
            user.setPassword(updatedUsuario.getPassword());
            user.setActive(updatedUsuario.isActive());

            Usuario updatedUser = usuarioService.salvar(user, false);

            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        if (usuarioService.validarCredenciais(usuario.getEmail(), usuario.getPassword())) {
            return ResponseEntity.ok("Login bem-sucedido");
        } else {
            return ResponseEntity.badRequest().body("Credenciais inválidas");
        }
    }

    @PutMapping("/{id}/password")
    public ResponseEntity<String> alterarSenha(@PathVariable Long id, @RequestBody SenhaRequest senhaRequest) {
        try {
            Usuario usuario = usuarioService.buscarPorId(id);

            if (usuario != null) {
                usuario.setPassword(senhaRequest.getPassword());

                usuarioService.salvar(usuario, false);

                return ResponseEntity.ok("Senha alterada com sucesso");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao alterar a senha: " + e.getMessage());
        }
    }
}
