package org.websolverpro.messagingapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Messages {
//    public static List<Message> messageList = List.of(new Message(1, 0, 1, "Good message 1"),
//            new Message(2, 0, 2, "Good message 2"),
//            new Message(3, 0, 3, "Good message 3"));

    public static List<Message> messageList = new ArrayList<>(
            Arrays.asList(
                    new Message(1, 0, 1, "Good message 1"),
                    new Message(2, 0, 2, "Good message 2"),
                    new Message(3, 0, 3, "Good message 3")
            )
    );

    public static void getMessageList() {
        messageList.forEach( message -> {
            System.out.println(message.toString());
        });
//        return messageToString;
    }

    public static void addMessage(Message message) {
        messageList.add(message);
        getMessageList();
//        List<Message> modMessages = new ArrayList<>(messageList);
//        modMessages.add(message);
//        modMessages.forEach( modMessage -> {
//            System.out.println(modMessage.toString());
//        });
    }
}
