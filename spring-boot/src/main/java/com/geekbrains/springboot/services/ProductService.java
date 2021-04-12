package com.geekbrains.springboot.services;

import com.geekbrains.springboot.model.Product;
import com.geekbrains.springboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> FindAllProduct(){
        return productRepository.getProductList();
    }

    public Optional<Product> findOneById(Long id){
        return productRepository.findOneById(id);
    }

    public void save(Product product){
        productRepository.save(product);
    }

}
