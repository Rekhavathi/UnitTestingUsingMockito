package com.test.springcloud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.springcloud.model.Product;

//ProductRepo is required to perform CRUD operations against the Model Product
public interface ProductRepo extends JpaRepository<Product, Long> {

}
