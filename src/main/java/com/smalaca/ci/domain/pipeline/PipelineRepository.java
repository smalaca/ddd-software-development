package com.smalaca.ci.domain.pipeline;

public interface PipelineRepository {
    Pipeline find(PipelineId pipelineId);
}
