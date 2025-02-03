package org.halogen.backend.Service;

import org.halogen.backend.Model.Product;
import org.halogen.backend.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    public void deleteProductById(int id) {
        productRepo.deleteById(id);
    }

    public Product addProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImage(image.getBytes());

        productRepo.save(product);

        return productRepo.findById(product.getId()).orElse(null);
    }

    public Product updateProduct(int id, Product product, MultipartFile image) throws IOException {
        Product productToUpdate = productRepo.findById(id).orElse(null);

        if(productToUpdate != null) {
            productToUpdate.setName(product.getName());
            productToUpdate.setDescription(product.getDescription());
            productToUpdate.setPrice(product.getPrice());
            productToUpdate.setAvailable(product.isAvailable());
            productToUpdate.setQuantity(product.getQuantity());
            productToUpdate.setBrand(product.getBrand());
            productToUpdate.setCategory(product.getCategory());
            productToUpdate.setImageName(image.getOriginalFilename());
            productToUpdate.setImageType(image.getContentType());
            productToUpdate.setImage(image.getBytes());

            productRepo.save(productToUpdate);

            return productRepo.findById(id).orElse(null);
        }

        return null;
    }

    public List<Product> searchByKeyword(String keyword) {
        return productRepo.searchProducts(keyword);
    }
}
