package com.smalaca.vcs.domain.branch;

import com.smalaca.vcs.domain.commit.Commit;
import com.smalaca.vcs.domain.commit.events.CommitAdded;
import com.smalaca.vcs.domain.eventsengine.EventsEngine;

import java.util.List;

public class Branch {
    private final EventsEngine eventsEngine;
    private final List<Commit> commits;
    private final String name;
    private BranchId branchId;


    private Branch(EventsEngine eventsEngine, List<Commit> commits, String name) {
        this.eventsEngine = eventsEngine;
        this.commits = commits;
        this.name = name;
    }

    public void add(Commit commit) {
        // some logic

        eventsEngine.publish(new CommitAdded(branchId, commit.commitHash()));
    }

    public void reset(int decrement) {

    }

    public void rebaseWith(Branch branch) {

    }

    public void mergeWith(Branch branch) {

    }

    public Branch createNew(String branchName) {
        return new Branch(eventsEngine, commits, branchName);
    }
}
