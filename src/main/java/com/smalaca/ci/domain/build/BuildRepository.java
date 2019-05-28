package com.smalaca.ci.domain.build;

public interface BuildRepository {
    Build find(BuildId buildId);

    void save(Build build);
}
