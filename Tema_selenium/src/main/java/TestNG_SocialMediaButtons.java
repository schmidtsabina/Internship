import java.time.Duration;
import java.util.Set;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//--
import org.testng.annotations.AfterClass;
//--
import org.testng.annotations.BeforeClass;
//--
import org.testng.annotations.Test;

public class TestNG_SocialMediaButtons{

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
    public void verifyTwitterbutton() {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://ancabota09.wixsite.com/intern");

        WebElement TwitterButton = driver.findElement(By.xpath("//*[@id=\'img_1_i6rlbitx\']/img"));
        Assert.assertTrue(TwitterButton.isDisplayed(), "The Facebook button is not displayed!");
        TwitterButton.click();

        String parentWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Loop through the window handles to find the handle of the new window
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://x.com/wix"), "The URL is incorrect after clicking the button!");
        driver.switchTo().window(parentWindowHandle);


    }
    @Test
    public void verifyPinterestbutton() {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://ancabota09.wixsite.com/intern");

        WebElement PinterestButton = driver.findElement(By.xpath("//*[@id=\'img_2_i6rlbitx\']/img"));
        Assert.assertTrue(PinterestButton.isDisplayed(), "The Facebook button is not displayed!");
        PinterestButton.click();

        String parentWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Loop through the window handles to find the handle of the new window
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://www.pinterest.com/wixcom/"), "The URL is incorrect after clicking the button!");
        driver.switchTo().window(parentWindowHandle);


    }
    @Test
    public void verifyFacebookbutton() {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://ancabota09.wixsite.com/intern");

        WebElement facebookButton = driver.findElement(By.xpath("//*[@id='img_0_i6rlbitx']/img"));
        Assert.assertTrue(facebookButton.isDisplayed(), "The Facebook button is not displayed!");
        facebookButton.click();

        String parentWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Loop through the window handles to find the handle of the new window
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://www.facebook.com/wix"), "The URL is incorrect after clicking the button!");
        driver.switchTo().window(parentWindowHandle);


    }
    @Test
    public void mail(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ancabota09.wixsite.com/intern");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement MailButton =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"i71ww6nk\"]/p[1]/a")));
        Assert.assertTrue(MailButton.isDisplayed());
        MailButton.click();

        //href attribute contains mailto
        String href = MailButton.getAttribute("href");
        Assert.assertTrue(href.startsWith("mailto:"), "The Contact link does not contain a 'mailto' link.");
    }
}

