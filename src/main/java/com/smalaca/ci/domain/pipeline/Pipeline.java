package com.smalaca.ci.domain.pipeline;

import com.smalaca.vcs.domain.branch.BranchId;
import com.smalaca.vcs.domain.commit.CommitHash;

public class Pipeline {
    private final BranchId branchId;
    private final CommitHash commitHash;

    Pipeline(BranchId branchId, CommitHash commitHash) {
        this.branchId = branchId;
        this.commitHash = commitHash;
    }

    public void triggerNext() {

    }

    public void start() {

    }
}
