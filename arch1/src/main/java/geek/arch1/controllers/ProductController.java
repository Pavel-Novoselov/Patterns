package geek.arch1.controllers;

import geek.arch1.entities.Product;
import geek.arch1.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<Product> getProductBytId (@RequestParam(name = "id") final long id){
        if (id < 1){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        final Product product = productService.getById(id);
        if (product == null){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping("")
    public ResponseEntity<Product> saveProduct(@RequestBody final Product product){
        if (product == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        final Product savedProduct = productService.save(product);
        if (savedProduct == null){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(savedProduct);
    }
}
