package com.smalaca.ci.domain.build;

import com.google.common.collect.ImmutableMap;
import com.smalaca.ci.domain.pipeline.PipelineId;
import com.smalaca.ci.domain.build.verification.BuildVerificationPolicy;
import com.smalaca.ci.domain.build.verification.BuildVerificationPolicies;

import java.util.Map;

public class BuildFactory {
    private Map<BuildType, BuildVerificationPolicy> policies = ImmutableMap.of(
            BuildType.TEST, BuildVerificationPolicies.aTestVerification(),
            BuildType.STATIC_ANALISYS, BuildVerificationPolicies.staticAnalysisVerification(),
            BuildType.PERFORMANCE, BuildVerificationPolicies.performanceVerification()
    );

    public Build create(PipelineId pipelineId, BuildType buildType) {
        BuildVerificationPolicy policy = policies.get(buildType);

        return new Build(pipelineId, policy);
    }
}
