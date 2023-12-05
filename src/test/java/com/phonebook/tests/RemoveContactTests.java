package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebook.utils.ContactData;
import com.phonebook.utils.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    // precondition: User should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUserHelper().isLoginLinkPresent()) {
            app.getUserHelper().clickOnSignOutButton();
        }

        app.getUserHelper().clickOnLoginLink();
        app.getUserHelper().fillLoginRegisterForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUserHelper().clickOnLoginButton();

        app.getContactHelper().clickOnAddLink();

        app.getContactHelper().fillContactForm(new Contact()
                .setName(ContactData.NAME)
                .setLastName(ContactData.LAST_NAME)
                .setPhoneNumber(ContactData.ADDRESS)
                .setEmail(ContactData.EMAIL)
                .setAddress(ContactData.ADDRESS)
                .setDescription(ContactData.DESCRIPTION));

        app.getContactHelper().clickOnSaveButton();
    }
    @Test
    public void removeContactPositiveText() {
        // get size of contact before remove
        int sizeBefore = app.getContactHelper().sizeOfContacts();

        app.getContactHelper().removeContact();
        app.getContactHelper().pause(1000);
        // get size of contacts after remove
        int sizeAfter = app.getContactHelper().sizeOfContacts();
        // assert: Contact is removed by size
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }

}


















