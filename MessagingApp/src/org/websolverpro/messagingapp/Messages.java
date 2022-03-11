package org.websolverpro.messagingapp;

import java.util.List;

public class Messages {
    public static List<Message> messageList;

    public static List<Message> getMessageList() {
        return messageList;
    }

    public static void addMessage(Message message) {
        messageList.add(message);
    }
}
