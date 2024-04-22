package com.swprojects.ithaseverything.services;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.swprojects.ithaseverything.entities.Usuario;
import com.swprojects.ithaseverything.exception.DatabaseException;
import com.swprojects.ithaseverything.exception.EntityNotFoundException;
import com.swprojects.ithaseverything.exception.PasswordInvalidException;
import com.swprojects.ithaseverything.exception.UsernameUniqueViolationException;
import com.swprojects.ithaseverything.repositories.UsuarioRepository;
import com.swprojects.ithaseverything.web.dto.form.UsuarioForm;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class UsuarioService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Transactional
  public Usuario create(@Nullable Usuario usuario) {
    if (usuario == null) {
      throw new IllegalArgumentException("O parâmetro 'usuário' não pode ser nulo.");
    }

    try {
      return usuarioRepository.save(usuario);

    } catch (org.springframework.dao.DataIntegrityViolationException ex) {
      throw new UsernameUniqueViolationException(String.format("Username: %s já cadastrado: ", usuario.getUsername()));
    }
  }

  @Transactional(readOnly = true)
  public Usuario findById(@NonNull Long id) {
    return usuarioRepository.findById(id).orElseThrow(
        () -> new EntityNotFoundException(String.format("Usuário id=%s não encontrado", id)));
  }

  // Metodo criado para atender ao teste automatizado porque o metodo findById nao
  // retorna um Optional e sim um Usuario
  @Transactional(readOnly = true)
  public Optional<Usuario> searchbyId(@NonNull Long id) {
    return Optional.ofNullable(usuarioRepository.findById(id).orElseThrow(
        () -> new EntityNotFoundException(String.format("Usuário id=%s não encontrado", id))));
  }

  @Transactional
  public Usuario editarSenha(@NonNull Long id, String senhaAtual, String novaSenha, String confirmaSenha) {
    if (!novaSenha.equals(confirmaSenha)) {
      throw new PasswordInvalidException("Nova senha não confere com confirmação de senha.");
    }

    Usuario user = findById(id);
    if (!user.getPassword().equals(senhaAtual)) {
      throw new PasswordInvalidException("Sua senha não confere.");
    }

    user.setPassword(novaSenha);
    return user;

    // Outra forma de fazer a mesma coisa é:
    // return usuarioRepository.save(user);
  }

  @Transactional(readOnly = true)
  public List<Usuario> findAll() {
    return usuarioRepository.findAll();
  }

  public Usuario update(@NonNull Long id, UsuarioForm userForm) {
    Usuario obj = findById(id);
    obj.setUsername(userForm.getUsername());
    return usuarioRepository.save(obj);
  }

  // Metodo criado para atender ao teste automatizado porque o metodo findById nao
  // retorna um Optional e sim um Usuario
  public Optional<Usuario> toEdit(@NonNull Long id, UsuarioForm userForm) {
    return searchbyId(id).map(usuario -> {
      usuario.setUsername(userForm.getUsername());
      usuario.setPassword(userForm.getPassword());
      return usuarioRepository.save(usuario);
    });
  }

  public void delete(@NonNull Long id) {
    if (isExisteId(id)) {
      usuarioRepository.deleteById(id);
    } else {
      throw new EntityNotFoundException(String.format("Usuário id=%s não encontrado", id));
    }
    throw new DatabaseException("Integrity violation");
  }

  public Boolean isExisteId(@NonNull Long id) {
    if (usuarioRepository.existsById(id)) {
      return true;
    } else {
      return false;
    }
  }
}
