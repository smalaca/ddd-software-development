package com.smalaca.vcs.domain.commit;

public interface CommitRepository {
    Commit find(CommitHash commitHash);
}
