package com.smalaca.ci.application.pipeline.completeness;

import com.smalaca.ci.domain.pipeline.PipelineProgress;
import com.smalaca.ci.domain.deployment.DeploymentsService;
import com.smalaca.ci.domain.pipeline.events.PipelineEvent;
import com.smalaca.ci.domain.pipeline.events.PipelineTriggered;
import com.smalaca.ci.domain.pipeline.events.StaticAnalysisSucceed;
import com.smalaca.ci.domain.pipeline.events.TestsSucceed;

class PipelineSaga {
    private final PipelineProgress pipelineProgress;
    private final DeploymentsService deploymentsService;
    private boolean completed = false;

    PipelineSaga(PipelineProgress pipelineProgress, DeploymentsService deploymentsService) {
        this.pipelineProgress = pipelineProgress;
        this.deploymentsService = deploymentsService;
    }

    void listen(PipelineTriggered pipelineTriggered) {
        pipelineProgress.started();
        tryToComplete(pipelineTriggered);
    }

    void listen(TestsSucceed testsSucceed) {
        pipelineProgress.testsSucceed();
        tryToComplete(testsSucceed);
    }

    void listen(StaticAnalysisSucceed staticAnalysisSucceed) {
        pipelineProgress.staticAnalysisSucceed();
        tryToComplete(staticAnalysisSucceed);
    }

    private void tryToComplete(PipelineEvent pipelineEvent) {
        if (pipelineProgress.isCompleted()) {
            completed = true;
            deploymentsService.triggerOf(pipelineEvent.pipelineId());
        }
    }

    boolean isCompleted() {
        return completed;
    }
}
