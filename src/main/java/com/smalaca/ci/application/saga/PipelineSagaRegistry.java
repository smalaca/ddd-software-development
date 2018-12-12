package com.smalaca.ci.application.saga;

import com.smalaca.ci.domain.pipeline.PipelineId;

import java.util.HashMap;
import java.util.Map;

public class PipelineSagaRegistry {
    private final Map<PipelineId, PipelineSaga> sagas = new HashMap<>();

    public boolean doesNotExistFor(PipelineId pipelineId) {
        return !sagas.containsKey(pipelineId);
    }

    public void register(PipelineId pipelineId, PipelineSaga pipelineSaga) {
        sagas.put(pipelineId, pipelineSaga);
    }

    public PipelineSaga getFor(PipelineId pipelineId) {
        return sagas.get(pipelineId);
    }

    public void remove(PipelineId pipelineId) {
        sagas.remove(pipelineId);
    }
}
