package base;

import com.google.common.io.Files;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTests {
    protected HomePage homePage;
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "resources/msedgedriver");
        driver = new ChromeDriver(getChromeOptions());
        goHome();
        setCookie();
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {

            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            //System.out.println("ScreenShot  taken : " + screenshot.getAbsolutePath());
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return  options;
    }
    public void setCookie(){
        Cookie cookie = new Cookie.Builder("thinh","123")
                .domain("https://the-internet.herokuapp.com/")
                .build();
        driver.manage().addCookie(cookie);

    }

}
