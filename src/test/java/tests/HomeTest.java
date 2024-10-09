package tests;

import org.junit.After;
import org.junit.Before;
import ultis.TestBase;

import java.net.MalformedURLException;

public class HomeTest extends TestBase {
    @Before
    public void setUpTest() throws MalformedURLException {
        setUp();
    }


    @After
    public void tearDownTest() {
        tearDown();
    }
}
