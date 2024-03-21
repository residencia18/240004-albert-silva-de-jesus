package com.swproject.tradein.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = PerfilTipoDeserializer.class)
public enum PerfilTipo {

  ADMIN("1"), FUNCIONARIO("2");

  private final String codigo;

  PerfilTipo(String codigo) {
    this.codigo = codigo;
  }

  public String getCodigo() {
    return codigo;
  }

  @JsonCreator
  public static PerfilTipo fromString(String codigo) {
    for (PerfilTipo perfilTipo : PerfilTipo.values()) {
      if (perfilTipo.codigo.equals(codigo)) {
        return perfilTipo;
      }
    }
    throw new IllegalArgumentException("PerfilTipo inválido: " + codigo);
  }
}
