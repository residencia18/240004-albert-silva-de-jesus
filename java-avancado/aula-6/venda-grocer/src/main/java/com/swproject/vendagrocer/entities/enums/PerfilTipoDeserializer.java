package com.swproject.vendagrocer.entities.enums;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class PerfilTipoDeserializer extends JsonDeserializer<PerfilTipo> {

  @Override
  public PerfilTipo deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException {
    String value = jsonParser.getValueAsString();
    for (PerfilTipo perfilTipo : PerfilTipo.values()) {
      if (perfilTipo.getCodigo().equals(value)) {
        return perfilTipo;
      }
    }
    throw new IllegalArgumentException("PerfilTipo inválido: " + value);
  }
}
