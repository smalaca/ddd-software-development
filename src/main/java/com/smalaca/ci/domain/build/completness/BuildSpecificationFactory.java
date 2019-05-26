package com.smalaca.ci.domain.build.completness;

public class BuildSpecificationFactory {
    public BuildSpecification success() {
        BuildSpecification buildSpecification = new ConjunctionSpecification(
                new BuildPassedTestsSpecification()).and(new BuildFinishedInAllowedTimeSpecification());

        return new ConjunctionSpecification(buildSpecification)
                .or(new IsHotFixBuildSpecification());
    }
}
