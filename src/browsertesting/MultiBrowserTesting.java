package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

/**
 * BaseUrl = https://courses.ultimateqa.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Sign In’ link
 * 7. Print the current url
 * 8. Enter the email to email field.
 * 9. Enter the password to password field.
 * 10. Click on Login Button.
 * 11. Navigate to baseUrl.
 * 12. Navigate forward to Homepage.
 * 13. Navigate back to baseUrl.
 * 14. Refresh the page.
 * 15. Close the browser.
 */
public class MultiBrowserTesting {
    static WebDriver driver;
    static String baseUrl = "https://courses.ultimateqa.com/";                        //Base Url

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter browser name to : "); //awc2cedxw
        String browser = scanner.nextLine();
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }

        driver.get(baseUrl);                                                          //Open the url into browseer
        driver.manage().window().maximize();                                          //Maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));            //Implict wait
        System.out.println("Title of the page is : " + driver.getTitle());            //Print title
        System.out.println("Current Url is : " + driver.getCurrentUrl());             //Print current Url
        System.out.println("Page source is : " + driver.getPageSource());             //Print page source
        driver.findElement(By.linkText("Sign In")).click();                           //Click on sign in link
        System.out.println("Current Url is : " + driver.getCurrentUrl());             //Print current Url
        driver.findElement(By.id("user[email]")).sendKeys("savankakadiya1005@gmail.com"); //Enter email
        driver.findElement(By.id("user[password]")).sendKeys("Savan1005");             //Enter password
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click(); //Click on sign in buttone                           //Click login button
        driver.navigate().to(baseUrl);                                                //Navigate to base url
        driver.navigate().forward();                                                  //Navigate to forward
        driver.navigate().back();                                                     //Navigate back
        driver.navigate().refresh();                                                  //Refresh
        driver.quit();                                                                //Quit browser
        scanner.close();

}
}