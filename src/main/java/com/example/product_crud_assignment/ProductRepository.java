package com.example.product_crud_assignment;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();

public ProductRepository() {
    products.add(new Product("1", "Laptop", "Gaming Laptop", 1200.0, 10));
    products.add(new Product("2", "Phone", "Android Phone", 800.0, 20));
    products.add(new Product("3", "Mouse", "Wireless Mouse", 25.0, 50));
}

    // TODO: Implement the method to save a product to the list.
    public Product save(Product product) {
        products.add(product);
        return product;
    }

    // TODO: Implement the method to return all products.
    public List<Product> findAll() {
        return products;
    }

    // TODO: Implement the method to find a product by its ID.
    public Product findById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    // TODO: Implement the method to update a product by its ID.
    public Product update(String id, Product updatedProduct) {
        int index = getProductIndex(id);
        if (index != -1) {
            updatedProduct.setId(id);
            products.set(index, updatedProduct);
            return updatedProduct;
        }
        return null;
    }

    // TODO: Implement the method to delete a product by its ID.
    public void delete(String id) {
        int index = getProductIndex(id);
        if (index != -1) {
          products.remove(index);
        }
    }

    // Helper method to find the index of a product by ID
    private int getProductIndex(String id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}