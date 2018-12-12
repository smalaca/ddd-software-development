package com.smalaca.ci.domain.pipeline.events;

import com.smalaca.ci.domain.pipeline.PipelineId;

public interface PipelineEvent {
    PipelineId pipelineId();
}
