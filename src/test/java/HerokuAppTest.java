import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HerokuAppTest {
    @Test
    public void siteShouldBeOpened() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        //browser.manage().window().setSize(new Dimension(1024, 768));
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver browser = new FirefoxDriver();*/
        browser.get("http://the-internet.herokuapp.com/");
        //browser.findElement(By.id("1")).click();
        browser.quit();
    }
}
