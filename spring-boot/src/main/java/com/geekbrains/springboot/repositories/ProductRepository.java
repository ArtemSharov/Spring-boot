package com.geekbrains.springboot.repositories;

import com.geekbrains.springboot.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>(Arrays.asList(
                new Product(1L, "Холодильник", 45000f),
                new Product(2L, "Микроволновка", 25000f),
                new Product(3L, "Телевизор", 67000f),
                new Product(4L, "Компухтер", 8900f)
        ));
    }

    public List<Product> getProductList(){
        return productList;
    }

    public Optional<Product> findOneById(Long id) {
        for (Product p : productList) {
            Long temp = p.getId();
            if (temp.equals(id)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public void save(Product product){
        productList.add(product);
    }
}
