package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.FaleTest;
import tests.LoginTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
        FaleTest.class,
})
public class SuiteTest {

}