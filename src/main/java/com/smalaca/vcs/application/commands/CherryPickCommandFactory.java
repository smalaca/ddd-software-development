package com.smalaca.vcs.application.commands;

import com.smalaca.vcs.domain.branch.BranchId;
import com.smalaca.vcs.domain.commit.CommitHashFactory;

public class CherryPickCommandFactory {
    private final CommitHashFactory commitHashFactory;

    public CherryPickCommandFactory(CommitHashFactory commitHashFactory) {
        this.commitHashFactory = commitHashFactory;
    }

    public CherryPickCommand createFor(String hashCode, String targetId) {
        return new CherryPickCommand(
                commitHashFactory.from(hashCode),
                BranchId.aBranchId(targetId));
    }
}
