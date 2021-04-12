package com.geekbrains.springboot.controllers;

import com.geekbrains.springboot.model.Product;
import com.geekbrains.springboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/all")
    public String showAllProductsPage(Model model){
        List<Product> products = productService.FindAllProduct();
        model.addAttribute("products", products);
        return "products";
    }
    @GetMapping("/create")
    public String showCreator() {
        return "create_product_form";
    }

    @PostMapping("/create")
    public String createNewStudent(@RequestParam Long id, @RequestParam String title, @RequestParam Float coast) {
        Product product = new Product(id, title, coast);
        productService.save(product);
        return "redirect:/products/all";
    }
}
