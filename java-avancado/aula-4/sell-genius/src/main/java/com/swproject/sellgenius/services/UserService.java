package com.swproject.sellgenius.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swproject.sellgenius.entities.User;
import com.swproject.sellgenius.repositories.UserRepository;
import com.swproject.sellgenius.web.dto.UserResponseDto;
import com.swproject.sellgenius.web.dto.form.UserForm;
import com.swproject.sellgenius.web.dto.mapper.UserMapper;

@Service
@Transactional(readOnly = false)
public class UserService {

  @Autowired
  private UserRepository  userRepository;

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
    obj.setUsername(userForm.getUsername());
    return userRepository.save(obj);
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
