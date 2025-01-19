package com.franchise.service.impl;

import com.franchise.model.Franchise;
import com.franchise.repository.FranchiseRepository;
import com.franchise.service.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class FranchiseServiceImpl implements FranchiseService {
    
    @Autowired
    private FranchiseRepository franchiseRepository;

    @Override
    @Transactional
    public Franchise createFranchise(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    @Override
    @Transactional
    public Franchise updateFranchiseName(Long id, String newName) {
        Franchise franchise = franchiseRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Franchise not found"));
        franchise.setName(newName);
        return franchiseRepository.save(franchise);
    }

    @Override
    public Franchise getFranchise(Long id) {
        return franchiseRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Franchise not found"));
    }

    @Override
    public List<Franchise> getAllFranchises() {
        return franchiseRepository.findAll();
    }
}
