package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleAppTest {
//1. Open browser, site http://www.uitestingplayground.com/sampleapp
//2. Enter User Name and Password
//3. Click "Log In" to enter

    @Test
    public void fillUserDataAndLogin() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        String userName = "Pasha";
        String password = "pwd";
        String welcomeMessage = "Welcome, " + userName + "!";
        String textForLogoutButton = "Log Out";

        driver.get("http://www.uitestingplayground.com/sampleapp");
        driver.findElement(By.name("UserName")).sendKeys(userName);
        driver.findElement(By.name("Password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        String actualMessage = driver.findElement(By.id("loginstatus")).getText();
        Assert.assertEquals(welcomeMessage, actualMessage);
        String logoutButton = driver.findElement(By.id("login")).getText();
        Assert.assertEquals(textForLogoutButton, logoutButton);

        driver.quit();
    }
}
