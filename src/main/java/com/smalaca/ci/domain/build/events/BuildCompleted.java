package com.smalaca.ci.domain.build.events;

import com.smalaca.ci.domain.build.BuildId;
import com.smalaca.ci.domain.pipeline.PipelineId;

public class BuildCompleted {
    private final BuildId buildId;
    private final PipelineId pipelineId;

    public BuildCompleted(BuildId buildId, PipelineId pipelineId) {
        this.buildId = buildId;
        this.pipelineId = pipelineId;
    }

    public BuildId buildId() {
        return buildId;
    }

    public PipelineId pipelineId() {
        return pipelineId;
    }
}
