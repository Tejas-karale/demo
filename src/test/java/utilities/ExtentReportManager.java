	package utilities;
	
	import java.awt.Desktop;
	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	
	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;
	
	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;
	
	import testBase.BaseClass;
	
	public class ExtentReportManager implements ITestListener {
	    public ExtentSparkReporter sparkReporter;
	    public ExtentReports extent;
	    public ExtentTest test;
	
	    String repName;
	
	    public void onStart(ITestContext testContext) {
	        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	        repName = "Test-Report-" + timeStamp + ".html";
	        sparkReporter = new ExtentSparkReporter("./reports/" + repName);
	
	        sparkReporter.config().setDocumentTitle("AE Automation Report");
	        sparkReporter.config().setReportName("AE Functional Testing");
	        sparkReporter.config().setTheme(Theme.DARK);
	
	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);
	        extent.setSystemInfo("Application", "AE Automation");
	        extent.setSystemInfo("Module", "Admin");
	        extent.setSystemInfo("Sub Module", "Customers");
	
	        String os = testContext.getCurrentXmlTest().getParameter("os");
	        String browser = testContext.getCurrentXmlTest().getParameter("browser");
	
	        extent.setSystemInfo("Operating System", os);
	        extent.setSystemInfo("Browser", browser);
	    }
	
	    public void onTestSuccess(ITestResult result) {
	        test = extent.createTest(result.getTestClass().getName() + " :: " + result.getMethod().getMethodName());
	        test.assignCategory(result.getMethod().getGroups());
	        test.log(Status.PASS, result.getName() + " got successfully executed");
	    }
	
	    public void onTestFailure(ITestResult result) {
	        test = extent.createTest(result.getTestClass().getName() + " :: " + result.getMethod().getMethodName());
	        test.assignCategory(result.getMethod().getGroups());
	        test.log(Status.FAIL, result.getName() + " got failed");
	        test.log(Status.INFO, result.getThrowable().getMessage());
	
	        try {
	            String imgPath = new BaseClass().captureScreen(result.getName());
	            test.addScreenCaptureFromPath(imgPath);
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
	    }
	
	    public void onTestSkipped(ITestResult result) {
	        test = extent.createTest(result.getTestClass().getName() + " :: " + result.getMethod().getMethodName());
	        test.assignCategory(result.getMethod().getGroups());
	        test.log(Status.SKIP, result.getName() + " got skipped");
	        if (result.getThrowable() != null) {
	            test.log(Status.INFO, result.getThrowable().getMessage());
	        }
	    }
	
	    public void onFinish(ITestContext testContext) {
	        extent.flush();
	
	        String pathOfExtentReport = System.getProperty("user.dir") + "/reports/" + repName;
	        File extentReport = new File(pathOfExtentReport);
	
	        try {
	            if (extentReport.exists()) {
	                Desktop.getDesktop().browse(extentReport.toURI());
	                System.out.println("Extent Report generated at: " + pathOfExtentReport);
	            } else {
	                System.out.println("Extent report file not found: " + pathOfExtentReport);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
