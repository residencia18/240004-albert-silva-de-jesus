package com.swproject.salescompany.web.dto.form;

import java.time.Instant;
import java.util.Date;
import java.util.Set;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.swproject.salescompany.entities.Product;
import com.swproject.salescompany.entities.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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

    @Column(nullable = false)
    private Boolean isActive;

    @Temporal(TemporalType.DATE)
    private Date startDate; // data de início do empregado

    @Column(nullable = false)
    private Integer experienceYears; // anos de experiência

    private Long usuarioId;

    private Usuario usuario;

    private Set<Product> productsSold;

    public EmployeeForm(EmployeeForm employeeForm, Usuario usuario) {
        this.name = employeeForm.getName();
        this.cpf = employeeForm.getCpf();
        this.birthDate = employeeForm.getBirthDate();
        this.isActive = employeeForm.getIsActive();
        this.startDate = employeeForm.getStartDate();
        this.experienceYears = employeeForm.getExperienceYears();
        this.usuario = usuario;
        this.productsSold = employeeForm.getProductsSold();
    }
}
