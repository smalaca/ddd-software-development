package com.smalaca.vcs.domain.eventsengine;

import com.smalaca.vcs.domain.commit.events.CommitAdded;

public interface EventsEngine {
    void register(Subscriber subscriber);

    void publish(CommitAdded commitAdded);
}
