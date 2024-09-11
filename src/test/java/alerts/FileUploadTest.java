package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends BaseTests {
    @Test
    public void testFileUpload() {
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("/Users/tranthinhqnam/Working Space/SOURCE_CODE/webdriver/resources/msedgedriver");
        assertEquals(uploadPage.getUploadedFiles(),"msedgedriver","Upload fail");

    }
}
