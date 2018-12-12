package com.smalaca.ci.application.eventsubscribers;

import com.smalaca.ci.domain.build.Build;
import com.smalaca.ci.domain.build.BuildFactory;
import com.smalaca.ci.domain.build.events.BuildTriggered;

public class BuildTriggeredListener {
    private final BuildFactory buildFactory;

    public BuildTriggeredListener(BuildFactory buildFactory) {
        this.buildFactory = buildFactory;
    }

    public void listen(BuildTriggered buildTriggered) {
        Build build = buildFactory.create(buildTriggered.pipelineId(), buildTriggered.buildType());

        build.start();
    }
}
