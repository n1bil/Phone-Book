package com.phonebook.tests;

import com.phonebook.models.User;
import com.phonebook.utils.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUserHelper().isLoginLinkPresent()) {
            app.getUserHelper().clickOnSignOutButton();
        }
    }

    @Test
    public void registerExistedUserNegativeTest() {

        app.getUserHelper().clickOnLoginLink();

        app.getUserHelper().fillLoginRegisterForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));

        app.getUserHelper().clickOnRegistrationButton();

        Assert.assertTrue(app.getUserHelper().isAlertPresent());
    }

}
