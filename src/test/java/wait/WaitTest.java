package wait;

import base.BaseTests;
import org.testng.annotations.Test;

public class WaitTest extends BaseTests {
    @Test
    public void testWaitUntilHidden(){
        var loadingPage = homePage.clickDynamicLoading().clickExample1();
       loadingPage.clickStart();
    }
}
