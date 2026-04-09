package googleTests;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SampleReport {
    
    private final ExtentReports extent = new ExtentReports();
    private final File configFile = new File("spark-config.json");
    private final ExtentSparkReporter spark = new ExtentSparkReporter("sampleExtent.html");

    @Test(description="Sample test to demonstrate ExtentReports by me")
    public void sampleTest() throws IOException {
        spark.loadJSONConfig(configFile);
        extent.attachReporter(spark);
        ExtentTest test = extent.createTest("Placeholder Test Name", "This is a sample test case to demonstrate ExtentReports.")
        .info("info")
        .pass("pass");
        // This is a sample test method to demonstrate report generation
        System.out.println("This is a sample test for report generation.");
        extent.flush(); // Generate the report
    }
    
}
