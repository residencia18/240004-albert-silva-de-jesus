package br.com.residenciatic18.avaliacao.api.ap002.service;

import lombok.RequiredArgsConstructor;
import br.com.residenciatic18.avaliacao.api.ap002.entity.Token;
import br.com.residenciatic18.avaliacao.api.ap002.entity.Usuario;
import br.com.residenciatic18.avaliacao.api.ap002.exception.AcessoNegadoException;
import br.com.residenciatic18.avaliacao.api.ap002.exception.EntityNotFoundException;
import br.com.residenciatic18.avaliacao.api.ap002.exception.PasswordInvalidException;
import br.com.residenciatic18.avaliacao.api.ap002.exception.UsernameUniqueViolationException;
import br.com.residenciatic18.avaliacao.api.ap002.repository.UsuarioRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        try {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            return usuarioRepository.save(usuario);

        } catch (org.springframework.dao.DataIntegrityViolationException ex) {
            throw new UsernameUniqueViolationException(
                    String.format("Username: %s já cadastrado: ", usuario.getUsername()));
        }
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuário id=%s não encontrado", id)));
    }

    @Transactional
    public Usuario editarSenha(Long id, String senhaAtual, String novaSenha, String confirmaSenha) {
        if (!novaSenha.equals(confirmaSenha)) {
            throw new PasswordInvalidException("Nova senha não confere com confirmação de senha.");
        }

        Usuario user = buscarPorId(id);
        if (!passwordEncoder.matches(senhaAtual, user.getPassword())) {
            throw new PasswordInvalidException("Sua senha não confere.");
        }

        user.setPassword(passwordEncoder.encode(novaSenha));
        return user;

        // Outra forma de fazer a mesma coisa é:
        // return usuarioRepository.save(user);
    }

    @Transactional(readOnly = false)
    public Usuario alterarSenha(Token token, String novaSenha, String confirmaSenha) {
        if (!novaSenha.equals(confirmaSenha)) {
            throw new PasswordInvalidException("Nova senha não confere com confirmação de senha.");
        }

        Usuario usuario = token.getUsuario();
        usuario.setCodigoVerificador(null);
        usuario.setPassword(passwordEncoder.encode(novaSenha));

        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscaTodos() {
        return usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuário username = %s não encontrado", username)));
    }

    @Transactional(readOnly = true)
    public Usuario.Role buscarRolePorUsername(String username) {
        return usuarioRepository.findRoleByUsername(username);
    }

    @Transactional(readOnly = false)
    public void ativarCadastroUsuario(String codigo) {
        String username = new String(Base64.getDecoder().decode(codigo));
        Usuario usuario = buscarPorUsername(username);

        if (usuario.hasNotId()) {
            throw new AcessoNegadoException("Não foi possível ativar o cadastro. Entre em contato com o suporte.");
        }
        usuario.setAtivo(true);
    }

}