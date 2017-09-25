package com.epam.lab;

import com.epam.lab.businessobject.GMailBox;
import com.epam.lab.businessobject.GMailLogin;
import com.epam.lab.help.UserTestInfo;
import com.epam.lab.model.GMailLetter;
import com.epam.lab.report.CustomListener;
import com.epam.lab.util.DriverConnectionUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.uncommons.reportng.HTMLReporter;

import javax.jws.soap.SOAPBinding;

@Listeners({CustomListener.class, HTMLReporter.class})
public class GMailTest {

    @DataProvider(name = "UserInfo", parallel = true)
    public static Object[][] credentials(){
        FileReadXls readXls = new FileReadXls();
        return readXls.toArray();
    }

    @AfterMethod
    public void finish() {
        DriverConnectionUtil.close();
    }

    @Test(dataProvider = "UserInfo")
    public void mailTest(String login, String password){
        GMailLogin loginPage = new GMailLogin();
        GMailBox mailBox = new GMailBox();

        loginPage.loginInEmail(login,password);
        mailBox.composeLetter(UserTestInfo.TO,UserTestInfo.CC,
                UserTestInfo.BCC,UserTestInfo.SUBJECT,UserTestInfo.TEXT);

        GMailLetter letterUser = mailBox.getDraftLetter();

        Assert.assertEquals(UserTestInfo.TO,letterUser.getTo());
        Assert.assertEquals(UserTestInfo.CC,letterUser.getCc());
        Assert.assertEquals(UserTestInfo.BCC,letterUser.getBcc());
        Assert.assertEquals(UserTestInfo.SUBJECT,letterUser.getSubject());
        Assert.assertEquals(UserTestInfo.TEXT,letterUser.getText());

        mailBox.send();
    }
}
