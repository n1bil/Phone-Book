package com.phonebook.utils;

import com.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public static Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Kan", "+12345678990", "kan@gmail.com", "Berlin", "goalkeeper"});
        list.add(new Object[]{"Oliver1", "Kan", "+12345678991", "kan1@gmail.com", "Berlin", "goalkeeper"});
        list.add(new Object[]{"Oliver2", "Kan", "+12345678992", "kan2@gmail.com", "Berlin", "goalkeeper"});

        return list.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> addNewContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.csv"));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");

            list.add(new Object[]{new Contact().setName(split[0]).setLastName(split[1]).setPhoneNumber(split[2])
                    .setEmail(split[3]).setAddress(split[4]).setDescription(split[5])});

            line = reader.readLine();
        }
        return list.iterator();
    }
}
