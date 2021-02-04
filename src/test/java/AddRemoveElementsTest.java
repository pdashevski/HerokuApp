import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddRemoveElementsTest {
    @Test
    public void siteShouldBeOpened() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElementButton = browser.findElement(By.xpath("//button[text()='Add Element']"));
        addElementButton.click();
        addElementButton.click();
        browser.findElements(By.xpath("//button[text()='Delete']")).get(1).click();
        int countOfButton = browser.findElements(By.xpath("//button[text()='Delete']")).size();
        Assert.assertEquals(countOfButton, 1, "DELETE buttons too mach then expected");
        browser.quit();
    }
}
