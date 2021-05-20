package com.mpkg;

import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.Test;

public class TestSuiteDemo {
    TestSuite testSuite = new TestSuite(CraftSwordTest.class, InventoryTest.class, ItemTest.class, MenuTest.class, PlanetTest.class);
    TestResult testResult = new TestResult();

    @Test
    public void testSuiteInAction(){
        testSuite.run(testResult);
        System.out.println("Amount of test cases: " + testSuite.countTestCases());
        testSuite.setName("SimpleTestSuite");
        System.out.println("Name of test suite: " + testSuite.getName());
    }
}
