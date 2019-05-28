package com.smalaca.ci.application.pipeline.completeness;

import com.smalaca.ci.domain.pipeline.PipelineId;
import com.smalaca.ci.domain.pipeline.PipelineProgress;
import com.smalaca.ci.domain.deployment.DeploymentsService;
import com.smalaca.ci.domain.pipeline.events.PipelineEvent;
import com.smalaca.ci.domain.pipeline.events.PipelineTriggered;
import com.smalaca.ci.domain.pipeline.events.StaticAnalysisSucceed;
import com.smalaca.ci.domain.pipeline.events.TestsSucceed;

public class PipelineSagaEngine {
    private final PipelineSagaRegistry pipelineSagaRegistry;
    private final DeploymentsService deploymentsService;

    public PipelineSagaEngine(PipelineSagaRegistry pipelineSagaRegistry, DeploymentsService deploymentsService) {
        this.pipelineSagaRegistry = pipelineSagaRegistry;
        this.deploymentsService = deploymentsService;
    }

    public void listen(PipelineTriggered pipelineTriggered) {
        PipelineSaga pipelineSaga = loadSaga(pipelineTriggered);
        pipelineSaga.listen(pipelineTriggered);
        cleanRegister(pipelineTriggered, pipelineSaga);
    }

    public void listen(TestsSucceed testsSucceed) {
        PipelineSaga pipelineSaga = loadSaga(testsSucceed);
        pipelineSaga.listen(testsSucceed);
        cleanRegister(testsSucceed, pipelineSaga);
    }

    public void listen(StaticAnalysisSucceed staticAnalysisSucceed) {
        PipelineSaga pipelineSaga = loadSaga(staticAnalysisSucceed);
        pipelineSaga.listen(staticAnalysisSucceed);
        cleanRegister(staticAnalysisSucceed, pipelineSaga);
    }

    private PipelineSaga loadSaga(PipelineEvent pipelineEvent) {
        PipelineId pipelineId = pipelineEvent.pipelineId();

        if (pipelineSagaRegistry.doesNotExistFor(pipelineId)) {
            PipelineSaga pipelineSaga = new PipelineSaga(
                    new PipelineProgress(pipelineId), deploymentsService);

            pipelineSagaRegistry.register(pipelineId, pipelineSaga);
        }

        return pipelineSagaRegistry.getFor(pipelineId);
    }

    private void cleanRegister(PipelineEvent pipelineEvent, PipelineSaga pipelineSaga) {
        if (pipelineSaga.isCompleted()) {
            pipelineSagaRegistry.remove(pipelineEvent.pipelineId());
        }
    }
}
