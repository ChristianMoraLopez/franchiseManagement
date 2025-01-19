package com.franchise.service;

import com.franchise.model.Franchise;
import java.util.List;

public interface FranchiseService {
    Franchise createFranchise(Franchise franchise);
    Franchise updateFranchiseName(Long id, String newName);
    Franchise getFranchise(Long id);
    List<Franchise> getAllFranchises();
}
