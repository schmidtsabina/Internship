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

public class TestNG_NavBar {

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
    public void verifyHomebutton() {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://ancabota09.wixsite.com/intern");

        WebElement button = driver.findElement(By.className("wixui-dropdown-menu__item"));


        Assert.assertTrue(button.isDisplayed(), "The 'HOME' button is not displayed!");

        String buttonText = button.findElement(By.id("i6kl732v0label")).getText();
        Assert.assertEquals(buttonText, "HOME", "The button text is incorrect!");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://ancabota09.wixsite.com/intern"), "The URL is incorrect after clicking the button!");
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
        Assert.assertEquals(currentUrl,pageUrl, "The URL is incorrect after clicking the Contact button!");
    }

}