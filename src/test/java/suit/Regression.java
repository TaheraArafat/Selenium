package suit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.FDAddressSelectorForExistingUsersTests;
import test.FDAddressSelectorPageForAnonymousUsersTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        //FDAddressSelectorPageForAnonymousUsersTests.class
        FDAddressSelectorForExistingUsersTests.class
})
public class Regression {
}
