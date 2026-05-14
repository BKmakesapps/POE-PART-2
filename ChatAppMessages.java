/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

import java.util.Random;

public class ChatAppMessages {

    // Stores the unique message ID
    private long messageID;

    // Stores the message number
    private int messageNumber;

    // Stores the recipient phone number
    private String recipient;

    // Stores the actual message text
    private String messageText;

    // Stores the generated message hash
    private String messageHash;

    // Stores the message status
    private String status;

    // Constructor used to create a new message
    public ChatAppMessages(int messageNumber,
            String recipient,
            String messageText) {

        this.messageID = generateMessageID();

        this.messageNumber = messageNumber;

        this.recipient = recipient;

        this.messageText = messageText;

        // Generate the message hash
        this.messageHash = createMessageHash();

        // Set default status
        this.status = "Sent";
    }

    // Generates a random 10-digit message ID
    private long generateMessageID() {

        Random rand = new Random();

        return 1000000000L
                + (long) (rand.nextDouble() * 9000000000L);
    }

    // Creates the message hash
    private String createMessageHash() {

        // Get first 2 digits from message ID
        String firstTwo =
                String.valueOf(messageID).substring(0, 2);

        // Split message into words
        String[] words = messageText.split(" ");

        // Get first word
        String firstWord = words[0];

        // Get last word
        String lastWord = words[words.length - 1];

        // Return full hash
        return (firstTwo + ":" + messageNumber + ":"+ firstWord + lastWord).toUpperCase();
    }

    // Checks if message is less than 250 characters
    public static boolean checkMessageLength(String text) {

        return text.length() <= 250;
    }

    // Displays message details
    public void printDetails() {

        System.out.println("\n----- MESSAGE DETAILS -----");

        System.out.println("Message ID: " + messageID);

        System.out.println("Message Hash: " + messageHash);

        System.out.println("Recipient: " + recipient);

        System.out.println("Message: " + messageText);

        System.out.println("Status: " + status);

    }

    // Returns the current message status
    public String getStatus() {

        return status;
    }

    // Updates the message status
    public void setStatus(String status) {

        this.status = status;
    }
}