package com.smalaca.vcs.domain.branch;

public interface BranchRepository {
    void save(Branch branch);

    Branch find(BranchId branchId);
}
