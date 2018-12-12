package com.smalaca.ci.domain.build.events;

import com.smalaca.ci.domain.build.BuildType;
import com.smalaca.ci.domain.pipeline.PipelineId;

public class BuildTriggered {
    private final PipelineId pipelineId;
    private final BuildType buildType;

    BuildTriggered(PipelineId pipelineId, BuildType buildType) {
        this.pipelineId = pipelineId;
        this.buildType = buildType;
    }

    public PipelineId pipelineId() {
        return pipelineId;
    }

    public BuildType buildType() {
        return buildType;
    }
}
