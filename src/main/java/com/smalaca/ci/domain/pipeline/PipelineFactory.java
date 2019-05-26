package com.smalaca.ci.domain.pipeline;

import com.smalaca.vcs.domain.branch.BranchId;
import com.smalaca.vcs.domain.commit.CommitHash;

public class PipelineFactory {
    public Pipeline create(BranchId branchId, CommitHash commitHash) {
        return new Pipeline(branchId, commitHash);
    }
}
