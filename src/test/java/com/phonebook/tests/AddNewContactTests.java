package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebook.utils.ContactData;
import com.phonebook.utils.DataProviders;
import com.phonebook.utils.UserData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddNewContactTests extends TestBase {

//    @BeforeClass
//    public void beforeClass() {
//        System.out.println("***********************Before Class!");
//    }
//
//    @AfterClass
//    public void afterClass() {
//        System.out.println("***********************After Class!");
//    }

    // precondition: User logged out
    @BeforeMethod
    public void ensurePrecondition() {
//        System.out.println("*********************************Before Method!");
        if (!app.getUserHelper().isLoginLinkPresent()) {
            app.getUserHelper().clickOnSignOutButton();
        }

        app.getUserHelper().clickOnLoginLink();
        app.getUserHelper().fillLoginRegisterForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUserHelper().clickOnLoginButton();
    }

    @Test
    public void addNewContactPositiveTest() {

        app.getContactHelper().clickOnAddLink();

        app.getContactHelper().fillContactForm(new Contact()
                .setName(ContactData.NAME)
                .setLastName(ContactData.LAST_NAME)
                .setPhoneNumber(ContactData.ADDRESS)
                .setEmail(ContactData.EMAIL)
                .setAddress(ContactData.ADDRESS)
                .setDescription(ContactData.DESCRIPTION));

        app.getContactHelper().clickOnSaveButton();

        Assert.assertTrue(app.getContactHelper().isContactCreatedByText(ContactData.NAME));
    }

    @AfterMethod
    public void postCondition() {
        app.getContactHelper().removeContact();
    }

    @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class)
    public void addNewContactFromDataProviderPositiveTest(String name, String lastname, String phoneNumber,
                                                          String email, String address, String description) {

        app.getContactHelper().clickOnAddLink();

        app.getContactHelper().fillContactForm(new Contact()
                .setName(name)
                .setLastName(lastname)
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setAddress(address)
                .setDescription(description));

        app.getContactHelper().clickOnSaveButton();

    }


    @Test(dataProvider = "addNewContactFromCSV", dataProviderClass = DataProviders.class)
    public void addNewContactFromDataProviderCSVPositiveTest(Contact contact) {

        app.getContactHelper().clickOnAddLink();

        app.getContactHelper().fillContactForm(contact);

        app.getContactHelper().clickOnSaveButton();

    }

}
