package com.smalaca.ci.domain.pipeline;

public class PipelineStatusTracker {
    private final PipelineId pipelineId;
    private boolean started;
    private boolean testsSucceed;
    private boolean staticAnalysisSucceed;

    public PipelineStatusTracker(PipelineId pipelineId) {
        this.pipelineId = pipelineId;
    }

    public void started() {
        this.started = true;
    }

    public void testsSucceed() {
        this.testsSucceed = true;
    }

    public void staticAnalysisSucceed() {
        this.staticAnalysisSucceed = true;
    }

    public boolean isCompleted() {
        return started && testsSucceed && staticAnalysisSucceed;
    }
}
