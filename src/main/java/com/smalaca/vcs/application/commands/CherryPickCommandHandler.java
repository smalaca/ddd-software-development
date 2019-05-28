package com.smalaca.vcs.application.commands;

import com.smalaca.vcs.domain.branch.Branch;
import com.smalaca.vcs.domain.branch.BranchRepository;
import com.smalaca.vcs.domain.commit.Commit;
import com.smalaca.vcs.domain.commit.CommitRepository;
import com.smalaca.vcs.domain.commit.CherryPickService;

public class CherryPickCommandHandler {
    private final CommitRepository commitRepository;
    private final BranchRepository branchRepository;
    private final CherryPickService cherryPickService;

    public CherryPickCommandHandler(
            CommitRepository commitRepository, BranchRepository branchRepository, CherryPickService cherryPickService) {
        this.commitRepository = commitRepository;
        this.branchRepository = branchRepository;
        this.cherryPickService = cherryPickService;
    }

    public void handle(CherryPickCommand command) {
        Branch branch = branchRepository.find(command.getBranchId());
        Commit commit = commitRepository.find(command.getCommitHash());

        cherryPickService.process(commit, branch);

        branchRepository.save(branch);
    }
}
