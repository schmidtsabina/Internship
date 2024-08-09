import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
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

public class TestNG_Search {

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
    public void verifyCheckinCheckoutfor3days() {

        driver.get("https://ancabota09.wixsite.com/intern");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nKphmK")));
        driver.switchTo().frame(iframe);

        WebElement checkInField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'check-in\']")));
        checkInField.click();

        driver.switchTo().defaultContent();
        WebElement checkinFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("U73P_q")));
        driver.switchTo().frame(checkinFrame);

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d, EEEE MMMM yyyy", Locale.ENGLISH);
        String formattedToday = today.format(formatter);

        WebElement dateButtonCheckIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//button[@aria-label='%s']", formattedToday))));
        dateButtonCheckIn.click();

        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframe);
        String verifyCheckIn = driver.findElement(By.id("check-in-value")).getText();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH);
        Assert.assertEquals(today.format(timeFormatter), verifyCheckIn, "The check-in date was not selected correctly");

        driver.switchTo().defaultContent();
        WebElement checkOutFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("U73P_q")));
        driver.switchTo().frame(checkOutFrame);

        LocalDate checkOutDate = today.plusDays(3);
        String formattedCheckOutDate = checkOutDate.format(formatter);
        WebElement dateButtonCheckOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//button[@aria-label='%s']", formattedCheckOutDate))));
        dateButtonCheckOut.click();

        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframe);
        String verifyCheckOut = driver.findElement(By.id("check-out-value")).getText();
        Assert.assertEquals(checkOutDate.format(timeFormatter), verifyCheckOut, "The check-out date was not selected correctly");
    }

    @Test
    public void verifyCheckinCheckoutforlessthan3days() {

        driver.get("https://ancabota09.wixsite.com/intern");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nKphmK")));
        driver.switchTo().frame(iframe);

        WebElement checkInField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'check-in\']")));
        checkInField.click();

        driver.switchTo().defaultContent();
        WebElement checkinFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("U73P_q")));
        driver.switchTo().frame(checkinFrame);

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d, EEEE MMMM yyyy", Locale.ENGLISH);
        String formattedToday = today.format(formatter);

        WebElement dateButtonCheckIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//button[@aria-label='%s']", formattedToday))));
        dateButtonCheckIn.click();

        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframe);
        String verifyCheckIn = driver.findElement(By.id("check-in-value")).getText();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH);
        Assert.assertEquals(today.format(timeFormatter), verifyCheckIn, "The check-in date was not selected correctly");

        driver.switchTo().defaultContent();
        WebElement checkOutFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("U73P_q")));
        driver.switchTo().frame(checkOutFrame);

        LocalDate checkOutDate = today.plusDays(2);
        String formattedCheckOutDate = checkOutDate.format(formatter);
        WebElement dateButtonCheckOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//button[@aria-label='%s']", formattedCheckOutDate))));
        dateButtonCheckOut.click();

        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframe);
        String verifyCheckOut = driver.findElement(By.id("check-out-value")).getText();
        Assert.assertEquals(checkOutDate.format(timeFormatter), verifyCheckOut, "The check-out date was not selected correctly");
    }


@Test
public void verifyAdultsbuttonincrement(){
    driver.get("https://ancabota09.wixsite.com/intern");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nKphmK")));
    driver.switchTo().frame(iframe);

   // String before=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#adults"))).getAttribute("value");
    WebElement valueSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#adults .value")));
    String before = valueSpan.getText();

    //WebElement increment=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'adults\']/a[1]")));
    WebElement increment=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("up")));
    increment.click();

    //String after=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#adults"))).getAttribute("value");
    String after = valueSpan.getText();

    Assert.assertNotEquals(before,after,"The Adults number did not change");

}


    @Test
    public void verifyAdultsbuttondecrementfrom1(){
        driver.get("https://ancabota09.wixsite.com/intern");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nKphmK")));
        driver.switchTo().frame(iframe);

        // String before=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#adults"))).getAttribute("value");
        WebElement valueSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#adults .value")));
        String before = valueSpan.getText();

       // WebElement increment=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'adults\']/a[1]")));
        WebElement increment=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("down")));
        increment.click();

        //String after=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#adults"))).getAttribute("value");
        String after = valueSpan.getText();

        Assert.assertEquals(before,after,"The Adults numbers changed");

    }



    @Test
public void verifyAdultsbuttondecrement(){
    driver.get("https://ancabota09.wixsite.com/intern");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nKphmK")));
    driver.switchTo().frame(iframe);

    WebElement increment=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("up")));
    increment.click();
    increment.click();
    increment.click();

    // String before=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#adults"))).getAttribute("value");
    WebElement valueSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#adults .value")));
    String before = valueSpan.getText();

    WebElement decrement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("down")));
    decrement.click();

    //String after=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#adults"))).getAttribute("value");
    String after = valueSpan.getText();

    Assert.assertNotEquals(before,after,"The Adults numbers did not change");

}



    @Test
    public void verifyKidsButtonincrement(){
        driver.get("https://ancabota09.wixsite.com/intern");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nKphmK")));
        driver.switchTo().frame(iframe);


        WebElement valueSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#children .value")));
        String before = valueSpan.getText();

        WebElement increment=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'children\']/a[1]")));
        //WebElement increment=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("up")));
        increment.click();

        //String after=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#adults"))).getAttribute("value");
        String after = valueSpan.getText();

        Assert.assertNotEquals(before,after,"The Adults number did not change");

    }


@Test
    public void verifyKidsButtondecrement(){
        driver.get("https://ancabota09.wixsite.com/intern");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nKphmK")));
        driver.switchTo().frame(iframe);

        WebElement increment=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'children\']/a[1]")));
        //WebElement increment=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("up")));
        increment.click();
        increment.click();

        WebElement valueSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#children .value")));
        String before = valueSpan.getText();

        WebElement decrement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'children\']/a[2]")));
        //WebElement increment=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("up")));
        decrement.click();

        String after = valueSpan.getText();

        Assert.assertNotEquals(before,after,"The Adults number did not change");

    }


   @Test
   public void KidsReservation(){
       driver.get("https://ancabota09.wixsite.com/intern");

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nKphmK")));
       driver.switchTo().frame(iframe);
       //increase kids
       WebElement incrementkids=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'children\']/a[1]")));
       //WebElement increment=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("up")));
       incrementkids.click();
       //decrease adults to 0
       WebElement valueSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#adults .value")));
       String before = valueSpan.getText();
       WebElement increment=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("down")));
       increment.click();
       String after = valueSpan.getText();
       Assert.assertEquals(before,after,"The Adults numbers changed");

   }


    @Test
    public void search(){
        driver.get("https://ancabota09.wixsite.com/intern");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //check in
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nKphmK")));
        driver.switchTo().frame(iframe);
        WebElement checkInField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'check-in\']")));
        checkInField.click();
        driver.switchTo().defaultContent();
        WebElement checkinFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("U73P_q")));
        driver.switchTo().frame(checkinFrame);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d, EEEE MMMM yyyy", Locale.ENGLISH);
        String formattedToday = today.format(formatter);
        WebElement dateButtonCheckIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//button[@aria-label='%s']", formattedToday))));
        dateButtonCheckIn.click();
        driver.switchTo().defaultContent();

        //check out
        WebElement checkOutFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("U73P_q")));
        driver.switchTo().frame(checkOutFrame);
        LocalDate checkOutDate = today.plusDays(3);
        String formattedCheckOutDate = checkOutDate.format(formatter);
        WebElement dateButtonCheckOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//button[@aria-label='%s']", formattedCheckOutDate))));
        dateButtonCheckOut.click();
        driver.switchTo().defaultContent();

        //number of adultsWebElement
        iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nKphmK")));
        driver.switchTo().frame(iframe);
        WebElement increment=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("up")));
        increment.click();

        //number of kids
        WebElement incrementkids=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'children\']/a[1]")));
        //WebElement increment=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("up")));
        incrementkids.click();

        //search button
        WebElement search=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("s-button")));
        //Assert.assertTrue(search.isDisplayed(), "The 'Search' button is not displayed!");
        search.click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://ancabota09.wixsite.com/intern/rooms"), "The URL is incorrect after clicking the Search button!");
    }
}