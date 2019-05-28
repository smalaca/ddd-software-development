package com.smalaca.ci.application.build;

import com.smalaca.ci.domain.build.Build;
import com.smalaca.ci.domain.build.BuildRepository;
import com.smalaca.ci.domain.pipeline.Pipeline;
import com.smalaca.ci.domain.pipeline.PipelineRepository;
import com.smalaca.ci.domain.build.completness.BuildSpecificationFactory;
import com.smalaca.ci.domain.build.events.BuildCompleted;
import com.smalaca.ci.domain.pipeline.TriggerNextBuildService;

public class BuildCompletedListener {
    private final BuildRepository buildRepository;
    private final PipelineRepository pipelineRepository;
    private final TriggerNextBuildService triggerNextBuildService;

    public BuildCompletedListener(
            BuildRepository buildRepository, PipelineRepository pipelineRepository,
            TriggerNextBuildService triggerNextBuildService) {
        this.buildRepository = buildRepository;
        this.pipelineRepository = pipelineRepository;
        this.triggerNextBuildService = triggerNextBuildService;
    }

    public void listen(BuildCompleted buildCompleted) {
        Build build = buildRepository.find(buildCompleted.buildId());
        Pipeline pipeline = pipelineRepository.find(buildCompleted.pipelineId());

        triggerNextBuildService.process(build, pipeline);
    }
}
