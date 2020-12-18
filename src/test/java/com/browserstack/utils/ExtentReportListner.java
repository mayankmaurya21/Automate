package com.browserstack.utils;

import java.io.File;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReportListner  {
	
	// initialize the HtmlReporter
	public static ExtentHtmlReporter reports; 
	// create ExtentReports and attach reporter(s)
	public static ExtentReports extent; 
	 // creates a toggle for the given test, adds all log events under it 
	public static ExtentTest test;
	
	public static String resultpath = getResultPath();


	public static void deleteDirectory(File directory) {
		if (directory.exists()) {
			File[] files = directory.listFiles();
			if (null != files) {
				for (int i = 0; i < files.length; i++) {
					System.out.println(files[i].getName());
					if (files[i].isDirectory()) {
						deleteDirectory(files[i]);
					} else {
						files[i].delete();
					}
				}
			}
		}
	}

	private static String getResultPath() {

		resultpath = "test";//new SimpleDateFormat("yyyy-MM-dd hh-mm.ss").format(new Date());
		if (!new File(resultpath).isDirectory()) {
			new File(resultpath);
		}
		return resultpath;
	}

	public static void onTestStart(String reportName) {
		
		reports=new ExtentHtmlReporter("./"+reportName+".html");
		reports.config().setReportName("BrowserStackReport");

		extent= new ExtentReports();
		 extent.attachReporter(reports);
		
		
		
	}

	public void onTestPass(String sessionName) {
		test=extent.createTest(sessionName);
		test.log(Status.INFO, sessionName + "Started");
		test.pass(sessionName +"PASSED");

	}

	public void onTestFailure(String sessionName) {
		
		test=extent.createTest(sessionName);
		test.log(Status.INFO, sessionName + "Started");
		test.fail(sessionName +"FAILED");

	}

	public void onTestUnmarked(String sessionName) {
		test=extent.createTest(sessionName);
		test.log(Status.INFO, sessionName + "UNMARKED");
//		test.info("UNMARKED"); 
		test.log(Status.SKIP, "UNMARKED");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void updateTestInfo(String sessionName, String infoToUpdate) {
		
		test.log(Status.INFO, sessionName + infoToUpdate);


	}

	public static void onFinish() {
		
		extent.flush();

	}

	

}
