package com.smalaca.ci.domain.build.verification;

public class BuildVerificationPolicies {
    public static BuildVerificationPolicy aTestVerification() {
        return new TestVerificationPolicy();
    }

    public static BuildVerificationPolicy staticAnalysisVerification() {
        return new StaticAnalysisVerificationPolicy();
    }

    public static BuildVerificationPolicy performanceVerification() {
        return new PerformanceVerificationPolicy();
    }
}
