import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HoverOnAProfilesTest {
    @Test
    public void checkProfilesWithHover() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/hovers");
        Actions hoverOnAProfileAction = new Actions(browser);
        WebElement profile1 = browser.findElements(By.className("figure")).get(0);
        hoverOnAProfileAction.moveToElement(profile1);
        WebElement h5el = browser.findElements(By.cssSelector("h5:first-child")).get(0);
        System.out.println(h5el.getText());
    }
}
