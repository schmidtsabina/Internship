import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
//--
import org.openqa.selenium.By;
//--
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//--
import org.openqa.selenium.WebElement;
//--
import org.openqa.selenium.chrome.ChromeDriver;
//--
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

public class TestNG_RoomPageStandardSuite {
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
    public void calendar() throws InterruptedException {
        driver.get("https://ancabota09.wixsite.com/intern");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement roomsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i6kl732v2label")));
        roomsButton.click();

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'i6klgqap_0\']/iframe")));
        //WebElement iframe = driver.findElement(By.xpath("//*[@id=\'i6klgqap_0\']/iframe"));
        driver.switchTo().frame(iframe);
        WebElement standardSuiteButton =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'content\']/div/div[2]/div/ul/li[1]/div/div[2]/div[4]/button")));
        Assert.assertTrue(standardSuiteButton.isDisplayed(), "The 'Standard Suite' link is not displayed!");

        standardSuiteButton.click();
        driver.switchTo().defaultContent();

        WebElement standardsuiteiframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"i6klgqap_0\"]/iframe")));
        driver.switchTo().frame(standardsuiteiframe);

        WebElement BookNowArea= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"singleroom\"]/div[2]")));
        Assert.assertTrue(BookNowArea.isDisplayed(), "The booking area is not displayed!");
        WebElement checkin=driver.findElement(By.id("check-in"));
        checkin.click();

        LocalDate today = LocalDate.now();
        LocalDate threeDaysAfter = today.plusDays(4);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d, EEEE MMMM yyyy", Locale.ENGLISH);
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH);

        String formattedDate = today.format(formatter);

        String xpath = String.format("//button[@aria-label=\"%s\"]", formattedDate);

        WebElement dateButtonCheckIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        wait.withTimeout(Duration.ofSeconds(30));
        dateButtonCheckIn.click();

        WebElement checkinvalue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check_in-value")));
        String formattedDate1 = today.format(newFormatter);

        Assert.assertEquals(checkinvalue.getText(), formattedDate1, "The selected date is not displayed in Check In box");

        String newFormattedDate = threeDaysAfter.format(formatter);

        String newXPath = String.format("(//button[@aria-label='%s'])[2]", newFormattedDate);

        WebElement dateButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newXPath)));
        wait.withTimeout(Duration.ofSeconds(30));
        dateButton.click();

        WebElement checkOutvalue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check_out-value")));
        String formattedDate2 = threeDaysAfter.format(newFormatter);

        Assert.assertEquals(checkOutvalue.getText(), formattedDate2, "The selected date is not displayed in Check Out box");

}
@Test
public void AdultsButton() throws InterruptedException {
    driver.get("https://ancabota09.wixsite.com/intern");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    WebElement roomsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i6kl732v2label")));
    roomsButton.click();

    WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'i6klgqap_0\']/iframe")));
    //WebElement iframe = driver.findElement(By.xpath("//*[@id=\'i6klgqap_0\']/iframe"));
    driver.switchTo().frame(iframe);
    WebElement standardSuiteButton =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'content\']/div/div[2]/div/ul/li[1]/div/div[2]/div[4]/button")));
    Assert.assertTrue(standardSuiteButton.isDisplayed(), "The 'Standard Suite' link is not displayed!");

    standardSuiteButton.click();
    driver.switchTo().defaultContent();

    WebElement standardsuiteiframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"i6klgqap_0\"]/iframe")));
    driver.switchTo().frame(standardsuiteiframe);

    WebElement adultsbuttondecrement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@role='button' and @aria-label='Decrement' and @class='down' and @disabled='disabled']")));
    Assert.assertNotNull(adultsbuttondecrement, "The adults decrement button should be disabled, but it is not.");
    Thread.sleep(2000);

    WebElement adultsbuttonincrement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#adults .up")));
    int maxaccomodates=6;
    for (int i=0;i<maxaccomodates-1;i++)
    {
        adultsbuttonincrement.click();
    }
    WebElement adultsfield=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"adults\"]")));
    String adultscount=adultsfield.getText();

    Assert.assertEquals(adultscount,"6 Adults","The number of adults was not incremented correctly");


    WebElement adultsbuttonincrementaftermaxaccomodates = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@id=\"adults\"]/a[1]")));
    Assert.assertNotNull(adultsbuttonincrementaftermaxaccomodates, "The adults increment button should be disabled, but it is not.");
    }

    @Test
    public void kidsbutton(){
        driver.get("https://ancabota09.wixsite.com/intern");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement roomsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i6kl732v2label")));
        roomsButton.click();

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'i6klgqap_0\']/iframe")));
        //WebElement iframe = driver.findElement(By.xpath("//*[@id=\'i6klgqap_0\']/iframe"));
        driver.switchTo().frame(iframe);
        WebElement standardSuiteButton =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'content\']/div/div[2]/div/ul/li[1]/div/div[2]/div[4]/button")));
        Assert.assertTrue(standardSuiteButton.isDisplayed(), "The 'Standard Suite' link is not displayed!");

        standardSuiteButton.click();
        driver.switchTo().defaultContent();

        WebElement standardsuiteiframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"i6klgqap_0\"]/iframe")));
        driver.switchTo().frame(standardsuiteiframe);

        WebElement BookNowArea= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"singleroom\"]/div[2]")));
        Assert.assertTrue(BookNowArea.isDisplayed(), "The booking area is not displayed!");
        try {
            WebElement kidsButton = driver.findElement(By.id("children"));
            Assert.assertTrue(kidsButton.isDisplayed(), "Kids button is not displayed.");
        } catch (NoSuchElementException e) {
            Assert.fail("Kids button is not present!");
        }

    }

    @Test
    public void BookNow() throws InterruptedException {
        driver.get("https://ancabota09.wixsite.com/intern");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement roomsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i6kl732v2label")));
        roomsButton.click();

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'i6klgqap_0\']/iframe")));
        //WebElement iframe = driver.findElement(By.xpath("//*[@id=\'i6klgqap_0\']/iframe"));
        driver.switchTo().frame(iframe);
        WebElement standardSuiteButton =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'content\']/div/div[2]/div/ul/li[1]/div/div[2]/div[4]/button")));
        Assert.assertTrue(standardSuiteButton.isDisplayed(), "The 'Standard Suite' link is not displayed!");

        standardSuiteButton.click();
        driver.switchTo().defaultContent();

        WebElement standardsuiteiframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"i6klgqap_0\"]/iframe")));
        driver.switchTo().frame(standardsuiteiframe);

        WebElement BookNowArea= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"singleroom\"]/div[2]")));
        Assert.assertTrue(BookNowArea.isDisplayed(), "The booking area is not displayed!");

        WebElement checkin=driver.findElement(By.id("check-in"));
        checkin.click();

        LocalDate today = LocalDate.now();
        LocalDate threeDaysAfter = today.plusDays(4);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d, EEEE MMMM yyyy", Locale.ENGLISH);
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH);

        String formattedDate = today.format(formatter);

        String xpath = String.format("//button[@aria-label=\"%s\"]", formattedDate);

        WebElement dateButtonCheckIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        wait.withTimeout(Duration.ofSeconds(30));
        dateButtonCheckIn.click();

        WebElement checkinvalue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check_in-value")));
        String formattedDate1 = today.format(newFormatter);

        Assert.assertEquals(checkinvalue.getText(), formattedDate1, "The selected date is NOT displayed in Check In box");

        String newFormattedDate = threeDaysAfter.format(formatter);

        String newXPath = String.format("(//button[@aria-label='%s'])[2]", newFormattedDate);

        WebElement dateButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newXPath)));
        wait.withTimeout(Duration.ofSeconds(30));
        dateButton.click();

        WebElement checkOutvalue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check_out-value")));
        String formattedDate2 = threeDaysAfter.format(newFormatter);

        Assert.assertEquals(checkOutvalue.getText(), formattedDate2, "The selected date is NOT displayed in Check Out box");

        WebElement adultsbuttonincrement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#adults .up")));
        int maxaccomodates=6;
        for (int i=0;i<maxaccomodates-1;i++)
        {
            adultsbuttonincrement.click();
        }
        WebElement adultsfield=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"adults\"]")));
        String adultscount=adultsfield.getText();

        Assert.assertEquals(adultscount,"6 Adults","The number of adults was not incremented correctly");

        Thread.sleep(2000);

        WebElement bookNowButton = driver.findElement(By.xpath("//button[@class='fancy-btn s-button button'][@tooltip='Please contact the hotel directly to book your room.']"));
        String tooltipText = bookNowButton.getAttribute("tooltip");

        Assert.assertEquals(tooltipText, "Please contact the hotel directly to book your room.", "Tooltip text is incorrect or missing.");

    }

    @Test
    public void Price() throws InterruptedException {
        driver.get("https://ancabota09.wixsite.com/intern");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement roomsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i6kl732v2label")));
        roomsButton.click();

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'i6klgqap_0\']/iframe")));
        //WebElement iframe = driver.findElement(By.xpath("//*[@id=\'i6klgqap_0\']/iframe"));
        driver.switchTo().frame(iframe);
        WebElement standardSuiteButton =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'content\']/div/div[2]/div/ul/li[1]/div/div[2]/div[4]/button")));
        Assert.assertTrue(standardSuiteButton.isDisplayed(), "The 'Standard Suite' link is not displayed!");

        standardSuiteButton.click();
        driver.switchTo().defaultContent();

        WebElement standardsuiteiframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"i6klgqap_0\"]/iframe")));
        driver.switchTo().frame(standardsuiteiframe);

        WebElement BookNowArea= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"singleroom\"]/div[2]")));
        Assert.assertTrue(BookNowArea.isDisplayed(), "The booking area is not displayed!");
        WebElement checkin=driver.findElement(By.id("check-in"));
        checkin.click();

        LocalDate today = LocalDate.now();
        LocalDate threeDaysAfter = today.plusDays(4);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d, EEEE MMMM yyyy", Locale.ENGLISH);
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH);

        String formattedDate = today.format(formatter);

        String xpath = String.format("//button[@aria-label=\"%s\"]", formattedDate);

        WebElement dateButtonCheckIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        wait.withTimeout(Duration.ofSeconds(30));
        dateButtonCheckIn.click();

        WebElement checkinvalue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check_in-value")));
        String formattedDate1 = today.format(newFormatter);

        Assert.assertEquals(checkinvalue.getText(), formattedDate1, "The selected date is not displayed in Check In box");

        String newFormattedDate = threeDaysAfter.format(formatter);

        String newXPath = String.format("(//button[@aria-label='%s'])[2]", newFormattedDate);

        WebElement dateButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newXPath)));
        wait.withTimeout(Duration.ofSeconds(30));
        dateButton.click();

        WebElement checkOutvalue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check_out-value")));
        String formattedDate2 = threeDaysAfter.format(newFormatter);

        Assert.assertEquals(checkOutvalue.getText(), formattedDate2, "The selected date is not displayed in Check Out box");

        WebElement adultsbuttonincrement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#adults .up")));
        Assert.assertTrue(adultsbuttonincrement.isDisplayed(),"The button is not displayed");
        int maxaccomodates=6;
        for (int i=0;i<maxaccomodates-1;i++)
        {
            adultsbuttonincrement.click();
        }
        WebElement adultsfield=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"adults\"]")));
        String adultscount=adultsfield.getText();

        Assert.assertEquals(adultscount,"6 Adults","The number of adults was not incremented correctly");

        Thread.sleep(2000);

        WebElement pricebefore=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("total")));
        String pricebeforetext=pricebefore.getText();

        WebElement checkout=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"check-out\"]")));
        checkout.click();
        LocalDate fourDaysAfter = today.plusDays(5);
        String anotherNightDate = fourDaysAfter.format(formatter);
        String anotherNightXPath = String.format("(//button[@aria-label='%s'])[2]", anotherNightDate);

        WebElement dateButtonAnotherNight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(anotherNightXPath)));
        wait.withTimeout(Duration.ofSeconds(30));
        dateButtonAnotherNight.click();

        WebElement checkOutvalueUpdated = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check_out-value")));
        String formattedDateUpdated = fourDaysAfter.format(newFormatter);

        Assert.assertEquals(checkOutvalueUpdated.getText(), formattedDateUpdated, "The updated date is not displayed in Check Out box");

        Thread.sleep(2000);

        WebElement priceafter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("total")));
        String priceaftertext = priceafter.getText();

        Assert.assertNotEquals(pricebeforetext, priceaftertext, "The price did not change after adding another night");

    }

}
