package com.swprojects.parkapi.service;

import com.swprojects.parkapi.entity.Usuario;
import com.swprojects.parkapi.exception.AcessoNegadoException;
import com.swprojects.parkapi.exception.EntityNotFoundException;
import com.swprojects.parkapi.exception.PasswordInvalidException;
import com.swprojects.parkapi.exception.UsernameUniqueViolationException;
import com.swprojects.parkapi.jwt.JwtToken;
import com.swprojects.parkapi.jwt.JwtUserDetailsService;
import com.swprojects.parkapi.jwt.JwtUtils;
import com.swprojects.parkapi.repository.UsuarioRepository;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    // private final JwtUserDetailsService detailsService;
    // private final AuthenticationManager authenticationManager;

    @Autowired
    private EmailService emailService;

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

    public void emailDeConfirmacaoDeCadastro(String username) throws MessagingException {
        String codigo = Base64.getEncoder().encodeToString(username.getBytes());
        emailService.enviarPedidoDeConfirmacaoDeCadastro(username, codigo);
    }

    @Transactional(readOnly = false)
    public void ativarCadastroUsuario(String codigo) {
        String username = new String(Base64.getDecoder().decode(codigo));
        Usuario usuario = buscarPorUsername(username);

        if (usuario.hasNotId()) {
            throw new AcessoNegadoException("Não foi possível ativar o cadastro.Entre em contato com o suporte.");
        }
        usuario.setAtivo(true);
    }

    @Transactional(readOnly = false)
    public void pedidoRedefinicaoDeSenha(String username) throws MessagingException {
        Usuario usuario = buscarPorUsername(username);

        String verificador = RandomStringUtils.randomAlphanumeric(6);

        usuario.setCodigoVerificador(verificador);

        // String role = usuario.getRole().name().substring("ROLE_".length());

        // usuario.setCodigoVerificador(JwtUtils.createToken(username, role).toString());

        // String verificador = usuario.getCodigoVerificador();

        emailService.enviarPedidoRedefinicaoSenha(username, verificador);

    }
}