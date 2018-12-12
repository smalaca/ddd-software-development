package com.smalaca.vcs.domain.commit;

public class CommitAuthorFactory {
    public CommitAuthor create(String login) {
        return new CommitAuthor(login);
    }
}
