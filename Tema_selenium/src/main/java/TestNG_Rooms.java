import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;
//--
import org.openqa.selenium.By;
//--
import org.openqa.selenium.WebDriver;
//--
import org.openqa.selenium.WebElement;
//--
import org.openqa.selenium.chrome.ChromeDriver;
//--
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//--
import org.testng.annotations.AfterClass;
//--
import org.testng.annotations.BeforeClass;
//--
import org.testng.annotations.Test;

public class TestNG_Rooms {

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
    public void verifyStandardSuiteLink() {

        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://ancabota09.wixsite.com/intern");

        WebElement roomsButton =  driver.findElement(By.id("i6kl732v2label"));
        roomsButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'i6klgqap_0\']/iframe")));
        //WebElement iframe = driver.findElement(By.xpath("//*[@id=\'i6klgqap_0\']/iframe"));
        driver.switchTo().frame(iframe);
        WebElement standardSuiteLink =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.s-title[stranslate='Standard Suite']")));
        Assert.assertTrue(standardSuiteLink.isDisplayed(), "The 'Standard Suite' link is not displayed!");

        standardSuiteLink.click();

        wait.until(ExpectedConditions.urlToBe("https://ancabota09.wixsite.com/intern/rooms/rooms/afda6ba1-efd1-4432-bd42-dd678bd4beb4"));
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://ancabota09.wixsite.com/intern/rooms/rooms/afda6ba1-efd1-4432-bd42-dd678bd4beb4";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is incorrect after clicking the Standard button!");
        driver.quit();

    }

    @Test
    public void verifyStandardSuiteButton() {

       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://ancabota09.wixsite.com/intern");

        WebElement roomsButton = driver.findElement(By.id("i6kl732v2label"));
        roomsButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'i6klgqap_0\']/iframe")));
        //WebElement iframe = driver.findElement(By.xpath("//*[@id=\'i6klgqap_0\']/iframe"));
        driver.switchTo().frame(iframe);
        WebElement standardSuiteLink =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'content\']/div/div[2]/div/ul/li[1]/div/div[2]/div[4]/button")));
        Assert.assertTrue(standardSuiteLink.isDisplayed(), "The 'Standard Suite' link is not displayed!");

        standardSuiteLink.click();

        wait.until(ExpectedConditions.urlToBe("https://ancabota09.wixsite.com/intern/rooms/rooms/afda6ba1-efd1-4432-bd42-dd678bd4beb4"));
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://ancabota09.wixsite.com/intern/rooms/rooms/afda6ba1-efd1-4432-bd42-dd678bd4beb4";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is incorrect after clicking the Standard button!");

    }
}

