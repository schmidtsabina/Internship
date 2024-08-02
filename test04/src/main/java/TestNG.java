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
    public void verifyContactbutton() {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://ancabota09.wixsite.com/intern");

        WebElement button = driver.findElement(By.id("i6kl732v3label"));
        //Assert.assertTrue(button.isDisplayed(), "The 'Contact' button is not displayed!");
        if (!button.isDisplayed()) {
            Assert.fail("The 'Contact' button is not displayed!");
        }else
            System.out.println("The 'Contact' button is displayed");

        String buttonText = button.getText();
        Assert.assertEquals(buttonText, "CONTACT", "The button text is incorrect!");

        button.click();
        String currentUrl = driver.getCurrentUrl();
        String pageUrl="https://ancabota09.wixsite.com/intern/contact";
        Assert.assertEquals(currentUrl,pageUrl, "The URL is incorrect after clicking the button!");
        System.out.println("The Url is correct after clicking the button");
    }
}
