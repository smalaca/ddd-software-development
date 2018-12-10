package com.smalaca;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DomainDriveDesignTest {
    @Test
    public void shouldAnswerWithTrue() {
        DomainDriveDesign domainDriveDesign = new DomainDriveDesign();

        assertTrue(domainDriveDesign.makesDifference());
    }
}
