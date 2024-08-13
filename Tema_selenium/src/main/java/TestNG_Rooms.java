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
    public void verifyStandardsuiteimage(){
        driver.get("https://ancabota09.wixsite.com/intern");

        WebElement roomsButton =  driver.findElement(By.id("i6kl732v2label"));
        roomsButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'i6klgqap_0\']/iframe")));
        //WebElement iframe = driver.findElement(By.xpath("//*[@id=\'i6klgqap_0\']/iframe"));
        driver.switchTo().frame(iframe);
        WebElement StandardSuiteImage =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'content\']/div/div[2]/div/ul/li[1]/div/div[1]")));
        //String src = StandardSuiteImage.getAttribute("src");
        Assert.assertTrue(StandardSuiteImage.isDisplayed(), "The 'Standard Suite' image is not displayed!");
        //fde015_cb4dcccb4258499a894623f5282baa98.png
        StandardSuiteImage.click();

        wait.until(ExpectedConditions.urlToBe("https://ancabota09.wixsite.com/intern/rooms/rooms/afda6ba1-efd1-4432-bd42-dd678bd4beb4"));
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://ancabota09.wixsite.com/intern/rooms/rooms/afda6ba1-efd1-4432-bd42-dd678bd4beb4";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is incorrect after clicking the Standard button!");


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
        WebElement standardSuiteButton =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'content\']/div/div[2]/div/ul/li[1]/div/div[2]/div[4]/button")));
        Assert.assertTrue(standardSuiteButton.isDisplayed(), "The 'Standard Suite' link is not displayed!");

        standardSuiteButton.click();

        wait.until(ExpectedConditions.urlToBe("https://ancabota09.wixsite.com/intern/rooms/rooms/afda6ba1-efd1-4432-bd42-dd678bd4beb4"));
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://ancabota09.wixsite.com/intern/rooms/rooms/afda6ba1-efd1-4432-bd42-dd678bd4beb4";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is incorrect after clicking the Standard button!");

    }

    @Test
    public void verifyReadOurPolicies(){

        //load the page
        driver.get("https://ancabota09.wixsite.com/intern");
        //rooms button
        WebElement roomsButton = driver.findElement(By.id("i6kl732v2label"));
        roomsButton.click();
         //more info button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'i6klgqap_0\']/iframe")));
        driver.switchTo().frame(iframe);
        WebElement standardSuiteButton =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'content\']/div/div[2]/div/ul/li[1]/div/div[2]/div[4]/button")));
        Assert.assertTrue(standardSuiteButton.isDisplayed(), "The 'Standard Suite' link is not displayed!");
        standardSuiteButton.click();
        driver.switchTo().defaultContent();
        //read our policies
        WebElement iframeStandardSuite=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nKphmK")));
        driver.switchTo().frame(iframeStandardSuite);

        WebElement ReadOurPoliciesButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'singleroom\']/div[3]/div[2]/div[4]/ul/li[2]/span/a")));
        ReadOurPoliciesButton.click();

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
       // String expectedUrl="https://hotels.wixapps.net/index.html?pageId=crop&compId=i6klgqap_0&viewerCompId=i6klgqap_0&siteRevision=3&viewMode=site&deviceType=desktop&locale=en&tz=Europe%2FVaduz&regionalLanguage=en&width=980&height=788&instance=bgG5-FLdoyoEVxu4wnuKI-ASbDcw4lh2wE9w6ORxlNM.eyJpbnN0YW5jZUlkIjoiZjgyZWUyNjQtMDI3NC00OTc4LTkwODItNmVmNzE1Yzg0YjQzIiwiYXBwRGVmSWQiOiIxMzVhYWQ4Ni05MTI1LTYwNzQtNzM0Ni0yOWRjNmEzYzliY2YiLCJtZXRhU2l0ZUlkIjoiZDczMzdkMjAtZWE2OS00NDYwLWEzNzUtYTkxNzI2Y2IzYzI2Iiwic2lnbkRhdGUiOiIyMDI0LTA4LTA2VDA3OjAxOjM2Ljg0OVoiLCJkZW1vTW9kZSI6ZmFsc2UsIm9yaWdpbkluc3RhbmNlSWQiOiI5NDk0YmM4Ny1jODE1LTQ5ZjEtYTNlMy1mYWJhNzBiNGJlYzgiLCJhaWQiOiI1OWFkOTkxNi1mNmUxLTQwN2QtYTViMS1jYzJhZGY5M2I2MDkiLCJiaVRva2VuIjoiMmYxZDlmNDQtZTgxZC0wZDE4LTMzZjctYzdlMDMzMDM3NzY1Iiwic2l0ZU93bmVySWQiOiI2NTQ3ZGNlYy1mZjMxLTRjMmItODIxNy1jNzgxNDQ3ZTExYjkifQ&currency=USD&currentCurrency=USD&commonConfig=%7B%22brand%22%3A%22wix%22%2C%22host%22%3A%22VIEWER%22%2C%22bsi%22%3A%223a1595d6-24cb-46c6-ac93-60a750abc9ce%7C1%22%2C%22siteRevision%22%3A%223%22%2C%22BSI%22%3A%223a1595d6-24cb-46c6-ac93-60a750abc9ce%7C1%22%7D&currentRoute=.%2Frooms&target=_top&section-url=https%3A%2F%2Fancabota09.wixsite.com%2Fintern%2Frooms%2F&vsi=ab7e91e0-0c39-46c9-8fc9-3921fea788a8&userLanguage=en#/terms/afda6ba1-efd1-4432-bd42-dd678bd4beb4";
        Assert.assertTrue(currentUrl.contains("https://hotels.wixapps.net/index.html?pageId=crop&compId=i6klgqap_0&viewerCompId=i6klgqap_0"), "The URL is incorrect after clicking the button!");

        WebElement CheckInTimetext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'terms\']/div/div[1]/span[1]/label/span")));
        Assert.assertTrue( CheckInTimetext.isDisplayed(), "The 'Check In time' is not displayed!");

        WebElement CheckOutTimetext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'terms\']/div/div[1]/span[3]/label/span")));
        Assert.assertTrue( CheckOutTimetext.isDisplayed(), "The 'Check Out time' is not displayed!");

        driver.switchTo().window(parentWindowHandle);

    }

    @Test
    public void verifyAmenities1(){
        //verify A/C
        //load the page
        driver.get("https://ancabota09.wixsite.com/intern");
        //rooms button
        WebElement roomsButton = driver.findElement(By.id("i6kl732v2label"));
        roomsButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'i6klgqap_0\']/iframe")));
        driver.switchTo().frame(iframe);

        // Locate the element that needs to be hovered over
        WebElement hoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'content\']/div/div[2]/div/ul/li[1]/div/div[2]/ul/li[1]/div")));//li .amenity[tooltip='A/C']

        //SCROLL TO ELEMENT
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", hoverElement);


        // Perform hover action using Actions class
        Actions action = new Actions(driver);
        action.moveToElement(hoverElement).perform();

        // Capture the tooltip text
        String tooltipText = hoverElement.getAttribute("tooltip");

        // Assert the tooltip text
        String expectedTooltipText = "A/C";
        Assert.assertEquals(tooltipText, expectedTooltipText, "Tooltip text does not match!");

    }


    @Test
    public void verifyAmenities2(){
        //verify TV
        //load the page
        driver.get("https://ancabota09.wixsite.com/intern");
        //rooms button
        WebElement roomsButton = driver.findElement(By.id("i6kl732v2label"));
        roomsButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'i6klgqap_0\']/iframe")));
        driver.switchTo().frame(iframe);

        // Locate the element that needs to be hovered over
        WebElement hoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'content\']/div/div[2]/div/ul/li[1]/div/div[2]/ul/li[2]/div")));//li .amenity[tooltip='A/C']

        //SCROLL TO ELEMENT
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", hoverElement);

        // Perform hover action using Actions class
        Actions action = new Actions(driver);
        action.moveToElement(hoverElement).perform();

        // Capture the tooltip text
        String tooltipText = hoverElement.getAttribute("tooltip");

        // Assert the tooltip text
        String expectedTooltipText = "TV";
        Assert.assertEquals(tooltipText, expectedTooltipText, "Tooltip text does not match!");

    }


/*
@Test
    public void calendar_(){

    driver.get("https://ancabota09.wixsite.com/intern");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    WebElement roomsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i6kl732v2label")));
    roomsButton.click();


    WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='i6klgqap_0']/iframe")));
    driver.switchTo().frame(iframe);
    //Print current URL and title for debugging
    System.out.println("Current URL: " + driver.getCurrentUrl());
    System.out.println("Current Title: " + driver.getTitle());

// Click on the check-in field
    WebElement checkInField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='check-in']/div[1]")));
    checkInField.click();

// Get today's date and format it
    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d, EEEE MMMM yyyy", Locale.ENGLISH);
    String formattedToday = today.format(formatter);

// Click on the date button for today's date
    WebElement dateButtonCheckIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//div[@class='calendar-popup s-field s-separator visible']//button[@aria-label='%s']", formattedToday))));
    dateButtonCheckIn.click();

    driver.switchTo().frame(iframe);
    WebElement CheckOutField=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='check-out']/div[1]")));
    CheckOutField.click();

    LocalDate checkOutDate = today.plusDays(3);
    String formattedCheckOutDate = checkOutDate.format(formatter);

    WebElement dateButtonCheckOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//div[@class='calendar-popup s-field s-separator']//button[@aria-label='%s'", formattedCheckOutDate))));
    dateButtonCheckOut.click();
}



 */
@Test
    public void verifyAdultsbuttonincrement(){
    driver.get("https://ancabota09.wixsite.com/intern");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    WebElement roomsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i6kl732v2label")));
    roomsButton.click();

    WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='i6klgqap_0']/iframe")));
    driver.switchTo().frame(iframe);

    WebElement adultsbutton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@role='button' and @ng-disabled='isMax()' and @ng-click='up($event)' and contains(@class, 'up') and @aria-label='Increment']\n")));
    adultsbutton.click();

    WebElement adultsfield=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'adults\']")));
    String text=adultsfield.getText();
    System.out.println(text);


}



    @Test
    public void verifyKidsbutton(){
        driver.get("https://ancabota09.wixsite.com/intern");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement roomsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i6kl732v2label")));
        roomsButton.click();

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='i6klgqap_0']/iframe")));
        driver.switchTo().frame(iframe);

        WebElement kidsbutton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hotel-container\"]/section/div/div/form/ul/li[4]//a[@role='button' and @tabindex='-1' and @href='#' and @ng-disabled='isMax()' and @ng-click='up($event)' and @class='up' and @aria-label='Increment']\n")));
        kidsbutton.click();
        WebElement kidsfield=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'children\']")));
        String text=kidsfield.getText();
        System.out.println(text);
    }




    @Test
    public void calendar(){

        driver.get("https://ancabota09.wixsite.com/intern");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement roomsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i6kl732v2label")));
        roomsButton.click();

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"i6klgqap_0\"]/iframe")));
        driver.switchTo().frame(iframe);

        WebElement checkInField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='check-in']/div[1]")));
        checkInField.click();

        LocalDate today = LocalDate.now();
        LocalDate threeDaysAfter = today.plusDays(3);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d, EEEE MMMM yyyy", Locale.ENGLISH);
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH);

        String formattedDate = today.format(formatter);

        String xpath = String.format("//button[@aria-label='%s']", formattedDate);

        WebElement dateButtonCheckIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        wait.withTimeout(Duration.ofSeconds(60));
        dateButtonCheckIn.click();

        WebElement checkinvalue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check_in-value")));
        String formattedDate1 = today.format(newFormatter);

        Assert.assertEquals(checkinvalue.getText(), formattedDate1, "The selected date is NOT displayed in Check In box");

        wait.withTimeout(Duration.ofSeconds(30));
        WebElement checkOutFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hotel-container\"]/section/div/div/form/ul/li[2]/div[2]/div")));
        checkOutFrame.click();

        String newFormattedDate = threeDaysAfter.format(formatter);

        String newXPath = String.format("(//button[@aria-label='%s'])[2]", newFormattedDate);

        WebElement dateButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newXPath)));
        wait.withTimeout(Duration.ofSeconds(60));
        dateButton.click();

        WebElement checkOutvalue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check_out-value")));
        String formattedDate2 = threeDaysAfter.format(newFormatter);

        Assert.assertEquals(checkOutvalue.getText(), formattedDate2, "The selected date is NOT displayed in Check Out box");

    }


@Test
    public void filtersearchNoAdults(){

    driver.get("https://ancabota09.wixsite.com/intern");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    WebElement roomsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i6kl732v2label")));
    roomsButton.click();

    WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"i6klgqap_0\"]/iframe")));
    driver.switchTo().frame(iframe);

    WebElement checkInField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='check-in']/div[1]")));
    checkInField.click();

    LocalDate today = LocalDate.now();
    LocalDate threeDaysAfter = today.plusDays(3);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d, EEEE MMMM yyyy", Locale.ENGLISH);
    DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH);

    String formattedDate = today.format(formatter);

    String xpath = String.format("//button[@aria-label='%s']", formattedDate);

    WebElement dateButtonCheckIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    wait.withTimeout(Duration.ofSeconds(60));
    dateButtonCheckIn.click();

    //String formattedDate1 = today.format(newFormatter);

    wait.withTimeout(Duration.ofSeconds(30));
    WebElement checkOutFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hotel-container\"]/section/div/div/form/ul/li[2]/div[2]/div")));
    checkOutFrame.click();

    String newFormattedDate = threeDaysAfter.format(formatter);

    String newXPath = String.format("(//button[@aria-label='%s'])[2]", newFormattedDate);

    WebElement dateButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newXPath)));
    wait.withTimeout(Duration.ofSeconds(60));
    dateButton.click();

    //number of kids
    WebElement kidsfield=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'children\']")));
    String beforekids=kidsfield.getText();
    WebElement kidsbutton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hotel-container\"]/section/div/div/form/ul/li[4]//a[@role='button' and @tabindex='-1' and @href='#' and @ng-disabled='isMax()' and @ng-click='up($event)' and @class='up' and @aria-label='Increment']\n")));
    kidsbutton.click();
    WebElement afterkids=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'children\']")));
    Assert.assertNotEquals(beforekids,afterkids,"The number of kids has not changed");

    //number of adults
    //WebElement adultsbutton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'adults\']")));
    //String beforeadults=adultsbutton.getText();
    WebElement adultsbuttondecrement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@role='button' and @aria-label='Decrement' and @class='down' and @disabled='disabled']")));
    //Assert.assertFalse(adultsbuttondecrement.isEnabled(),"The adults decrement button is enabled!");
    // If the element is found it means it is disabled
    Assert.assertNotNull(adultsbuttondecrement, "The adults decrement button should be disabled, but it is not.");
}

    @Test
    public void FilterSearchwithkids(){
        driver.get("https://ancabota09.wixsite.com/intern");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement roomsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i6kl732v2label")));
        roomsButton.click();

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"i6klgqap_0\"]/iframe")));
        driver.switchTo().frame(iframe);

        WebElement checkInField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='check-in']/div[1]")));
        checkInField.click();

        LocalDate today = LocalDate.now();
        LocalDate threeDaysAfter = today.plusDays(3);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d, EEEE MMMM yyyy", Locale.ENGLISH);
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH);

        String formattedDate = today.format(formatter);

        String xpath = String.format("//button[@aria-label='%s']", formattedDate);

        WebElement dateButtonCheckIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        wait.withTimeout(Duration.ofSeconds(60));
        dateButtonCheckIn.click();

        //String formattedDate1 = today.format(newFormatter);

        wait.withTimeout(Duration.ofSeconds(30));
        WebElement checkOutFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hotel-container\"]/section/div/div/form/ul/li[2]/div[2]/div")));
        checkOutFrame.click();

        String newFormattedDate = threeDaysAfter.format(formatter);

        String newXPath = String.format("(//button[@aria-label='%s'])[2]", newFormattedDate);

        WebElement dateButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newXPath)));
        wait.withTimeout(Duration.ofSeconds(60));
        dateButton.click();

        //number of kids, select 2 kids
        WebElement kidsbuttonincrement= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#children .up")));
        kidsbuttonincrement.click();


        //number of adults
        WebElement adultsbutton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#adults .up")));
        adultsbutton.click();

        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("s-button")));
        searchButton.click();
        //Rooms with 2+ accommodates have to be displayed (all of them)
        WebElement RoomsDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/div[2]")));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".room.s-separator")));

        List<WebElement> roomElements = RoomsDisplayed.findElements(By.cssSelector(".room.s-separator"));

        Assert.assertTrue(roomElements.size() == 3, "The rooms are not displayed" );

    }

  @Test
  public void searchfilter2adults(){
      driver.get("https://ancabota09.wixsite.com/intern");

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

      WebElement roomsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i6kl732v2label")));
      roomsButton.click();

      WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"i6klgqap_0\"]/iframe")));
      driver.switchTo().frame(iframe);

      WebElement checkInField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='check-in']/div[1]")));
      checkInField.click();

      LocalDate today = LocalDate.now();
      LocalDate threeDaysAfter = today.plusDays(3);

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d, EEEE MMMM yyyy", Locale.ENGLISH);
      DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH);

      String formattedDate = today.format(formatter);

      String xpath = String.format("//button[@aria-label='%s']", formattedDate);

      WebElement dateButtonCheckIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
      wait.withTimeout(Duration.ofSeconds(60));
      dateButtonCheckIn.click();

      //String formattedDate1 = today.format(newFormatter);

      wait.withTimeout(Duration.ofSeconds(30));
      WebElement checkOutFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hotel-container\"]/section/div/div/form/ul/li[2]/div[2]/div")));
      checkOutFrame.click();

      String newFormattedDate = threeDaysAfter.format(formatter);

      String newXPath = String.format("(//button[@aria-label='%s'])[2]", newFormattedDate);

      WebElement dateButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newXPath)));
      wait.withTimeout(Duration.ofSeconds(60));
      dateButton.click();

      //number of adults
      WebElement adultsbutton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#adults .up")));
     // for(int i=0;i<=1;i++)
     // {
         adultsbutton.click();
      //}

      WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("s-button")));
      searchButton.click();
      //All the rooms have to be displayed
      WebElement RoomsDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'content\']/div/div[2]")));

      // Wait for the room card elements to be present
      wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".room.s-separator")));

      // Find all room card elements with both classes
      List<WebElement> roomElements = RoomsDisplayed.findElements(By.cssSelector(".room.s-separator"));

      Assert.assertTrue(roomElements.size() == 3, "The rooms are not displayed" );

      List<WebElement> elements = driver.findElements(By.xpath("//a[@class='s-title']"));

      // Print the titles of the rooms that are displayed
      for (WebElement element : elements) {
          String title = element.getText();
          System.out.println(title);
      }
  }


  @Test
    public void searchfilterwithmaxaccomodates() {
      driver.get("https://ancabota09.wixsite.com/intern");

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

      WebElement roomsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i6kl732v2label")));
      roomsButton.click();

      WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"i6klgqap_0\"]/iframe")));
      driver.switchTo().frame(iframe);

      WebElement checkInField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='check-in']/div[1]")));
      checkInField.click();

      LocalDate today = LocalDate.now();
      LocalDate threeDaysAfter = today.plusDays(3);

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d, EEEE MMMM yyyy", Locale.ENGLISH);
      DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH);

      String formattedDate = today.format(formatter);

      String xpath = String.format("//button[@aria-label='%s']", formattedDate);

      WebElement dateButtonCheckIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
      wait.withTimeout(Duration.ofSeconds(60));
      dateButtonCheckIn.click();

      //String formattedDate1 = today.format(newFormatter);

      wait.withTimeout(Duration.ofSeconds(30));
      WebElement checkOutFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hotel-container\"]/section/div/div/form/ul/li[2]/div[2]/div")));
      checkOutFrame.click();

      String newFormattedDate = threeDaysAfter.format(formatter);

      String newXPath = String.format("(//button[@aria-label='%s'])[2]", newFormattedDate);

      WebElement dateButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newXPath)));
      wait.withTimeout(Duration.ofSeconds(60));
      dateButton.click();

      //number of adults
      WebElement adultsbutton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#adults .up")));
      int maxaccomodates=6;
      for(int i=0;i<maxaccomodates-1;i++) {
           adultsbutton.click();
      }

      WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("s-button")));
      searchButton.click();
      //All the rooms have to be displayed
      WebElement RoomsDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'content\']/div/div[2]")));

      // Wait for the room card elements to be present
      wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".room.s-separator")));

      // Find all room card elements with both classes
      List<WebElement> roomElements = RoomsDisplayed.findElements(By.cssSelector(".room.s-separator"));

      Assert.assertTrue(roomElements.size() == 1, "The rooms are not displayed" );

      List<WebElement> elements = driver.findElements(By.xpath("//a[@class='s-title']"));

      // Print the titles of the rooms that are displayed == Standard Suite
      for (WebElement element : elements) {
          String title = element.getText();
          System.out.println(title);
      }
  }

    @Test
    public void searchfiltermorethanpossibleaccomodates(){

        driver.get("https://ancabota09.wixsite.com/intern");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement roomsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i6kl732v2label")));
        roomsButton.click();

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"i6klgqap_0\"]/iframe")));
        driver.switchTo().frame(iframe);

        WebElement checkInField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='check-in']/div[1]")));
        checkInField.click();

        LocalDate today = LocalDate.now();
        LocalDate threeDaysAfter = today.plusDays(3);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d, EEEE MMMM yyyy", Locale.ENGLISH);
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH);

        String formattedDate = today.format(formatter);

        String xpath = String.format("//button[@aria-label='%s']", formattedDate);

        WebElement dateButtonCheckIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        wait.withTimeout(Duration.ofSeconds(60));
        dateButtonCheckIn.click();

        wait.withTimeout(Duration.ofSeconds(30));
        WebElement checkOutFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hotel-container\"]/section/div/div/form/ul/li[2]/div[2]/div")));
        checkOutFrame.click();

        String newFormattedDate = threeDaysAfter.format(formatter);

        String newXPath = String.format("(//button[@aria-label='%s'])[2]", newFormattedDate);

        WebElement dateButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newXPath)));
        wait.withTimeout(Duration.ofSeconds(60));
        dateButton.click();

        //number of adults
        WebElement adultsbutton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#adults .up")));
        int maxaccomodates=6;
        for(int i=0;i<maxaccomodates;i++) {
            adultsbutton.click();
        }

        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("s-button")));
        searchButton.click();
        //All the rooms have to be displayed
        WebElement RoomsDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'content\']/div/div[2]")));
        // Find all room card elements with both classes
        List<WebElement> roomElements = RoomsDisplayed.findElements(By.cssSelector(".room.s-separator"));

        Assert.assertTrue(roomElements.isEmpty(), "The rooms are displayed" );

        String message="We can’t seem to find what you’re looking for. Try another search";
        WebElement textdisplayed=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'content\']/div/div[2]/div/p")));
        Assert.assertEquals(textdisplayed,message,"The message is not displayed");
}

    @Test
    public void ClearFilters() {
        driver.get("https://ancabota09.wixsite.com/intern");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement roomsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i6kl732v2label")));
        roomsButton.click();

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"i6klgqap_0\"]/iframe")));
        driver.switchTo().frame(iframe);

        WebElement checkInField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='check-in']/div[1]")));
        checkInField.click();

        LocalDate today = LocalDate.now();
        LocalDate threeDaysAfter = today.plusDays(3);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d, EEEE MMMM yyyy", Locale.ENGLISH);
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH);

        String formattedDate = today.format(formatter);

        String xpath = String.format("//button[@aria-label='%s']", formattedDate);

        WebElement dateButtonCheckIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        wait.withTimeout(Duration.ofSeconds(60));
        dateButtonCheckIn.click();

        //String formattedDate1 = today.format(newFormatter);

        wait.withTimeout(Duration.ofSeconds(30));
        WebElement checkOutFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hotel-container\"]/section/div/div/form/ul/li[2]/div[2]/div")));
        checkOutFrame.click();

        String newFormattedDate = threeDaysAfter.format(formatter);

        String newXPath = String.format("(//button[@aria-label='%s'])[2]", newFormattedDate);

        WebElement dateButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newXPath)));
        wait.withTimeout(Duration.ofSeconds(60));
        dateButton.click();

        //number of adults ==3 so that only one room is displayed
        WebElement adultsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#adults .up")));
        for (int i = 0; i < 2; i++) {
            adultsButton.click();
        }

        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("s-button")));
        searchButton.click();

        WebElement roomsDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/div/div[2]")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".room.s-separator")));

        List<WebElement> roomElements = roomsDisplayed.findElements(By.cssSelector(".room.s-separator"));
        Assert.assertEquals(roomElements.size(), 1, "The rooms are not displayed correctly");

        List<WebElement> elementsBeforeClear = driver.findElements(By.xpath("//a[@class='s-title']"));
        System.out.println("Rooms before clear:");
        for (WebElement element : elementsBeforeClear) {
            System.out.println(element.getText());
        }

        WebElement clearButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/div/div[1]/h2/a")));
        clearButton.click();

        roomsDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/div/div[2]")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".room.s-separator")));

        roomElements = roomsDisplayed.findElements(By.cssSelector(".room.s-separator"));
        Assert.assertEquals(roomElements.size(), 3, "The rooms are not displayed correctly after clearing the filter");

        List<WebElement> elementsAfterClear = driver.findElements(By.xpath("//a[@class='s-title']"));
        System.out.println("Rooms after clear:");
        for (WebElement element : elementsAfterClear) {
            System.out.println(element.getText());
        }

    }

/*
    @Test
    public void Searchagain()
    {

    }

 */
}


