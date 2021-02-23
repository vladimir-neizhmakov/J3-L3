package com.geekbrains.spring.mvc.Interfaces;

import com.geekbrains.spring.mvc.model.Product;

import java.util.List;

public interface ProductRepositoryInterface {
    List<Product> getProducts();
    void addProduct(Product product);
    void updateProduct(int id, String newtitle, int newcost);
    void deleteProduct(int id);
}
