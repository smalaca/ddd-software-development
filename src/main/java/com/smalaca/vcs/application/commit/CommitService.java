package com.smalaca.vcs.application.commit;

import com.smalaca.vcs.domain.branch.Branch;
import com.smalaca.vcs.domain.branch.BranchId;
import com.smalaca.vcs.domain.branch.BranchRepository;
import com.smalaca.vcs.domain.commit.Commit;
import com.smalaca.vcs.domain.commit.CommitHash;
import com.smalaca.vcs.domain.commit.CommitHashFactory;
import com.smalaca.vcs.domain.commit.CommitRepository;
import com.smalaca.vcs.domain.commit.CherryPickService;

public class CommitService {
    private final CommitRepository commitRepository;
    private final BranchRepository branchRepository;
    private final CommitHashFactory commitHashFactory;
    private final CherryPickService cherryPickService;

    public CommitService(
            CommitRepository commitRepository, BranchRepository branchRepository,
            CommitHashFactory commitHashFactory, CherryPickService cherryPickService) {
        this.commitRepository = commitRepository;
        this.branchRepository = branchRepository;
        this.commitHashFactory = commitHashFactory;
        this.cherryPickService = cherryPickService;
    }

    public void cherryPick(String hashCode, String targetId) {
        BranchId branchId = BranchId.aBranchId(targetId);
        CommitHash commitHash = commitHashFactory.from(hashCode);
        Branch branch = branchRepository.find(branchId);
        Commit commit = commitRepository.find(commitHash);

        cherryPickService.process(commit, branch);

        branchRepository.save(branch);
    }
}
