package com.smalaca.ci.application.pipeline.completeness;

import com.smalaca.ci.domain.pipeline.PipelineStatusTracker;
import com.smalaca.ci.domain.deployment.DeploymentsService;
import com.smalaca.ci.domain.pipeline.events.PipelineEvent;
import com.smalaca.ci.domain.pipeline.events.PipelineTriggered;
import com.smalaca.ci.domain.pipeline.events.StaticAnalysisSucceed;
import com.smalaca.ci.domain.pipeline.events.TestsSucceed;

class PipelineSaga {
    private final PipelineStatusTracker pipelineStatusTracker;
    private final DeploymentsService deploymentsService;
    private boolean completed = false;

    PipelineSaga(PipelineStatusTracker pipelineStatusTracker, DeploymentsService deploymentsService) {
        this.pipelineStatusTracker = pipelineStatusTracker;
        this.deploymentsService = deploymentsService;
    }

    void listen(PipelineTriggered pipelineTriggered) {
        pipelineStatusTracker.started();
        tryToComplete(pipelineTriggered);
    }

    void listen(TestsSucceed testsSucceed) {
        pipelineStatusTracker.testsSucceed();
        tryToComplete(testsSucceed);
    }

    void listen(StaticAnalysisSucceed staticAnalysisSucceed) {
        pipelineStatusTracker.staticAnalysisSucceed();
        tryToComplete(staticAnalysisSucceed);
    }

    private void tryToComplete(PipelineEvent pipelineEvent) {
        if (pipelineStatusTracker.isCompleted()) {
            completed = true;
            deploymentsService.triggerOf(pipelineEvent.pipelineId());
        }
    }

    boolean isCompleted() {
        return completed;
    }
}
