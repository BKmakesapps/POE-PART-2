/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java 
 */
package com.mycompany.chatapp;
import java.util.Random;

public class ChatAppMessages {

    // Stores all sent messages while the program runs
    private static String messages = "";

    // Stores total number of messages
    private static int totalMessages = 0;

    // Message attributes
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;
    private String status;

    // Constructor
    public ChatAppMessages(int messageNumber, String recipient, String messageText) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;

        // Generate random message ID
        this.messageID = generateMessageID();

        // Create message hash
        this.messageHash = createMessageHash();
    }

    // Generates a random message ID
    private String generateMessageID() {

        Random random = new Random();

        String id = "";

        for (int i = 0; i < 10; i++) {
            id += random.nextInt(10);
        }

        return id;
    }

    // Boolean: checkMessageID()
    // Ensures message ID is not more than 10 characters
    public boolean checkMessageID() {

        return messageID.length() <= 10;
    }

    // String: checkRecipientCell()
    // Ensures recipient number is valid
    public String checkRecipientCell() {

        if (recipient.length() <= 10 && recipient.startsWith("0")) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number incorrectly formatted.";
        }
    }

    // String: createMessageHash()
    // Creates and returns the message hash
    public String createMessageHash() {

        String[] words = messageText.split(" ");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        return messageNumber + ":" +
                messageID.substring(0, 2) +
                ":" + firstWord +lastWord;
    }

    // String: sentMessage()
    // This allows the user to choose to send/store/disregard
    public String sentMessage(String choice) {
        if (choice.equalsIgnoreCase("Send")) {
            status = "Sent";

            messages += "\n----------------------";
            messages += "\nMessage ID: " + messageID;
            messages += "\nMessage Hash: " + messageHash;
            messages += "\nRecipient: " + recipient;
            messages += "\nMessage: " + messageText;
            messages += "\nStatus: " + status;
            messages += "\n----------------------\n";

            totalMessages++;

            return "Message successfully sent.";

        } else if (choice.equalsIgnoreCase("Store")) {
            status = "Stored";

            messages += "\n----------------------";
            messages += "\nMessage ID: " + messageID;
            messages += "\nMessage Hash: " + messageHash;
            messages += "\nRecipient: " + recipient;
            messages += "\nMessage: " + messageText;
            messages += "\nStatus: " + status;
            messages += "\n----------------------\n";

            totalMessages++;

            return "Message successfully stored.";

        } else {
            status = "Disregarded";
            return "Message disregarded.";
        }
    }

    // String: printMessages()
    // Returns all sent messages
    public static String printMessages() {

        return messages;
    }

    // Int: returnTotalMessages()
    // Returns total number of messages sent
    public static int returnTotalMessages() {

        return totalMessages;
    }

    // Store message method
    // Simulates storing messages in JSON format
    public String storeMessage() {

        return "{"
                + "\"messageID\":\"" + messageID + "\","
                + "\"recipient\":\"" + recipient + "\","
                + "\"message\":\"" + messageText + "\","
                + "\"hash\":\"" + messageHash + "\","
                + "\"status\":\"" + status + "\""
                + "}";
    }

    // Checks message length
    public static boolean checkMessageLength(String message) {

        return message.length() <= 250;
    }

    // Set status
    public void setStatus(String status) {

        this.status = status;
    }

    // Prints message details
    public void printDetails() {

        System.out.println("\n========== MESSAGE ==========");
        System.out.println("Message Number: " + messageNumber);
        System.out.println("Message ID: " + messageID);
        System.out.println("Recipient: " + recipient);
        System.out.println("Message: " + messageText);
        System.out.println("Message Hash: " + messageHash);
        System.out.println("Status: " + status);
    }
}