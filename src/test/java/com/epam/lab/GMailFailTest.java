package com.epam.lab;

import com.epam.lab.businessobject.GMailLogin;
import com.epam.lab.help.UserTestInfo;
import com.epam.lab.report.CustomListener;
import com.epam.lab.util.DriverConnectionUtil;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;

@Listeners({CustomListener.class, HTMLReporter.class})
public class GMailFailTest {

    @AfterSuite
    public void finish(){
        DriverConnectionUtil.close();
    }

    @Test
    public void failedTest(){
        GMailLogin loginPage = new GMailLogin();
        loginPage.loginInEmail(UserTestInfo.PASSWORD_ONE, UserTestInfo.PASSWORD_FIVE);
    }
}
