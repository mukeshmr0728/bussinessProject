package com.data.testing.product;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {


    private ProductService productService;
    @GetMapping("/items")
    public ResponseEntity getproducts(){
        return ResponseEntity.ok("Here is your products");
    }
}
