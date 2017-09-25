package com.epam.lab.report;

import com.epam.lab.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.infoMessage(iTestResult.getInstanceName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.infoMessage("success "+iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.infoMessage("failed "+iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.infoMessage("skipped "+iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.infoMessage("test failed but success percentage"+iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Log.infoMessage(iTestContext.toString());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Log.infoMessage(iTestContext.toString());
    }
}
