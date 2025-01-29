package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HerokuAppTest {
//1. Open browser, site https://the-internet.herokuapp.com/login
//2. Enter Username and Password
//3. Click "Login" to enter

    @Test
    public void fillFieldsAndLogin() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        String userName = "tomsmith";
        String password = "SuperSecretPassword!";
        String expectedMessage = "You logged into a secure area!\n" + "×";

        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText();
        driver.findElement(By.id("content")).isDisplayed();
        Assert.assertEquals(expectedMessage, actualMessage);
        driver.quit();
    }
}
