import java.time.Duration;
import java.time.temporal.ChronoUnit;
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


}

