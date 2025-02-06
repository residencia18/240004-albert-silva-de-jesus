package com.swproject.salescompany.testes;

import com.swproject.salescompany.entities.Category;
import com.swproject.salescompany.entities.Product;

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
