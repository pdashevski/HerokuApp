import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckAndUncheckChecboxesTest {
    @Test
    public void checkBoxesShouldBeCheckedAndUnchecked() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkBoxes = browser.findElements(By.cssSelector("[type=checkbox]"));
        Assert.assertFalse((checkBoxes.get(0).isSelected()), "ERROR! The first checkbox is checked!");
        checkBoxes.get(0).click();
        Assert.assertTrue((checkBoxes.get(0).isSelected()), "ERROR! The first checkbox is unchecked!");
        Assert.assertTrue((checkBoxes.get(1).isSelected()), "ERROR! The second checkbox is unchecked");
        checkBoxes.get(1).click();
        Assert.assertFalse(checkBoxes.get(1).isSelected(), "ERROR! The second checkbox is checked");
        browser.quit();
    }
}
