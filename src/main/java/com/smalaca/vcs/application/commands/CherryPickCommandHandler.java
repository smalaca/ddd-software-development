package com.smalaca.vcs.application.commands;

import com.smalaca.vcs.domain.branch.Branch;
import com.smalaca.vcs.domain.branch.BranchId;
import com.smalaca.vcs.domain.branch.BranchRepository;
import com.smalaca.vcs.domain.commit.*;

public class CherryPickCommandHandler {
    private final CommitRepository commitRepository;
    private final BranchRepository branchRepository;
    private final CherryPickService cherryPickService;
    private final CommitHashFactory commitHashFactory;

    public CherryPickCommandHandler(
            CommitRepository commitRepository, BranchRepository branchRepository,
            CherryPickService cherryPickService, CommitHashFactory commitHashFactory) {
        this.commitRepository = commitRepository;
        this.branchRepository = branchRepository;
        this.cherryPickService = cherryPickService;
        this.commitHashFactory = commitHashFactory;
    }

    public void handle(CherryPickCommand command) {
        BranchId branchId = BranchId.aBranchId(command.getBranchId());
        CommitHash commitHash = commitHashFactory.from(command.getCommitHash());
        Branch branch = branchRepository.find(branchId);
        Commit commit = commitRepository.find(commitHash);

        cherryPickService.process(commit, branch);

        branchRepository.save(branch);
    }
}
