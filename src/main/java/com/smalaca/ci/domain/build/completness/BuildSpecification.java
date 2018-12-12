package com.smalaca.ci.domain.build.completness;

import com.smalaca.ci.domain.build.Build;

public interface BuildSpecification {
    boolean isSatisfied(Build build);
}
