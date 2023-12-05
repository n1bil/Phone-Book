package com.phonebook.tests;

import com.phonebook.models.User;
import com.phonebook.utils.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUserHelper().isLoginLinkPresent()) {
            app.getUserHelper().clickOnSignOutButton();
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() {

        app.getUserHelper().clickOnLoginLink();

        app.getUserHelper().fillLoginRegisterForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));

        app.getUserHelper().clickOnLoginButton();

        Assert.assertTrue(app.getUserHelper().isSignOutButtonPresent());
    }

    @Test
    public void loginRegisteredUserNegativeTestWithoutEmail() {

        app.getUserHelper().clickOnLoginLink();

        app.getUserHelper().fillLoginRegisterForm(new User().setPassword(UserData.PASSWORD));

        app.getUserHelper().clickOnLoginButton();

        Assert.assertTrue(app.getUserHelper().isAlertPresent());
    }

}
