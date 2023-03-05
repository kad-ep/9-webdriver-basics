package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    /*
    I changed task a bit because it's hard to find a site where "CAMILEO S10 EU" is available to add to cart.
    So I did the next task:

    1.	In the main class write code that opens the chosen internet shop (https://www.bookdepository.com/) in Chrome browser.
    2.	On the Home page locate logo, Sign in Register,  search field, navigation menu, banner.
    3.	Search for "Atomic Habits".
    4.	Click on product "Atomic Habits" on search result page.
    5.  Click "Add to basket"
    6.	Name a branch as "Selenium Basic". Push this project to Epam gitlab and share the project with your mentor.
     */
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        driver.get("https://www.bookdepository.com/");

        WebElement logo = waitForElementLocatedBy(driver, By.className("brand-link"));
        WebElement signInButton = waitForElementLocatedBy(driver, By.partialLinkText("Sign in"));
        WebElement searchField =  waitForElementLocatedBy(driver, By.name("searchTerm"));
        WebElement navMenu = waitForElementLocatedBy(driver, By.cssSelector("div.secondary-header>ul.mobile-nav-content"));
        WebElement banner = waitForElementLocatedBy(driver, By.xpath("//img[@alt='Image of books trending on TikTok']"));

        Thread.sleep(2000);

        searchField.sendKeys("Atomic Habits");
        searchField.sendKeys(Keys.ENTER);

        WebElement bookItem = waitForElementLocatedBy
                (driver, By.xpath("//div[@class='book-item'][1]/div[@class='item-img']"));

        bookItem.click();


        WebElement addToBasketButton = waitForElementLocatedBy(driver, By.cssSelector("div.item-tools a.add-to-basket "));
        addToBasketButton.click();

        driver.quit();



    }
    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        WebElement element =  new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(by));
        return element;
    }
}

// 7.	Select any site and select 5 elements on it, wright 3 css and 3 xpath selectors for
//  each(could be added as a separate file,or commented lines in the code

/*       https://www.youtube.com/

         logo:

         WebElement logo1xpath = driver.findElement(By.xpath("//ytd-topbar-logo-renderer[@id='logo']//a[@id='logo']"))
         WebElement logo2xpath = driver.findElement(By.xpath("//ytd-topbar-logo-renderer[@id='logo']//a[@class='yt-simple-endpoint style-scope ytd-topbar-logo-renderer']"))
         WebElement logo3xpath = driver.findElement(By.xpath(//div[@id='start']//a"))

         WebElement logo1css = driver.findElement(By.cssSelector("ytd-topbar-logo-renderer#logo>a"));
         WebElement logo2css = driver.findElement(By.cssSelector("div#start a"));
         WebElement logo3css = driver.findElement(By.cssSelector("ytd-topbar-logo-renderer#logo a#logo"));

         searchField:

         WebElement searchField1xpath = driver.findElement(By.xpath("//input[@id='search']"));
         WebElement searchField2xpath = driver.findElement(By.xpath("//input[@name='search_query']"));
         WebElement searchField3xpath = driver.findElement(By.xpath("//input[@placeholder='Введите запрос']"));

         WebElement searchField1css = driver.findElement(By.cssSelector("input#search"));
         WebElement searchField2css = driver.findElement(By.cssSelector("div#sb_ifc50>input"));
         WebElement searchField3css = driver.findElement(By.cssSelector("form#search-form input"));

         searchButton

         WebElement searchButton1xpath = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
         WebElement searchButton2xpath = driver.findElement(By.xpath("//ytd-searchbox/button"));
         WebElement searchButton3xpath = driver.findElement(By.xpath("//form/following-sibling::button"));

         WebElement searchButton1css = driver.findElement(By.cssSelector("button#search-icon-legacy"));
         WebElement searchButton2css = driver.findElement(By.cssSelector("div#center button#search-icon-legacy"));
         WebElement searchButton3css = driver.findElement(By.cssSelector("ytd-searchbox#search>button"));

         avatarButton

         WebElement avatarButton1xpath = driver.findElement(By.xpath("//button[@id='avatar-btn']"));
         WebElement avatarButton2xpath = driver.findElement(By.xpath("//button[@class='style-scope ytd-topbar-menu-button-renderer']"));
         WebElement avatarButton3xpath = driver.findElement(By.xpath("//ytd-topbar-menu-button-renderer[@class='style-scope ytd-masthead']/button"));

         WebElement avatarButton1css = driver.findElement(By.cssSelector("button#avatar-btn"));
         WebElement avatarButton2css = driver.findElement(By.cssSelector("button.style-scope.ytd-topbar-menu-button-renderer"));
         WebElement avatarButton3css = driver.findElement(By.cssSelector("ytd-topbar-menu-button-renderer>button"));

         burgerButton

         WebElement burgerButton1xpath = driver.findElement(By.xpath("//div[@id='start']//button[@aria-label='Гид']"));
         WebElement burgerButton2xpath = driver.findElement(By.xpath("//yt-icon-button/button[@aria-label='Гид']"));
         WebElement burgerButton3xpath = driver.findElement(By.xpath("//button[@aria-label='Гид']"));

         WebElement burgerButton1css = driver.findElement(By.cssSelector("div#start button[aria-label='Гид']"));
         WebElement burgerButton2css = driver.findElement(By.cssSelector("yt-icon-button button[aria-label='Гид']"));
         WebElement burgerButton3css = driver.findElement(By.cssSelector("button[aria-label='Гид']"));

*   */

