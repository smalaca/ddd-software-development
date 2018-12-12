package com.smalaca.ci.domain.build.completness;

class ConjunctionSpecification {
    private final BuildSpecification first;

    ConjunctionSpecification(BuildSpecification first) {
        this.first = first;
    }

    BuildSpecification or(BuildSpecification second) {
        return build -> first.isSatisfied(build) || second.isSatisfied(build);
    }

    BuildSpecification and(BuildSpecification second) {
        return build -> first.isSatisfied(build) && second.isSatisfied(build);
    }
}
