import java.util.NoSuchElementException;
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

public class TestNG_02 {

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
    public void verifyStandardSuite() {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://ancabota09.wixsite.com/intern");

        WebElement roomsButton =  driver.findElement(By.id("i6kl732v2label"));
        roomsButton.click();

        WebElement standardSuiteButton = driver.findElement(By.xpath("//*[@id=\'content\']/div/div[2]/div/ul/li[1]/div/div[2]/div[1]/h3/a"));
        Assert.assertTrue(standardSuiteButton.isDisplayed(), "The 'Standard Suite' button is not displayed!");


    }
}