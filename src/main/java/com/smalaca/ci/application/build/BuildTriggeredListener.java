package com.smalaca.ci.application.build;

import com.smalaca.ci.domain.build.Build;
import com.smalaca.ci.domain.build.BuildFactory;
import com.smalaca.ci.domain.build.BuildRepository;
import com.smalaca.ci.domain.build.events.BuildTriggered;

public class BuildTriggeredListener {
    private final BuildFactory buildFactory;
    private final BuildRepository buildRepository;

    public BuildTriggeredListener(BuildFactory buildFactory, BuildRepository buildRepository) {
        this.buildFactory = buildFactory;
        this.buildRepository = buildRepository;
    }

    public void listen(BuildTriggered buildTriggered) {
        Build build = buildFactory.create(buildTriggered.pipelineId(), buildTriggered.buildType());

        build.start();

        buildRepository.save(build);
    }
}
