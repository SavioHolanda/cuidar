package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.EsqueciMinhaSenhaTest;
import tests.FaleTest;
import tests.HomeTest;
import tests.LoginTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
        FaleTest.class,
        EsqueciMinhaSenhaTest.class,
        HomeTest.class,
})
public class SuiteTest {

}