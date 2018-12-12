package com.smalaca.ci.domain.build.completness;

import com.smalaca.ci.domain.build.Build;

class TestsFailedBuildSpecification implements BuildSpecification {
    @Override
    public boolean isSatisfied(Build build) {
        return false;
    }
}
