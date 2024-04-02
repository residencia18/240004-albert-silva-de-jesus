package com.swproject.buyeverything.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swproject.buyeverything.entities.Usuario;
import com.swproject.buyeverything.exception.EntityNotFoundException;
import com.swproject.buyeverything.exception.PasswordInvalidException;
import com.swproject.buyeverything.exception.UsernameUniqueViolationException;
import com.swproject.buyeverything.repositories.UsuarioRepository;
import com.swproject.buyeverything.web.dto.form.UsuarioForm;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class UsuarioService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Transactional
  public Usuario save(@Nullable Usuario usuario) {
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

  public void delete(@NonNull Long id) {
    usuarioRepository.deleteById(id);
  }

  public Boolean isExisteId(@NonNull Long id) {
    if (usuarioRepository.existsById(id)) {
      return true;
    } else {
      return false;
    }
  }
}
