package com.smalaca.ci.application.eventsubscribers;

import com.smalaca.ci.domain.build.Build;
import com.smalaca.ci.domain.build.BuildRepository;
import com.smalaca.ci.domain.pipeline.Pipeline;
import com.smalaca.ci.domain.pipeline.PipelineRepository;
import com.smalaca.ci.domain.build.completness.BuildSpecificationFactory;
import com.smalaca.ci.domain.build.events.BuildCompleted;

public class BuildCompletedListener {
    private final BuildRepository buildRepository;
    private final PipelineRepository pipelineRepository;
    private final BuildSpecificationFactory buildSpecificationFactory;

    public BuildCompletedListener(
            BuildRepository buildRepository, PipelineRepository pipelineRepository,
            BuildSpecificationFactory buildSpecificationFactory) {
        this.buildRepository = buildRepository;
        this.pipelineRepository = pipelineRepository;
        this.buildSpecificationFactory = buildSpecificationFactory;
    }

    public void listen(BuildCompleted buildCompleted) {
        Build build = buildRepository.find(buildCompleted.buildId());

        if (buildSpecificationFactory.success().isSatisfied(build)) {
            Pipeline pipeline = pipelineRepository.find(buildCompleted.pipelineId());
            pipeline.triggerBuildsThatDependOn(build);
        }
    }
}
