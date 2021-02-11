import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FramesTest {
    @Test
    public void contexClick() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/iframe");
        browser.switchTo().frame("mce_0_ifr");
        String text = browser.findElement(By.xpath("//*[@id='tinymce']/p")).getText();
        Assert.assertEquals(text, "Your content goes here.", "Text does not match");
        browser.quit();
    }
}
