package hover;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HoversPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverTests extends BaseTests {
    @Test
    public void testHoverUser1(){
        HoversPage hoversPage = homePage.clickHovers();
        var caption = hoversPage.hoverOverFigture(1);
        assertTrue(caption.isCaptionDisplayed(),"Caption not displayed");
        assertEquals(caption.getTitle(), "name: user1","Caption title incorrect");
        assertEquals(caption.getLinkText(),"View profile","Caption link incorrect");
        assertTrue(caption.getLink().endsWith("/users/1"),"Link incorrect");
    }
}
