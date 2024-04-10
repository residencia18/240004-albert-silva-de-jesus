package com.swproject.salescompany.web.dto.form;

import java.util.Set;

import com.swproject.salescompany.entities.Category;
import com.swproject.salescompany.entities.Employee;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
public class ProductForm {

    @NotBlank(message = "O nome não pode ficar em branco")
    @Size(min = 3, max = 30, message = "O nome deve ter entre 3 e 30 caracteres")
    private String name;

    @NotBlank(message = "O descrição não pode ficar em branco")
    @Size(min = 3, max = 30, message = "A descrição deve ter entre 3 e 30 caracteres")
    private String description;

    @Positive(message = "O preço deve ser maior que zero")
    private Double price;
    private String imgUrl;
    // private Set<Category> categories;

    // private Set<Employee> employeesSoldBy;

    // public ProductForm(ProductForm productForm, Employee employee) {
    // this.name = productForm.getName();
    // this.description = productForm.getDescription();
    // this.price = productForm.getPrice();
    // this.imgUrl = productForm.getImgUrl();
    // this.categories = productForm.getCategories();
    // this.employeesSoldBy = productForm.getEmployeesSoldBy();
    // }
}
