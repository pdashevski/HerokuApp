import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicControlsTest {
    @Test
    public void contexClick() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(browser, 4);
        WebElement checkBox = browser.findElement(By.xpath("//*[@label='blah']"));
        WebElement buttonRemove = browser.findElement(By.cssSelector("[onclick='swapCheckbox()']"));
        buttonRemove.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOf(checkBox)), "Checkbox is displayed");
        WebElement input = browser.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(input.isEnabled(), "Input field is enabled");
        WebElement buttonEnable = browser.findElement(By.cssSelector("[onclick='swapInput()']"));
        buttonEnable.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-example']/child::*[@id='message']")));
        Assert.assertTrue(input.isEnabled(), "Input field is disabled");
        browser.quit();
    }
}
