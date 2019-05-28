package com.smalaca.ci.application.pipeline.completeness;

import com.smalaca.ci.domain.pipeline.PipelineId;

import java.util.HashMap;
import java.util.Map;

class PipelineSagaRegistry {
    private final Map<PipelineId, PipelineSaga> sagas = new HashMap<>();

    boolean doesNotExistFor(PipelineId pipelineId) {
        return !sagas.containsKey(pipelineId);
    }

    void register(PipelineId pipelineId, PipelineSaga pipelineSaga) {
        sagas.put(pipelineId, pipelineSaga);
    }

    PipelineSaga getFor(PipelineId pipelineId) {
        return sagas.get(pipelineId);
    }

    void remove(PipelineId pipelineId) {
        sagas.remove(pipelineId);
    }
}
