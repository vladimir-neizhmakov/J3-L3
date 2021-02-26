package com.geekbrains.spring.mvc.services;

import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    //public ProductRepository getProductRepository() {
   //     return productRepository;
  //  }

    private ProductRepository productRepository;

    @Autowired
    public void SetProductRepository(ProductRepository productRepository){this.productRepository = productRepository;}

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public void addProduct(Product product) {productRepository.addProduct(product);}

    public void updateProduct(int id, String newtitle, int newcost) {
        productRepository.updateProduct(id,newtitle,newcost);
    }

    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }

    public int getListID(int productID){
        return productRepository.getListID(productID);
    }

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
