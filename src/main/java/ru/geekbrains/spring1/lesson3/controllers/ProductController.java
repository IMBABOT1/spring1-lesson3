package ru.geekbrains.spring1.lesson3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.geekbrains.spring1.lesson3.Services.ProductService;
import ru.geekbrains.spring1.lesson3.data.Product;

import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String findAll(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products_page";
    }

    @GetMapping("/products/{id}")
    public String findById(@PathVariable Long id, Model model){
        Product p = productService.findProductById(id);
        model.addAttribute("product", p);
        return "product_info_page";
    }
}
