package com.franchise.controller;

import com.franchise.dto.FranchiseDTO;
import com.franchise.model.Franchise;
import com.franchise.service.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/franchises")
public class FranchiseController {

    @Autowired
    private FranchiseService franchiseService;

    @PostMapping
    public ResponseEntity<Franchise> createFranchise(@RequestBody FranchiseDTO franchiseDTO) {
        Franchise franchise = new Franchise();
        franchise.setName(franchiseDTO.getName());
        return ResponseEntity.ok(franchiseService.createFranchise(franchise));
    }

    @PutMapping("/{id}/name")
    public ResponseEntity<Franchise> updateFranchiseName(
            @PathVariable Long id,
            @RequestBody FranchiseDTO franchiseDTO) {
        return ResponseEntity.ok(franchiseService.updateFranchiseName(id, franchiseDTO.getName()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Franchise> getFranchise(@PathVariable Long id) {
        return ResponseEntity.ok(franchiseService.getFranchise(id));
    }
}
