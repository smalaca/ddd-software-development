package com.smalaca.ci.domain.deployment;

import com.smalaca.ci.domain.pipeline.PipelineId;

public interface DeploymentsService {
    void triggerOf(PipelineId pipelineId);
}
