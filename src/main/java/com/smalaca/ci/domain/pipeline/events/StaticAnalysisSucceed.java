package com.smalaca.ci.domain.pipeline.events;

import com.smalaca.ci.domain.pipeline.PipelineId;

public class StaticAnalysisSucceed implements PipelineEvent {
    private final PipelineId pipelineId;

    StaticAnalysisSucceed(PipelineId pipelineId) {
        this.pipelineId = pipelineId;
    }

    @Override
    public PipelineId pipelineId() {
        return pipelineId;
    }
}
