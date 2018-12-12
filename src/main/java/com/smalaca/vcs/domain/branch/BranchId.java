package com.smalaca.vcs.domain.branch;

public class BranchId {
    private final String identifier;

    private BranchId(String identifier) {
        this.identifier = identifier;
    }

    public static BranchId aBranchId(String branchId) {
        return new BranchId(branchId);
    }
}
