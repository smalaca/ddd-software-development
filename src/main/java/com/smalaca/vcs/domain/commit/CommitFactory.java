package com.smalaca.vcs.domain.commit;

import com.smalaca.vcs.domain.clock.Clock;

import java.util.Date;

public class CommitFactory {
    private final CommitHashFactory commitHashFactory;
    private final Clock clock;

    public CommitFactory(CommitHashFactory commitHashFactory, Clock clock) {
        this.commitHashFactory = commitHashFactory;
        this.clock = clock;
    }

    public Commit createFor(CodeChange codeChange, CommitAuthor commitAuthor, String message) {
        Date date = clock.now();
        CommitHash commitHash = commitHashFactory.buildFrom(codeChange, commitAuthor, date);

        return new Commit(codeChange, commitHash, commitAuthor, date, message);
    }
}
