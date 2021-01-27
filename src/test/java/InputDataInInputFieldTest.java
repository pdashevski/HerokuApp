import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class InputDataInInputFieldTest {
    public static final int BIG_NUMBER = Integer.MAX_VALUE;
    public static final String BIG_NUMBER_STR = String.valueOf(BIG_NUMBER);
    public static final String MAX_BIG_NUMBER_STR = "9.99999999999999999e+47";

    @Test
    public void inputFieldShouldGetData() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/inputs");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement inputField = browser.findElement(By.tagName("input"));
        inputField.sendKeys(Keys.ARROW_UP);
        String inputFieldValue = inputField.getAttribute("value");
        Assert.assertEquals(inputFieldValue, "1");
        inputField.sendKeys(Keys.ARROW_DOWN);
        inputFieldValue = inputField.getAttribute("value");
        inputField.sendKeys(Keys.ARROW_DOWN);
        inputFieldValue = inputField.getAttribute("value");
        Assert.assertEquals(inputFieldValue, "-1");
        inputField.clear();
        inputField.sendKeys(BIG_NUMBER_STR);
        inputFieldValue = inputField.getAttribute("value");
        Assert.assertEquals(inputFieldValue, BIG_NUMBER_STR);
        inputField.clear();
        inputField.sendKeys(MAX_BIG_NUMBER_STR);
        inputField.sendKeys(Keys.ARROW_DOWN);
        inputFieldValue = inputField.getAttribute("value");
        Assert.assertEquals(inputFieldValue, "1e+48"); //EXPECTED ERROR IS HERE
        browser.quit();
    }
}
