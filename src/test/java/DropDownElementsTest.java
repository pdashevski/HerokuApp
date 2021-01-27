import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownElementsTest {
    @Test
    public void dropDownElementsArePresentedAndShouldBeChosen() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropDownElement = browser.findElement(By.id("dropdown"));
        List<WebElement> dropDownOptions = dropDownElement.findElements(By.tagName("option"));
        for (WebElement elems: dropDownOptions) {
            Assert.assertTrue(elems.isDisplayed());
        }
        Select dropDown = new Select(dropDownElement);
        dropDown.selectByIndex(1);
        Assert.assertTrue(dropDownOptions.get(1).isSelected(), "The first option of DD is not selected");
        dropDown.selectByIndex(2);
        Assert.assertTrue(dropDownOptions.get(2).isSelected(), "The second option of DD is not selected");
        browser.quit();
    }
}
