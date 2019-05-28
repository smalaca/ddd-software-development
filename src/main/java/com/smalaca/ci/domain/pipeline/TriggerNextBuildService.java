package com.smalaca.ci.domain.pipeline;

import com.smalaca.ci.domain.build.Build;
import com.smalaca.ci.domain.build.completness.BuildSpecificationFactory;

public class TriggerNextBuildService {
    private final BuildSpecificationFactory buildSpecificationFactory;

    public TriggerNextBuildService(BuildSpecificationFactory buildSpecificationFactory) {
        this.buildSpecificationFactory = buildSpecificationFactory;
    }

    public void process(Build build, Pipeline pipeline) {
        if (buildSpecificationFactory.success().isSatisfied(build)) {
            pipeline.triggerBuildsThatDependOn(build);
        }
    }
}
