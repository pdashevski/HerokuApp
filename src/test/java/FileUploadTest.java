import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FileUploadTest {
    @Test
    public void contexClick() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/upload");
        browser.findElement(By.id("file-upload")).sendKeys(new File("src/test/resources/" +
                "fileUpload.txt").getAbsolutePath());
        browser.findElement(By.id("file-submit")).click();
        WebElement successUpl = browser.findElement(By.id("uploaded-files"));
        Assert.assertEquals(successUpl.getText(), "fileUpload.txt", "File name does not match");
        browser.quit();
    }
}
