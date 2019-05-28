package com.smalaca.vcs.domain.commit;

import java.util.Date;

public class Commit {
    private final CodeChange codeChange;
    private final CommitHash commitHash;
    private final CommitAuthor commitAuthor;
    private final Date date;
    private final String message;

    Commit(CodeChange codeChange, CommitHash commitHash, CommitAuthor commitAuthor, Date date, String message) {
        this.codeChange = codeChange;
        this.commitHash = commitHash;
        this.commitAuthor = commitAuthor;
        this.date = date;
        this.message = message;
    }

    public void amendWith(CodeChange codeChange) {

    }

    Commit cherryPick() {
        return new Commit(codeChange, commitHash, commitAuthor, date, message);
    }

    public CommitHash commitHash() {
        return commitHash;
    }
}
