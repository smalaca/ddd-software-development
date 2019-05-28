package com.smalaca.vcs.application.commit.cherrypick;

import com.smalaca.vcs.rest.command.Command;

public class CherryPickCommand implements Command {
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

