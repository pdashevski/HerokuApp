import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CheckTheTyposInParagraphTest {
    public static final String EXPECTED_TYPOS = "Sometimes you'll see a typo, other times you won't.";
    @Test
    public void paragraphTextShouldBeTheSame() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/typos");
        WebElement typos = browser.findElements(By.tagName("p")).get(1);
        String actualTypos = typos.getText();
        Assert.assertEquals(actualTypos, EXPECTED_TYPOS, "don't");
        browser.quit();
    }
}
