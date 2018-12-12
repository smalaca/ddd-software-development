package com.smalaca.ci.domain.build.completness;

public class BuildSpecificationFactory {
    public BuildSpecification success() {
        BuildSpecification buildSpecification = new ConjunctionSpecification(new TestsFailedBuildSpecification())
                .or(new DoesBuildTakeTooMuchTimeSpecification());

        return new ConjunctionSpecification(buildSpecification)
                .and(new IsHotFixBuildSpecification());
    }
}
