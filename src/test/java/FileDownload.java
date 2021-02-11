import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class FileDownload {
    @Test
    public void fileDownload() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        HashMap<String, Object> operaPrefs = new HashMap<>();
        operaPrefs.put("profile.default_content_settings.popups", 0);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", operaPrefs);
        browser = new ChromeDriver(options);
        browser.get("http://the-internet.herokuapp.com/download");
        browser.findElement(By.xpath("//a[contains(text(),'logo.png')]")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        File logo = new File("C:\\Users\\Dell\\Downloads\\logo.png");
        Assert.assertTrue(logo.isFile(), "Downloaded document is not found");
        logo.deleteOnExit();

        browser.quit();
    }
}
