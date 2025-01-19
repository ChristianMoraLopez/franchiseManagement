package com.franchise.service.impl;

import com.franchise.model.Branch;
import com.franchise.model.Product;
import com.franchise.repository.BranchRepository;
import com.franchise.repository.ProductRepository;
import com.franchise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private BranchRepository branchRepository;

    @Override
    @Transactional
    public Product addProductToBranch(Long branchId, Product product) {
        Branch branch = branchRepository.findById(branchId)
            .orElseThrow(() -> new RuntimeException("Branch not found"));
        product.setBranch(branch);
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    @Transactional
    public Product updateProductStock(Long productId, Integer newStock) {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setStock(newStock);
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product updateProductName(Long productId, String newName) {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(newName);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProductsWithHighestStockByFranchise(Long franchiseId) {
        return productRepository.findProductsWithHighestStockByFranchise(franchiseId);
    }
}
