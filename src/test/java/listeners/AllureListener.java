package listeners;


import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.slf4j.Logger;

public class AllureListener implements ITestListener{

    protected static final Logger log = LoggerFactory.getLogger(AllureListener.class); 
    // @Override
    // public void onTestFailure(ITestResult result){
    //     AllureUtils.attachScreenshot("Failure Screenshot", DriverManager.getDriver());
    // }

    // @Override
    // public void onTestSuccess(ITestResult result){
    //     log.info("Attaching screenshot");
    //     AllureUtils.attachScreenshot("test name", DriverManager.getDriver());
    // }
}
