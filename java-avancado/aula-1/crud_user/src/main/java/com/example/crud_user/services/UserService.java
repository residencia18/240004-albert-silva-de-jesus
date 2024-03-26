package com.example.crud_user.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crud_user.entities.User;
import com.example.crud_user.repositories.UserRepository;
import com.example.crud_user.web.dto.UserResponseDto;
import com.example.crud_user.web.dto.form.UserForm;
import com.example.crud_user.web.dto.mapper.UserMapper;

@Service
@Transactional(readOnly = false)
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User save(@Nullable User user) {

    if (user == null) {
      throw new IllegalArgumentException("O parâmetro 'user' não pode ser nulo.");
    }

    return userRepository.save(user);
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User searchById(@NonNull Long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Id Inválido para o leilao:" + id));
  }

  @Transactional(readOnly = true)
  public List<UserResponseDto> findById(Long id) {

    if (id == null) {
      return UserMapper.toListDto(findAll());

    } else {

      User user = searchById(id);
      if (user != null) {
        return UserMapper.toListDto(Collections.singletonList(user));

      } else {
        return Collections.emptyList();
      }
    }
  }

  public User update(@NonNull Long id, UserForm userForm) {
    User obj = searchById(id);
    obj.setName(userForm.getName());
    obj.setEmail(userForm.getEmail());
    obj.setCpf(userForm.getCpf());
    return userRepository.save(obj);
  }

  @Transactional
  public User editarSenha(@NonNull Long id, String senhaAtual, String novaSenha, String confirmaSenha) {
    if (!novaSenha.equals(confirmaSenha)) {
      throw new RuntimeException("Nova senha e confirmação de senha não conferem");
    }
    User user = searchById(id);
    if (!user.getPassword().equals(senhaAtual)) {
      throw new RuntimeException("Senha atual inválida");
    }
    user.setPassword(novaSenha);
    return user;

    // Outra forma de fazer a mesma coisa é:
    // return usuarioRepository.save(user);
  }

  public void delete(@NonNull Long id) {
    userRepository.deleteById(id);
  }

  public Boolean isExisteId(@NonNull Long id) {
    if (userRepository.existsById(id)) {
      return true;
    } else {
      return false;
    }
  }
}
