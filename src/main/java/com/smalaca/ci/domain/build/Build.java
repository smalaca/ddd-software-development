package com.smalaca.ci.domain.build;

import com.smalaca.ci.domain.pipeline.PipelineId;
import com.smalaca.ci.domain.build.verification.BuildVerificationPolicy;

public class Build {
    private final PipelineId pipelineId;
    private final BuildVerificationPolicy verificationPolicy;

    Build(PipelineId pipelineId, BuildVerificationPolicy verificationPolicy) {
        this.pipelineId = pipelineId;
        this.verificationPolicy = verificationPolicy;
    }

    public void start() {
        verificationPolicy.verify(this);
    }
}
