package org.openscience.chemojava.modulesuites;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.openscience.chemojava.libio.weka.WekaTest;

/**
 * TestSuite that runs all the tests for the CDK reaction module.
 *
 * @cdk.module  test-qsarweka
 * @cdk.depends weka.jar
 * @cdk.depends junit.jar
 */
public class MqsarwekaTests {
    
    public static Test suite() {
        TestSuite suite= new TestSuite("CDK QSAR weka Tests");

        // Individual Tests
        
        suite.addTest(WekaTest.suite());
        return suite;
    }
    
}
