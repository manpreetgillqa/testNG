package testPackage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class RetryAnalyser implements IRetryAnalyzer {
    int counter = 0;

    int retries = 2;


    @Override
    public boolean retry(ITestResult iTestResult) {
        if(counter<retries){
            counter++;
            testLogin.takeScreenshot(iTestResult.getMethod().getMethodName());
            return true;
        }
        return false;
    }
}
