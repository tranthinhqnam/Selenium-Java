package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertsTest extends BaseTests {
    @Test
    public void testAcceptAlert() {
        var alertsPage = homePage.clickJavascriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You successfully clicked an alert");
    }

    @Test
    public void testGetTextFromAlert(){
        var alertsPage = homePage.clickJavascriptAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDimiss();
        assertEquals(text,"I am a JS Confirm","Incorect");
    }
    @Test
    public void testInputAlert(){
        var alertsPage = homePage.clickJavascriptAlerts();
        alertsPage.triggerPrompt();
        String text = "THINH rocks";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(),"You entered: " + text,"Results incorrect");
    }
}
