package com.franchise.controller;

import com.franchise.dto.BranchDTO;
import com.franchise.model.Branch;
import com.franchise.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping("/franchise/{franchiseId}")
    public ResponseEntity<Branch> addBranchToFranchise(
            @PathVariable Long franchiseId,
            @RequestBody BranchDTO branchDTO) {
        Branch branch = new Branch();
        branch.setName(branchDTO.getName());
        return ResponseEntity.ok(branchService.addBranchToFranchise(franchiseId, branch));
    }

    @PutMapping("/{id}/name")
    public ResponseEntity<Branch> updateBranchName(
            @PathVariable Long id,
            @RequestBody BranchDTO branchDTO) {
        return ResponseEntity.ok(branchService.updateBranchName(id, branchDTO.getName()));
    }
}
