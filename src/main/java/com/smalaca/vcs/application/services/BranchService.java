package com.smalaca.vcs.application.services;

import com.smalaca.vcs.domain.branch.Branch;
import com.smalaca.vcs.domain.branch.BranchId;
import com.smalaca.vcs.domain.branch.BranchRepository;

public class BranchService {
    private final BranchRepository branchRepository;

    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public void create(String sourceBranchId, String branchName) {
        BranchId branchId = BranchId.aBranchId(sourceBranchId);
        Branch branch = branchRepository.find(branchId);

        Branch newBranch = branch.createNew(branchName);

        branchRepository.save(newBranch);
    }
}
