package com.smalaca.vcs.application.commit.cherrypick;

public class CherryPickCommand {
    private final String commitHash;
    private final String branchId;

    public CherryPickCommand(String commitHash, String branchId) {
        this.commitHash = commitHash;
        this.branchId = branchId;
    }

    String getBranchId() {
        return branchId;
    }

    String getCommitHash() {
        return commitHash;
    }
}

