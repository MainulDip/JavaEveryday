package org.websolverpro.messagingapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactList {
    public static List<Contact> contactList = new ArrayList<>(
            Arrays.asList(new Contact(1, "Contact one", 1234567),
                    new Contact(2, "Contact two", 234567),
                    new Contact(3, "Contact three", 3456789))
    );

    public static void getContactList() {
        contactList.forEach( contact -> {
            System.out.println(contact.toString());
        });
    }

    public static void addContact(Contact contact) {
        contactList.add(contact);
        getContactList();
        System.out.println("new contact added");
    }

    public static void searchContact(String name) {
        contactList.forEach(contact -> {
            if (contact.getName() == name ) {
                System.out.println(contact.toString());
            }
        });
    }

    public static void deleteContact(String name) {
        List<Contact> contactDeleteCollection = new ArrayList<>();
        contactList.forEach(contact -> {
            if (contact.getName() == name ) {
//                contactList.remove(contact);
                contactDeleteCollection.add(contact);
                System.out.println("Deleted contact: " + contact.toString());
            }
        });
        contactList.removeAll(contactDeleteCollection);
        System.out.println("\n\n ContactList after deletion: \n");
        getContactList();
    }
}
