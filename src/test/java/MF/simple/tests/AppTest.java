package MF.simple.tests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }


    public void testAppA() {
        System.out.println("System-out : AppTest.testAppA");

        boolean actual = true;
        String value = System.getProperty("failOther");
        if (value != null && value.toLowerCase().equals("true")) {
            actual = false;
        }

        assertTrue("testAppA error message", actual);
    }

    public void testAppB() {
        System.out.println("System-out : AppTest.testAppB");
        int actual = 5;
        String value = System.getProperty("failOther");
        if (value != null && value.toLowerCase().equals("true")) {
            actual = 23;
        }
        assertEquals(5, actual);
    }

    public void testAppC() {
        assertTrue(true);
    }

    public void testAppD() {
        System.out.println("System-out : AppTest.testAppD");

        String value = System.getProperty("failOther");
        if (value != null && value.toLowerCase().equals("true")) {
            throw new RuntimeException("my runtime exception");
        }
    }

    public void testWillFailOnParameter() {
        String value = System.getProperty("fail");
        if (value != null && value.toLowerCase().equals("true")) {
            fail("fail parameter is set");
        }
    }

    public void testWillThrowOnParameter() {
        String value = System.getProperty("throw");
        if (value != null && value.toLowerCase().equals("true")) {
            throw new RuntimeException("Throw parameter is set");
        }
    }

    public void testWillSleepOnParameter() throws InterruptedException {
        String value = System.getProperty("sleep");
        if (value != null) {
            long sleepMs = Long.parseLong(value);
            Thread.sleep(sleepMs);
        }
    }
}
