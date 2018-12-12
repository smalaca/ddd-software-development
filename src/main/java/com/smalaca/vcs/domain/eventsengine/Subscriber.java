package com.smalaca.vcs.domain.eventsengine;

import com.smalaca.vcs.domain.commit.events.CommitAdded;

public interface Subscriber {
    void handle(CommitAdded commitAdded);
}
