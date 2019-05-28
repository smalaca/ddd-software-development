package com.smalaca.vcs.domain.branch;

import com.smalaca.vcs.domain.branch.BranchId;
import com.smalaca.vcs.domain.commit.CommitHash;

public class CommitAdded {
    private final BranchId branchId;
    private final CommitHash commitHash;

    CommitAdded(BranchId branchId, CommitHash commitHash) {
        this.branchId = branchId;
        this.commitHash = commitHash;
    }

    public BranchId getBranchId() {
        return branchId;
    }

    public CommitHash getCommitHash() {
        return commitHash;
    }
}
