package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    private final Map<Long, Product> products = new LinkedHashMap<>();
    private long nextId = 1;

    // Danh sách danh mục cố định
    private final List<String> categories = List.of("Điện thoại", "Laptop");

    public ProductService() {
        // Dữ liệu mẫu
        addProduct(new Product(null, "iPhone 15 Pro Max", 2999000.0, "iphone15.jpg", "Điện thoại"));
        addProduct(new Product(null, "Samsung Galaxy S24", 2299000.0, "samsung-s24.jpg", "Điện thoại"));
        addProduct(new Product(null, "MacBook Pro M3", 4999000.0, "macbook-m3.jpg", "Laptop"));
        addProduct(new Product(null, "Dell XPS 15", 3599000.0, "dell-xps15.jpg", "Laptop"));
        addProduct(new Product(null, "Xiaomi 14", 1299000.0, "xiaomi14.jpg", "Điện thoại"));
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    public Product getProductById(Long id) {
        return products.get(id);
    }

    public Product addProduct(Product product) {
        product.setId(nextId);
        products.put(nextId, product);
        nextId++;
        return product;
    }

    public Product updateProduct(Long id, Product product) {
        Product existing = products.get(id);
        if (existing != null) {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            existing.setCategory(product.getCategory());
            // Chỉ cập nhật hình ảnh nếu có upload mới
            if (product.getImage() != null && !product.getImage().isEmpty()) {
                existing.setImage(product.getImage());
            }
        }
        return existing;
    }

    public boolean deleteProduct(Long id) {
        return products.remove(id) != null;
    }
}
