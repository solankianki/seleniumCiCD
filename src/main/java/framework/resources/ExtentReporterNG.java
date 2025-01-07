package framework.resources;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject()
	{
		ExtentSparkReporter sparker = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"//reports//index.html"));
		sparker.config().setDocumentTitle("Test Results");
		sparker.config().setReportName("Web Automation Results");
		ExtentReports report = new ExtentReports();
		report.attachReporter(sparker);
		report.setSystemInfo("Tester", "Ankit Solanki");
		return report;
	}

}
