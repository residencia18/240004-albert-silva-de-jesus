package com.persistencia.pratica13.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Usuario extends AbstractEntity{
  
  private String nome;
  private String email;
  private String senha;

}