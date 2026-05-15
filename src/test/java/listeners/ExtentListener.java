package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtentManager;

public class ExtentListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // Code to execute when a test starts
        String description = (result.getMethod().getDescription() != null) ? result.getMethod().getDescription() : result.getMethod().getMethodName();
        ExtentTest test = ExtentManager.getExtentReports().createTest(description);
        ExtentManager.setReporter(test);
        ExtentManager.getReporter().log(Status.INFO, description);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Code to execute when a test succeeds
        ExtentManager.getReporter().log(Status.PASS, "Test passed");
                String screenshotBase64 = utilities.ScreenUtils.captureScreenshot();
        if (!screenshotBase64.isEmpty()) {
            ExtentManager.getReporter().addScreenCaptureFromBase64String(screenshotBase64, "Test Screenshot");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Code to execute when a test fails
        String error = result.getThrowable() != null ? result.getThrowable().getMessage() : "Unknown error";
        ExtentManager.getReporter().log(Status.FAIL, "Test failed: " + error);
        String screenshotBase64 = utilities.ScreenUtils.captureScreenshot();
        if (!screenshotBase64.isEmpty()) {
            ExtentManager.getReporter().addScreenCaptureFromBase64String(screenshotBase64, "Failed Test Screenshot");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        // Generate HTML file
        ExtentManager.getExtentReports().flush();      
    }
}

