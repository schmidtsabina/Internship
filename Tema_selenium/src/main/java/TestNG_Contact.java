import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
//--
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//--
import org.openqa.selenium.WebElement;
//--
import org.openqa.selenium.chrome.ChromeDriver;
//--
import org.openqa.selenium.devtools.Message;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//--
import org.testng.annotations.AfterClass;
//--
import org.testng.annotations.BeforeClass;
//--
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_Contact {
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
    public void verifyNameRequired() throws InterruptedException {
        driver.get("https://ancabota09.wixsite.com/intern");
        WebElement Contactbutton = driver.findElement(By.id("i6kl732v3label"));
        Contactbutton.click();

        WebElement form=driver.findElement(By.id("comp-jxbsa1dm"));
        Assert.assertTrue(form.isDisplayed(), "The contact form is not displayed");

        WebElement SubmitButton=form.findElement(By.xpath("//*[@id=\"comp-jxbsa1fi\"]/button"));
        Assert.assertTrue(SubmitButton.isDisplayed(), "The contact form is not displayed");

        //NAME FIELD REQUIRED
        WebElement namefield=driver.findElement(By.id("input_comp-jxbsa1e9"));
        SubmitButton.click();
        // Thread.sleep(1000);
        String warningmessage = namefield.getAttribute("validationMessage");
        Assert.assertEquals(warningmessage, "Please fill out this field.", "Browser validation message not displayed as expected.");


    }
    @Test
    public void verifyEmailRequired() throws InterruptedException {
        driver.get("https://ancabota09.wixsite.com/intern");
        WebElement Contactbutton = driver.findElement(By.id("i6kl732v3label"));
        Contactbutton.click();

        WebElement form=driver.findElement(By.id("comp-jxbsa1dm"));
        Assert.assertTrue(form.isDisplayed(), "The contact form is not displayed");

        WebElement SubmitButton=form.findElement(By.xpath("//*[@id=\"comp-jxbsa1fi\"]/button"));
        Assert.assertTrue(SubmitButton.isDisplayed(), "The contact form is not displayed");

        WebElement namefield=driver.findElement(By.id("input_comp-jxbsa1e9"));
        namefield.sendKeys("Sabina");
        Assert.assertEquals(namefield.getAttribute("value"), "Sabina", "The name is not displayed in the name field");
        //EMAIL FIELD REQUIRED
        WebElement emailfield=form.findElement(By.xpath("//*[@id=\"input_comp-jxbsa1em\"]"));
        SubmitButton.click();
        Thread.sleep(2000);
        String warningmessage = emailfield.getAttribute("validationMessage");
        Assert.assertEquals(warningmessage, "Please fill out this field.", "Browser validation message not displayed as expected.");

    }

@Test
    public void verifyMessageRequired() throws InterruptedException {
        driver.get("https://ancabota09.wixsite.com/intern");
        WebElement Contactbutton = driver.findElement(By.id("i6kl732v3label"));
        Contactbutton.click();

        WebElement form=driver.findElement(By.id("comp-jxbsa1dm"));
        Assert.assertTrue(form.isDisplayed(), "The contact form is not displayed");

        WebElement SubmitButton=form.findElement(By.xpath("//*[@id=\"comp-jxbsa1fi\"]/button"));
        Assert.assertTrue(SubmitButton.isDisplayed(), "The contact form is not displayed");
        //NAME FIELD
        WebElement namefield=driver.findElement(By.id("input_comp-jxbsa1e9"));
        namefield.sendKeys("Sabina");
        Assert.assertEquals(namefield.getAttribute("value"), "Sabina", "The name is not displayed in the name field");
        //EMAIL FIELD BECAUSE REQUIRED
        WebElement emailfield=form.findElement(By.xpath("//*[@id=\"input_comp-jxbsa1em\"]"));
        emailfield.sendKeys("email@mail.com");
        Assert.assertEquals(emailfield.getAttribute("value"), "email@mail.com", "The entered Email is not displayed in the Email field");
        //Message field because required
        WebElement Messagefield=form.findElement(By.id("textarea_comp-jxbsa1f7"));
        SubmitButton.click();
        Thread.sleep(2000);
        String warningmessage = Messagefield.getAttribute("validationMessage");
        Assert.assertEquals(warningmessage, "Please fill out this field.", "Browser validation message not displayed as expected.");

    }
    /*
    @Test
    public void ContactFormInvalidName() throws InterruptedException {
        //Write an incorrect name using numbers for example
        driver.get("https://ancabota09.wixsite.com/intern");
        WebElement Contactbutton = driver.findElement(By.id("i6kl732v3label"));
        Contactbutton.click();

        WebElement form=driver.findElement(By.id("comp-jxbsa1dm"));
        Assert.assertTrue(form.isDisplayed(), "The contact form is not displayed");

        WebElement SubmitButton=form.findElement(By.xpath("//*[@id=\"comp-jxbsa1fi\"]/button"));
        Assert.assertTrue(SubmitButton.isDisplayed(), "The contact form is not displayed");
        //name field
        WebElement namefield=driver.findElement(By.id("input_comp-jxbsa1e9"));
        namefield.sendKeys("23742389");
        Assert.assertEquals(namefield.getAttribute("value"), "23742389", "The name is not displayed in the name field");
        //EMAIL FIELD REQUIRED
        WebElement emailfield=form.findElement(By.xpath("//*[@id=\"input_comp-jxbsa1em\"]"));
        emailfield.sendKeys("email@mail.com");
        Assert.assertEquals(emailfield.getAttribute("value"), "email@mail.com", "The entered Email is not displayed in the Email field");
        //Message field because required
        WebElement Messagefield=driver.findElement(By.xpath("//*[@id=\"textarea_comp-jxbsa1f7\"]"));
        Messagefield.sendKeys("Message");
        Assert.assertEquals(Messagefield.getAttribute("value"), "Message", "The message is not displayed in the Message field");
        Thread.sleep(2000);
        SubmitButton.click();
        //check if warning


    }
*/



    @Test
    public void verifyInvalidmail() throws InterruptedException {
        driver.get("https://ancabota09.wixsite.com/intern");
        WebElement Contactbutton = driver.findElement(By.id("i6kl732v3label"));
        Contactbutton.click();

        WebElement form=driver.findElement(By.id("comp-jxbsa1dm"));
        Assert.assertTrue(form.isDisplayed(), "The contact form is not displayed");

        WebElement SubmitButton=form.findElement(By.xpath("//*[@id=\"comp-jxbsa1fi\"]/button"));
        Assert.assertTrue(SubmitButton.isDisplayed(), "The contact form is not displayed");

        WebElement namefield=driver.findElement(By.id("input_comp-jxbsa1e9"));
        namefield.sendKeys("Sabina");
        Assert.assertEquals(namefield.getAttribute("value"), "Sabina", "The name is not displayed in the name field");
        //EMAIL FIELD REQUIRED
        WebElement emailfield=form.findElement(By.xpath("//*[@id=\"input_comp-jxbsa1em\"]"));
        emailfield.sendKeys("mailgresit");
        SubmitButton.click();
        Thread.sleep(2000);
        String warningmessage = emailfield.getAttribute("validationMessage");
        Assert.assertTrue(warningmessage.contains("Please include an '@' in the email address."), "The warning for invalid email address is not displayed.");
    }

    @Test
    public void verifyConfirmationMessage() throws InterruptedException {
        driver.get("https://ancabota09.wixsite.com/intern");

        SoftAssert softAssert = new SoftAssert();

        WebElement Contactbutton = driver.findElement(By.id("i6kl732v3label"));
        Contactbutton.click();

        WebElement form = driver.findElement(By.id("comp-jxbsa1dm"));
        WebElement SubmitButton = form.findElement(By.xpath("//*[@id=\"comp-jxbsa1fi\"]/button"));

        WebElement namefield = driver.findElement(By.id("input_comp-jxbsa1e9"));
        namefield.sendKeys("Sabina");
        softAssert.assertEquals(namefield.getAttribute("value"), "Sabina", "The name is not displayed in the name field");

        WebElement emailfield = form.findElement(By.xpath("//*[@id=\"input_comp-jxbsa1em\"]"));
        emailfield.sendKeys("email@mail.com");
        softAssert.assertEquals(emailfield.getAttribute("value"), "email@mail.com", "The entered Email address is not displayed in the Email field");

        WebElement phonefield = form.findElement(By.id("input_comp-jxbsa1ev"));
        phonefield.sendKeys("0777777");
        softAssert.assertEquals(phonefield.getAttribute("value"), "0777777", "The entered Phone number is not displayed in the Phone field");

        WebElement Messagefield = form.findElement(By.xpath("//*[@id=\"textarea_comp-jxbsa1f7\"]"));
        Messagefield.sendKeys("Message");
        softAssert.assertEquals(Messagefield.getAttribute("value"), "Message", "The message is not displayed in the Message field");

        WebElement confirmationMessageBefore = driver.findElement(By.xpath("//*[@id=\"comp-jxbsa1fv\"]/p/span"));
        softAssert.assertFalse(confirmationMessageBefore.isDisplayed(), "The confirmation message is displayed before submission");

        SubmitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmationMessageAfter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"comp-jxbsa1fv\"]/p/span")));

        softAssert.assertTrue(confirmationMessageAfter.isDisplayed(), "The confirmation message is not displayed after submission");

        softAssert.assertAll();

    }

}