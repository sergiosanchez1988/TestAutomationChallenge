package WikiTestRUnner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import Wiki.Apple;
import Wiki.CreateAccountKO;
import Wiki.Pear;

public class TestSuite {	
    @RunWith(Suite.class)

    @Suite.SuiteClasses({
            Apple.class,
            Pear.class,
            CreateAccountKO.class
    })

    public class JunitTestSuite {
    }

}
