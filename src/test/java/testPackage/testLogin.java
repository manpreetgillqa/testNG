package testPackage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.random.RandomGenerator;

public class testLogin {

    WebDriver driver;


    @Test
    public void test1(){
        int i = randomNumber(100);
        System.out.println(i);
        Assert.assertEquals(i%2,0);


    }

    @Test
    public void test2(){
        int i = randomNumber(100);
        System.out.println(i);
        Assert.assertEquals(i%4,0);
    }


    @Test

    public void test3() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.navigate().to("https://google.com/");
        Thread.sleep(2000);
        Assert.assertEquals(true,false);

    }

    @AfterMethod
    public void teardown(ITestResult result){
        if(ITestResult.FAILURE==result.getStatus()){
            TakesScreenshot sc = (TakesScreenshot) driver;
            File scFile = sc.getScreenshotAs(OutputType.FILE);
            File newFile = new File("./ScreenShot1.png");

        }

        driver.quit();
    }
    public static int randomNumber(int max){
        Random r = new Random();
        return r.nextInt(max);
    }
}
