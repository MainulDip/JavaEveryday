package org.websolverpro.messagingapp;

import java.util.Scanner;

/**
 * Simulate your phone's contacts and messages applications
 *
 * Greet the user
 * show 3 options: 1. Manage Contacts 2. Messages 3. Quit
 * when selecting 1 ==> show options
 *  1. Show all contacts
 *  2. Add a new contact
 *  3. Search for a contact
 *  4. Delete a contact
 *  5. Go back to the previous menu
 *
 * when selecting 2 ==> show options
 *  1. See the list of all messages
 *  2. Send a new message
 *  3. Go back to the previous menu
 *
 * when selection 3 ==> Quit the application
 */

public class MessagingApp {
    public static void main(String[] args) {

        System.out.println("Good to see you \nPlease Select and Enter the Number \n 1. Manage Contacts 2. Messages 3. Quit\n");

        Scanner scanner = new Scanner(System.in);

        int firstFace = scanner.nextInt();

        switch (firstFace){
            case 1 :
                System.out.println("You have chosen 1, now select newt option please");

                System.out.println("1. Show all contacts\n" +
                        "2. Add a new contact\n" +
                        "3. Search for a contact\n" +
                        "4. Delete a contact\n" +
                        "5. Go back to the previous menu\n");

                int contactInfoSelect = scanner.nextInt();

                switch (contactInfoSelect) {
                    case 1 :
                        System.out.println("Show All Contacts");

                        break;
                    case 2 :
                        System.out.println("Add a new contact");
                        break;
                    case 3 :
                        System.out.println("Search For a contact");
                        break;
                    case 4:
                        System.out.println("Delete a contact");
                        break;
                    default:
                        System.out.println("Go back to the previous menu");
                        break;
                }
                break;

            case 2 :
                System.out.println("You have chosen 2, now select newt option please");

                System.out.println("1. See the list of all messages\n" +
                        "2. Send a new message\n" +
                        "3. Go back to the previous menu\n");

                int messageOptionSelect = scanner.nextInt();

                switch (messageOptionSelect) {
                    case 1 :
                        System.out.println("Show All Messages");
                        System.out.println(Messages.getMessageList());
                        break;
                    case 2 :
                        System.out.println("Send a new message");
                        Messages.addMessage(new Message(1, 1, 1, "Good"));
                        break;
                    default:
                        System.out.println("Go back to the previous menu");
                        break;
                }

                break;

            default:
                System.out.println("You have chosen to quit the application");
                break;


        }


    }
}
