package com.project_service.project_service.service;

import com.project_service.project_service.entity.Usuario;
import com.project_service.project_service.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        validarTamanhoNomes(usuario.getFirstName(), usuario.getLastName());
        validarFormatoEmail(usuario.getEmail());
        validarEmailUnico(usuario.getEmail());
        validarFormatoCpf(usuario.getCpf());
        validarCpfUnico(usuario.getCpf());
        validarTamanhoSenha(usuario.getPassword());

        // Criptografar senha antes de salvar
        //usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        return usuarioRepository.save(usuario);
    }

    // Métodos de validação

    private void validarTamanhoNomes(String firstName, String lastName) {
        if (firstName.length() < 3 || lastName.length() < 3) {
            throw new RuntimeException("Os campos firstName e lastName devem ter no mínimo 3 caracteres.");
        }
    }

    private void validarFormatoEmail(String email) {
        if (!email.matches(".+@.+\\..+")) {
            throw new RuntimeException("Formato de email inválido.");
        }
    }

    private void validarEmailUnico(String email) {
        if (usuarioRepository.existsByEmail(email)) {
            throw new RuntimeException("Email já cadastrado.");
        }
    }

    private void validarFormatoCpf(String cpf) {
        if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new RuntimeException("Formato de CPF inválido.");
        }
    }

    private void validarCpfUnico(String cpf) {
        if (usuarioRepository.existsByCpf(cpf)) {
            throw new RuntimeException("CPF já cadastrado.");
        }
    }

    private void validarTamanhoSenha(String password) {
        if (password.length() < 6) {
            throw new RuntimeException("A senha deve ter no mínimo 6 caracteres.");
        }
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado.")
        );
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }
}
