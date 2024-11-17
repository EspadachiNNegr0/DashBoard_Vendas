package com.shadow.dashboard2.repositors;

import com.shadow.dashboard2.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
    Products findByNameProduct(String nameProduct);
}



