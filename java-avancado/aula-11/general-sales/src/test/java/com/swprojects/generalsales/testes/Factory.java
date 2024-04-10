package com.swprojects.generalsales.testes;

import com.swprojects.generalsales.entities.Category;
import com.swprojects.generalsales.entities.Product;

public class Factory {

  public static Product create() {
    Product product = new Product(1L, "Phone", "Good phone", 800.0, "http://img.com/img.png");
    product.getCategories().add(new Category(1L, "Electronics"));
    return product;
  }

  public static Product createProduct() {
    Product product = createProduct();
    return new Product(product, product.getCategories());
  }
}
