package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import lombok.Getter;

public class ExtentManager {

    private static final Logger log = LoggerFactory.getLogger(ExtentManager.class);
    
    @Getter
    private static final ExtentReports extentReports = new ExtentReports();

    private static final ThreadLocal<ExtentTest> reporter = new ThreadLocal<>();

    public static void setReporter(ExtentTest test){
        reporter.set(test);
    }

    public static ExtentTest getReporter(){
        return reporter.get();
    }

    static{
        String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        // add timestamp to the file name to make it unique
        String fileName = "TestReport_" + timestamp + ".html";
        //Defining report destination
        String path = System.getProperty("user.dir") + "/reports/" + fileName;
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);

        //Getting report configurarion
        try {
            File configFile = new File(System.getProperty("user.dir") + "/spark-config.json");
            sparkReporter.loadJSONConfig(configFile);
        } catch (IOException e) {
            log.error("Failed to load Extent report configuration: " + e.getMessage());
        }

        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Author", "Animesh");
    }
}
