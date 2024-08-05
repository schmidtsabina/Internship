import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
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

public class TestNG_calendar {

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
}