package com.swproject.supersale.web.dto.form;

import java.time.Instant;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeForm {

    @NotBlank
    @Size(min = 6, max = 6)
    private String name;

    @CPF(message = "CPF inválido")
    @NotBlank(message = "O CPF não pode estar em branco")
    @Size(min = 11, max = 11, message = "O CPF deve ter exatamente 11 caracteres")
    @Column(unique = true)
    private String cpf;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant birthDate;
}
