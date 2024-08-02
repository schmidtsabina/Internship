import java.util.concurrent.TimeUnit;
//--
import org.openqa.selenium.By;
//--
import org.openqa.selenium.WebDriver;
//--
import org.openqa.selenium.WebElement;
//--
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//--
import org.testng.Assert;
//--
import org.testng.annotations.AfterClass;
//--
import org.testng.annotations.BeforeClass;
//--
import org.testng.annotations.Test;

public class TestNG {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void verifyExplorebutton() {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://ancabota09.wixsite.com/intern");

        WebElement button = driver.findElement(By.id("i6kl732v1label"));
        Assert.assertTrue(button.isDisplayed(), "The 'EXPLORE' button is not displayed!");

        String buttonText = button.getText();
        Assert.assertEquals(buttonText, "EXPLORE", "The button text is incorrect!");

        button.click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://ancabota09.wixsite.com/intern/explore"), "The URL is incorrect after clicking the button!");
    }
}