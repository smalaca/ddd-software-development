package com.smalaca.ci.domain.pipeline.events;

import com.smalaca.ci.domain.pipeline.PipelineId;

public class TestsSucceed implements PipelineEvent {
    private final PipelineId pipelineId;

    TestsSucceed(PipelineId pipelineId) {
        this.pipelineId = pipelineId;
    }

    @Override
    public PipelineId pipelineId() {
        return pipelineId;
    }
}
