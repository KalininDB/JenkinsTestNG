package com.ZERO.Tools;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    protected WebDriver driver;
    protected String url;
    Actions actions;

    protected static ExtentReports reports;
    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest() {
        reports = new ExtentReports();

        String path = System.getProperty("user.dir") + "/test-results/report.html";
        htmlReporter = new ExtentHtmlReporter(path);
        reports.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("TestsResults");

        reports.setSystemInfo("Environment", "QA");
        reports.setSystemInfo("Browser", ConfigReader.getKey("browser"));
        reports.setSystemInfo("OS", System.getProperty("os.name"));

    }

    @AfterTest
    public void afterTest() {
        reports.flush();
    }

    @BeforeMethod
    @Parameters("env")
    public void setupMethod(@Optional String env) {
        System.out.println("env: " + env);
        // ENV IS null use default url,
        // if ENV is not null, get the url based on env
        if (env == null) {
            url = ConfigReader.getKey("url");
        } else {
            url = ConfigReader.getKey(env + "_url");
        }

        driver = Driver.get();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        actions = new Actions(Driver.get());
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException, InterruptedException {
        // IF FAILED TAKE SCREENSHOT
        if(result.getStatus() == ITestResult.FAILURE) {
            //record the name of the failed testcase
            extentLogger.fail(result.getName());
            // take screenshot and return location of the screenshot
            String screenshot = MainTools.getScreenshot(result.getName());
            extentLogger.addScreenCaptureFromPath(screenshot);
            // capture the exception
            extentLogger.fail(result.getThrowable());
            //
        } else if (result.getStatus() == ITestResult.SKIP){
            // sometime tests are skipped, this is how we log skipped tests
            extentLogger.skip("Test skipped: "+ result.getName());
        }
        Thread.sleep(1000);
        Driver.closeDriver();
    }


}
