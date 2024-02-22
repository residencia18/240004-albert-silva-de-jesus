package com.persistencia.pratica13.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.persistencia.pratica13.entities.Usuario;
import com.persistencia.pratica13.repositories.UsuarioRepository;

@Service
@Transactional(readOnly = false)
public class UsuarioServiceImpl implements UsuarioService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @SuppressWarnings("null")
  @Override
  @Transactional
  public Usuario salvar(Usuario usuario) {
    return usuarioRepository.save(usuario);
  }

  @Override
  @Transactional(readOnly = true)
  public List<Usuario> buscarTodos() {
    return usuarioRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Usuario buscarPorId(Long id) {
    return usuarioRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Id Inválido para condutor:" + id));
  }

  @Transactional
  public Usuario editarSenha(Long id, String senhaAtual, String novaSenha, String confirmaSenha) {

    if (!novaSenha.equals(confirmaSenha)) {
      throw new RuntimeException("Nova senha e confirmação de senha não conferem");
    }
    Usuario user = buscarPorId(id);
    if (!user.getSenha().equals(senhaAtual)) {
      throw new RuntimeException("Senha atual inválida");
    }
    user.setSenha(novaSenha);
    return user;

    // Outra forma de fazer a mesma coisa é:
    // return usuarioRepository.save(user);
  }

  @Override
  public void editar(Long id) {
    throw new UnsupportedOperationException("Unimplemented method 'editar'");
  }

  @Override
  public void excluir(Long id) {
    usuarioRepository.deleteById(id);
  }

  @Override
  public Usuario toUsuario() {
    Usuario usuario = new Usuario();
    usuario.setNome("Paulo Henrique da Silva");
    usuario.setEmail("paulo@gmail.com");
    usuario.setSenha("12345678");
    return usuario;
  }

}