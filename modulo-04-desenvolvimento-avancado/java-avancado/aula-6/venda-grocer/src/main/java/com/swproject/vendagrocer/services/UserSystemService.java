package com.swproject.vendagrocer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swproject.vendagrocer.entities.UserSystem;
import com.swproject.vendagrocer.exception.EntityNotFoundException;
import com.swproject.vendagrocer.exception.PasswordInvalidException;
import com.swproject.vendagrocer.exception.UsernameUniqueViolationException;
import com.swproject.vendagrocer.repositories.UserSystemRepository;
import com.swproject.vendagrocer.web.dto.form.UserSystemForm;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class UserSystemService {

  @Autowired
  private UserSystemRepository usuarioRepository;

  @Transactional
  public UserSystem save(@Nullable UserSystem usuario) {
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
  public UserSystem findById(@NonNull Long id) {
    return usuarioRepository.findById(id).orElseThrow(
        () -> new EntityNotFoundException(String.format("Usuário id=%s não encontrado", id)));
  }

  @Transactional
  public UserSystem editarSenha(@NonNull Long id, String senhaAtual, String novaSenha, String confirmaSenha) {
    if (!novaSenha.equals(confirmaSenha)) {
      throw new PasswordInvalidException("Nova senha não confere com confirmação de senha.");
    }

    UserSystem user = findById(id);
    if (!user.getPassword().equals(senhaAtual)) {
      throw new PasswordInvalidException("Sua senha não confere.");
    }

    user.setPassword(novaSenha);
    return user;

    // Outra forma de fazer a mesma coisa é:
    // return usuarioRepository.save(user);
  }

  @Transactional(readOnly = true)
  public List<UserSystem> findAll() {
    return usuarioRepository.findAll();
  }

  public UserSystem update(@NonNull Long id, UserSystemForm userForm) {
    UserSystem obj = findById(id);
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
