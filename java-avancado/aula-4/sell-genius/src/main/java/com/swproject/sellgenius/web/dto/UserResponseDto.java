package com.swproject.sellgenius.web.dto;

import java.util.List;

import com.swproject.sellgenius.entities.AbstractEntity;
import com.swproject.sellgenius.entities.Perfil;
import com.swproject.sellgenius.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponseDto extends AbstractEntity {

  private Long id;
  private String username;
  private List<Perfil> perfis;

  public UserResponseDto(User user) {
    setId(user.getId());
    this.username = user.getUsername();
  }

  public List<Perfil> getPerfis() {
    return perfis;
  }

  public void setPerfis(List<Perfil> perfis) {
    this.perfis = perfis;
  }

}
