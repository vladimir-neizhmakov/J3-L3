package com.geekbrains.spring.mvc.services;

import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.repositories.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){this.productRepository = productRepository;}

    public int productCount(){
        return productRepository.getProducts().size();

    }

    public double productAverageCost(){
        double avg=0;
        for (Product p : productRepository.getProducts()) {
            avg += p.getCost();
        }
        avg /= productRepository.getProducts().size();
        return avg;
    }
}
