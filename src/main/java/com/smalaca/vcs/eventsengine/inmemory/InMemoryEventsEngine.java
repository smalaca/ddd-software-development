package com.smalaca.vcs.eventsengine.inmemory;

import com.smalaca.vcs.domain.commit.events.CommitAdded;
import com.smalaca.vcs.domain.eventsengine.EventsEngine;
import com.smalaca.vcs.domain.eventsengine.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class InMemoryEventsEngine implements EventsEngine {
    private final List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void register(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void publish(CommitAdded commitAdded) {
        subscribers.forEach(subscriber -> subscriber.handle(commitAdded));
    }
}
