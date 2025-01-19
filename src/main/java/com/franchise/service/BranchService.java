package com.franchise.service;

import com.franchise.model.Branch;

public interface BranchService {
    Branch addBranchToFranchise(Long franchiseId, Branch branch);
    Branch updateBranchName(Long id, String newName);
    Branch getBranch(Long id);
}
