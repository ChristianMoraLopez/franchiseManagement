package com.franchise.service;

import com.franchise.model.Product;
import java.util.List;

public interface ProductService {
    Product addProductToBranch(Long branchId, Product product);
    void deleteProduct(Long productId);
    Product updateProductStock(Long productId, Integer newStock);
    Product updateProductName(Long productId, String newName);
    List<Product> getProductsWithHighestStockByFranchise(Long franchiseId);
}
