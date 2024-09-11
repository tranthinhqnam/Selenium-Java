package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DropdownPage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTests extends BaseTests {
    @Test
    public void testSelectOption() {
        DropdownPage dropDownPage = homePage.clickDropdown();
        String option = "Option 1";
        dropDownPage.selectFromDropdown(option);
        List<String> selectedOptions = dropDownPage.getSelectedOption();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option),"Option not selected");

    }
}
