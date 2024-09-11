package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

public class BaseTests {
    protected HomePage homePage;
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "resources/msedgedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
