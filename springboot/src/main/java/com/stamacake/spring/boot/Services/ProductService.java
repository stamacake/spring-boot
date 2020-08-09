package com.stamacake.spring.boot.Services;

import com.stamacake.spring.boot.entities.Product;
import com.stamacake.spring.boot.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product find(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Нет продуктов с id = " + id));
    }

    public void delete(long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public long getProductCount() {
        return productRepository.count();
    }

    public List<Product> getProductWithMaxPriceFiltering(Integer maxPrice) {
        List<Product> products = this.getAll();
        if (maxPrice == null) {
            return products;
        }
        products.removeIf(p -> p.getPrice() > maxPrice);
        return products;
    }


}
