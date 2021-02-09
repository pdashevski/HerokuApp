import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertTest {
    @Test
    public void siteShouldBeOpened() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/javascript_alerts");
        browser.findElement(By.cssSelector("[onclick='jsAlert()']")).click();
        Alert alert = browser.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.dismiss();
        browser.quit();
    }

    @Test
    public void jsAlert2() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/javascript_alerts");

        Actions action = new Actions(browser);
        action.contextClick().perform();

        action
                .moveToElement(browser.findElement(By.tagName("a")))
                .clickAndHold()
                .moveToElement(browser.findElement(By.tagName("b")))
                .release()
                .build()
                .perform();

        browser.quit();
    }
}
