package com.smalaca.ci.domain.build.completness;

import com.smalaca.ci.domain.build.Build;

class DoesBuildTakeTooMuchTimeSpecification implements BuildSpecification {
    @Override
    public boolean isSatisfied(Build build) {
        return false;
    }
}
