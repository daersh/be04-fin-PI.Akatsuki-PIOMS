package com.akatsuki.pioms.product.repository;

import com.akatsuki.pioms.product.aggregate.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByCategoryThirdCategoryThirdCode(int categoryThirdCode);

    List<Product> findByCategoryThird_CategoryThirdCode(int categoryThirdCode);

    Product findByProductCode(int productCode);
}
