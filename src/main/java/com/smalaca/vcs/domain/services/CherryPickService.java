package com.smalaca.vcs.domain.services;

import com.smalaca.vcs.domain.branch.Branch;
import com.smalaca.vcs.domain.commit.Commit;

public class CherryPickService {
    public void process(Commit commit, Branch target) {
        Commit cherryPick = commit.cherryPick();

        target.add(cherryPick);
    }
}
