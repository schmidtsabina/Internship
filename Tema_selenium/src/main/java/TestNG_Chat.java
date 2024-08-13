import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
//--
import org.openqa.selenium.By;
//--
import org.openqa.selenium.Keys;
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

public class TestNG_Chat{

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
    public void verifyChat() throws InterruptedException {

        driver.get("https://ancabota09.wixsite.com/intern");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement iframe=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"comp-jr4sqg2g\"]/iframe")));
        driver.switchTo().frame(iframe);

        WebElement ChatButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"minimized-chat\"]")));
        ChatButton.click();

        WebElement ChatExpanded=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div")));
        Assert.assertTrue(ChatExpanded.isDisplayed(),"The chat did not open ");

        WebElement textarea=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_3nFws")));
                //xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div/textarea")));
        Assert.assertTrue(textarea.isDisplayed(),"The text area is not displayed ");
        textarea.sendKeys("test");

        WebElement SendButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div/button[2]")));
        SendButton.click();
        Thread.sleep(5000);

        WebElement Messagesent=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"chat-messages-list\"]/div[2]/div/div/div/div/div/div/div/div/div/div")));
        String Message=Messagesent.getText();
        Assert.assertEquals(Message,"test","The message that was not sent correctly");

        WebElement form=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("zd18O")));
        Assert.assertTrue(form.isDisplayed(),"The form is not displayed");

        WebElement NameField=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        NameField.sendKeys("Sabina");
        Thread.sleep(2000);
        String NameFieldText=NameField.getAttribute("value");
        Assert.assertEquals(NameFieldText,"Sabina", "The name was not saved correctly");

        WebElement EmailField=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        EmailField.sendKeys("123@12");
        Thread.sleep(2000);
        //String EmailFieldText=EmailField.getAttribute("value");
        //Assert.assertEquals(EmailFieldText,"123@12", "The name was not saved correctly");
        WebElement warning=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email-error\"]/div")));
        Assert.assertTrue(warning.isDisplayed(),"The warning for valid email is not displayed");
        Thread.sleep(2000);

        EmailField.clear();
        EmailField.sendKeys("1234@asd.r");
        Assert.assertTrue(warning.isDisplayed(),"The warning for valid email is not displayed");
/*
        Thread.sleep(2000);
        EmailField.clear();
        EmailField.sendKeys("asd@1.roo");
        Assert.assertTrue(warning.isDisplayed(),"The warning for valid email is not displayed");

 */
        EmailField.clear();
        EmailField.sendKeys("email@mail.com");
        String EmailFieldText=EmailField.getAttribute("value");
        Assert.assertEquals(EmailFieldText,"email@mail.com", "The name was not saved correctly");

        WebElement FormMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        FormMessage.sendKeys("Test");
        String FormMessageText=FormMessage.getAttribute("value");
        Assert.assertEquals(FormMessageText,"Test", "The message was not saved correctly");

        WebElement SubmitButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dUbg3")));
                //By.xpath("//*[@id=\"chat-messages-list\"]/div[3]/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/form/button")));
        Assert.assertTrue(SubmitButton.isDisplayed(),"The submit button is not displayed");
        SubmitButton.click();
        Thread.sleep(8000);

    }
@Test
    public void ChatFunctionalities() throws InterruptedException {
        //send an emoji
    driver.get("https://ancabota09.wixsite.com/intern");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    WebElement iframe=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"comp-jr4sqg2g\"]/iframe")));
    driver.switchTo().frame(iframe);

    WebElement ChatButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"minimized-chat\"]")));
    ChatButton.click();

    WebElement ChatExpanded=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div")));
    Assert.assertTrue(ChatExpanded.isDisplayed(),"The chat did not open ");

    WebElement EmojiButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sk1yM")));
    EmojiButton.click();

    WebElement EmojiKeyboard=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("uiapb")));
    Assert.assertTrue(EmojiKeyboard.isDisplayed(),"The emoji keyboard did not open ");

    WebElement emoji=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"emojis-tab-content-0\"]/button[21]")));
    emoji.click();

    WebElement SubmitButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div/button[2]")));
    SubmitButton.click();
    WebElement Messagesent=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"chat-messages-list\"]/div[2]/div/div/div/div/div/div/div/div/div/div")));
    String Message=Messagesent.getText();
    Assert.assertTrue(Messagesent.isDisplayed(),"The message that was not sent correctly");

    Thread.sleep(3000);

    //attach an image
    WebElement AttachButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div/button[2]")));
    Assert.assertTrue(AttachButton.isDisplayed(),"The emoji keyboard did not open ");

}

}