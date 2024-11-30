package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportSetup {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentReports getExtent() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-reports/Spark.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }

    public static synchronized ExtentTest getTest() {
        return extentTest.get();
    }

    public static synchronized void setTest(ExtentTest test) {
        extentTest.set(test);
    }
}
