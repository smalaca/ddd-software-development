package com.smalaca.ci.application.saga;

import com.smalaca.ci.domain.pipeline.PipelineStatusTracker;
import com.smalaca.ci.domain.deployment.DeploymentsService;
import com.smalaca.ci.domain.pipeline.events.PipelineEvent;
import com.smalaca.ci.domain.pipeline.events.PipelineTriggered;
import com.smalaca.ci.domain.pipeline.events.StaticAnalysisSucceed;
import com.smalaca.ci.domain.pipeline.events.TestsSucceed;

public class PipelineSaga {
    private final PipelineStatusTracker pipelineStatusTracker;
    private final DeploymentsService deploymentsService;
    private boolean completed = false;

    PipelineSaga(PipelineStatusTracker pipelineStatusTracker, DeploymentsService deploymentsService) {
        this.pipelineStatusTracker = pipelineStatusTracker;
        this.deploymentsService = deploymentsService;
    }

    public void listen(PipelineTriggered pipelineTriggered) {
        pipelineStatusTracker.started();
        tryToComplete(pipelineTriggered);
    }

    public void listen(TestsSucceed testsSucceed) {
        pipelineStatusTracker.testsSucceed();
        tryToComplete(testsSucceed);
    }

    public void listen(StaticAnalysisSucceed staticAnalysisSucceed) {
        pipelineStatusTracker.staticAnalysisSucceed();
        tryToComplete(staticAnalysisSucceed);
    }

    private void tryToComplete(PipelineEvent pipelineEvent) {
        if (pipelineStatusTracker.isCompleted()) {
            completed = true;
            deploymentsService.triggerOf(pipelineEvent.pipelineId());
        }
    }

    public boolean isCompleted() {
        return completed;
    }
}
