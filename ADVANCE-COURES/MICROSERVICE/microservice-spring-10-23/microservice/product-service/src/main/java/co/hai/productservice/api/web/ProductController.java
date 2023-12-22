package co.hai.productservice.api.web;

import co.hai.productservice.api.Product;
import co.hai.productservice.api.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductRepository productRepository;
    @PostMapping()
    public ResponseEntity<Product> create(@RequestBody Product product){
        productRepository.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = productRepository.findAll();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
}
