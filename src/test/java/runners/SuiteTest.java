package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pages.HomeTela;
import tests.FaleTest;
import tests.HomeTest;
import tests.LoginTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
        FaleTest.class,
        HomeTest.class,
})
public class SuiteTest {

}