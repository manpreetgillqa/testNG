package testPackage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;

public class testLogin {

    static WebDriver driver;


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


    @Test(retryAnalyzer = RetryAnalyser.class)
    public void testGoogle() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://google.com/");
        Thread.sleep(2000);
        Assert.assertEquals(randomNumber(100)%2,0);
    }

    @AfterMethod
    public void teardown()  {
        driver.quit();
    }

    public static void takeScreenshot(String methodName){
            try {
                TakesScreenshot sc = (TakesScreenshot) driver;
                File scFile = sc.getScreenshotAs(OutputType.FILE);
                File newFile = new File("./screenShots/"+ methodName + "_"+ getTimeStamp()+ ".png");
                FileUtils.copyFile(scFile,newFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
    public static int randomNumber(int max){
        Random r = new Random();
        return r.nextInt(max);
    }
    public static String getTimeStamp(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        Long time = new Date().getTime();
        Timestamp timestamp = new Timestamp(time);
        return dateFormat.format(timestamp);
    }
}
