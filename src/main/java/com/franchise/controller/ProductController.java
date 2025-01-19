package com.franchise.controller;

import com.franchise.dto.ProductDTO;
import com.franchise.model.Product;
import com.franchise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/branch/{branchId}")
    public ResponseEntity<Product> addProductToBranch(
            @PathVariable Long branchId,
            @RequestBody ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setStock(productDTO.getStock());
        return ResponseEntity.ok(productService.addProductToBranch(branchId, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<Product> updateProductStock(
            @PathVariable Long id,
            @RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.updateProductStock(id, productDTO.getStock()));
    }

    @PutMapping("/{id}/name")
    public ResponseEntity<Product> updateProductName(
            @PathVariable Long id,
            @RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.updateProductName(id, productDTO.getName()));
    }

    @GetMapping("/franchise/{franchiseId}/highest-stock")
    public ResponseEntity<List<Product>> getProductsWithHighestStock(@PathVariable Long franchiseId) {
        return ResponseEntity.ok(productService.getProductsWithHighestStockByFranchise(franchiseId));
    }
}
