package ru.geekbrains.spring1.lesson3.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring1.lesson3.data.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    private void init(){
        products = new ArrayList<>(Arrays.asList(
                new Product(1l, "first", 10),
                new Product(2l, "second", 20),
                new Product(3l, "third", 30),
                new Product(4l, "four", 40),
                new Product(5l, "fifth", 50)
        ));
    }

    public List<Product> findAll(){
        return Collections.unmodifiableList(products);
    }

    public Product findProductById(Long id){
        for (Product p : products){
            if (p.getId().equals(id)){
                return p;
            }
        }
        throw new RuntimeException("Product not found " + id);
    }


}
