package testPackage;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
    int counter = 0;

    int retries = 2;


    @Override
    public boolean retry(ITestResult iTestResult) {
        if(counter<retries){
            counter++;
            return true;
        }
        return false;
    }
}
