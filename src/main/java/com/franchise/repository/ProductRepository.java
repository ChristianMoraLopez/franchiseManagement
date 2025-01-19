package com.franchise.repository;

import com.franchise.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.branch.franchise.id = :franchiseId ORDER BY p.stock DESC")
    List<Product> findProductsWithHighestStockByFranchise(@Param("franchiseId") Long franchiseId);
}
