package com.geekbrains.spring.mvc.controllers;

import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// root: http://localhost:8189/app/students

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showAllProducts(Model model) {
        List<Product> products = productService.getProductRepository().getProducts();
        model.addAttribute("products", products);
        model.addAttribute("avgCost", productService.productAverageCost());
        model.addAttribute("count", productService.productCount());
        return "all_products";}

    @PostMapping("/add")
    public String addNewProduct(@ModelAttribute Product product) {
        productService.getProductRepository().addProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/remove/{id}")
    public String deleteProductById(@PathVariable int id) {
        productService.getProductRepository().deleteProduct(productService.getProductRepository().getListID(id));
        return "redirect:/products";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable int id, @ModelAttribute Product product) {
        System.out.println(id + product.getTitle()+product.getCost());
     //   productService.getProductRepository().addProduct(product);
        return "redirect:/products";
    }
}
