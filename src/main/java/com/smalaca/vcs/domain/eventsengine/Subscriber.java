package com.smalaca.vcs.domain.eventsengine;

import com.smalaca.vcs.domain.branch.CommitAdded;

public interface Subscriber {
    void handle(CommitAdded commitAdded);
}
