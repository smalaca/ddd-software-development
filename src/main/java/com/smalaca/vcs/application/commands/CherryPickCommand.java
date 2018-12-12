package com.smalaca.vcs.application.commands;

import com.smalaca.vcs.domain.branch.BranchId;
import com.smalaca.vcs.domain.commit.CommitHash;

public class CherryPickCommand {
    private final CommitHash commitHash;
    private final BranchId branchId;

    CherryPickCommand(CommitHash commitHash, BranchId branchId) {
        this.commitHash = commitHash;
        this.branchId = branchId;
    }

    BranchId getBranchId() {
        return branchId;
    }

    CommitHash getCommitHash() {
        return commitHash;
    }
}

