import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ContexMenuTest {
    @Test
    public void contexClick() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(browser);
        actions.contextClick(browser.findElement(By.id("hot-spot"))).perform();
        Alert alert = browser.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu",
                "Text does not match in alert");
        alert.accept();
        browser.quit();
    }
}
