package com.smalaca.vcs.eventsengine.inmemory;

import com.smalaca.vcs.domain.commit.events.CommitAdded;
import com.smalaca.vcs.domain.eventsengine.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class InMemoryEventsEngine {
    private final List<Subscriber> subscribers = new ArrayList<>();

    public void register(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void publish(CommitAdded commitAdded) {
        subscribers.forEach(subscriber -> subscriber.handle(commitAdded));
    }
}
