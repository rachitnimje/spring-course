package org.halogen.backend.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Response;
import org.halogen.backend.Model.Product;
import org.halogen.backend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id){
//        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
        Product product = productService.getProductById(id);

        if(product != null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<HttpStatus> deleteProductById(@PathVariable("id") int id){
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") int id, @RequestPart Product product, @RequestPart MultipartFile image){
        try {
            Product updatedProduct = productService.updateProduct(id, product, image);
            
            if(updatedProduct != null){
                return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile image){
        try {
            Product savedProduct = null;
            savedProduct = productService.addProduct(product, image);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getProductImage(@PathVariable("id") int id){
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product.getImage(), HttpStatus.OK);
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchBykeyword(@RequestParam String keyword){
        List<Product> products = productService.searchByKeyword(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
