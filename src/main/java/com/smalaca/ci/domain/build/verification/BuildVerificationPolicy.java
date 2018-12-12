package com.smalaca.ci.domain.build.verification;

import com.smalaca.ci.domain.build.Build;

public interface BuildVerificationPolicy {
    void verify(Build build);
}
