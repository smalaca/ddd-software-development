package com.smalaca.vcs.domain.commit;

import java.util.Date;

public class CommitHashFactory {
    public CommitHash buildFrom(CodeChange codeChange, CommitAuthor commitAuthor, Date date) {
        return from(generateFrom(codeChange, commitAuthor, date));
    }

    private String generateFrom(CodeChange codeChange, CommitAuthor commitAuthor, Date date) {
        return null;
    }

    public CommitHash from(String hashCode) {
        return new CommitHash(hashCode);
    }
}
