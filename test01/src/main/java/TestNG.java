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
    public void verifyBookNowButton() {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://ancabota09.wixsite.com/intern");

        //verify that the button exists
        WebElement button = driver.findElement(By.className("wixui-button"));
        //WebElement button = driver.findElement(By.cssSelector("a.uDW_Qe.wixui-button"));
        Assert.assertTrue(button.isDisplayed(), "The 'BOOK NOW' button is not displayed!");

        String buttonText = button.findElement(By.className("wixui-button__label")).getText();

        //verify the text on the button
        //String buttonText = button.findElement(By.cssSelector(".wixui-button__label")).getText();
        Assert.assertEquals(buttonText, "BOOK NOW", "The button text is incorrect!");
        //verify that the button redirects you to the book now page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://ancabota09.wixsite.com/intern/booknow"), "The URL is incorrect after clicking the button!");
    }
}