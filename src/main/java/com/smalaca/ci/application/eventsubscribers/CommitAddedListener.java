package com.smalaca.ci.application.eventsubscribers;

import com.smalaca.ci.domain.pipeline.Pipeline;
import com.smalaca.ci.domain.pipeline.PipelineFactory;
import com.smalaca.ci.domain.pipeline.PipelineRepository;
import com.smalaca.vcs.domain.branch.CommitAdded;

public class CommitAddedListener {
    private final PipelineRepository pipelineRepository;
    private final PipelineFactory pipelineFactory;

    public CommitAddedListener(PipelineRepository pipelineRepository, PipelineFactory pipelineFactory) {
        this.pipelineRepository = pipelineRepository;
        this.pipelineFactory = pipelineFactory;
    }

    public void listen(CommitAdded commitAdded) {
        Pipeline pipeline = pipelineFactory.create(commitAdded.getBranchId(), commitAdded.getCommitHash());

        pipeline.start();

        pipelineRepository.save(pipeline);
    }
}
