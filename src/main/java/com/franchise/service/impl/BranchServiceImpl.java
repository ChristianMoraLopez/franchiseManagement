package com.franchise.service.impl;

import com.franchise.model.Branch;
import com.franchise.model.Franchise;
import com.franchise.repository.BranchRepository;
import com.franchise.repository.FranchiseRepository;
import com.franchise.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BranchServiceImpl implements BranchService {
    
    @Autowired
    private BranchRepository branchRepository;
    
    @Autowired
    private FranchiseRepository franchiseRepository;

    @Override
    @Transactional
    public Branch addBranchToFranchise(Long franchiseId, Branch branch) {
        Franchise franchise = franchiseRepository.findById(franchiseId)
            .orElseThrow(() -> new RuntimeException("Franchise not found"));
        branch.setFranchise(franchise);
        return branchRepository.save(branch);
    }

    @Override
    @Transactional
    public Branch updateBranchName(Long id, String newName) {
        Branch branch = branchRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Branch not found"));
        branch.setName(newName);
        return branchRepository.save(branch);
    }

    @Override
    public Branch getBranch(Long id) {
        return branchRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Branch not found"));
    }
}
