package com.mycompany.chatapp; 

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class ChatApp {

    // A HashMap stores all registered users.
    // the key is the username
    private static HashMap<String, String[]> userDatabase = new HashMap<>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Stores all sent messages
        ArrayList<ChatAppMessages> sentMessages = new ArrayList<>();

        // Ask for the user's first name
        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();

        // Ask for the user's last name
        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();

        String username = "";
        String password = "";
        String cellNumber = "";

        // This will loop until a valid username is entered
        while (true) {

            System.out.print("Create a UserName: ");
            username = input.nextLine();

            if (ChatAppLogin.checkUserName(username)) {
                System.out.println("Username has been successfully captured.");
                break;
            } else {
                System.out.println("Invalid username format.");
            }
        }

        // This will loop until a valid password is entered
        while (true) {

            System.out.print("Enter password: ");
            password = input.nextLine();

            if (ChatAppLogin.checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Invalid password format.");
            }
        }

        // Loop until a valid South African cell phone number is entered
        while (true) {

            System.out.print("Enter South African cell phone number: ");
            cellNumber = input.nextLine();

            if (ChatAppLogin.checkCellPhoneNumber(cellNumber)) {
                System.out.println("Cell phone number successfully added.");
                break;
            } else {
                System.out.println("Invalid cell phone number.");
            }
        }

        // this stores the users data in a HashMap after successful registration
        userDatabase.put(username, new String[]{password, lastName, firstName, cellNumber});

        System.out.println("You have successfully registered.");

        // this is the login section
        // The user gets 3 attempts to login
        boolean loggedIn = false;
        int attempts = 0;

        System.out.println("\n--- LOGIN ---");

        while (attempts < 3) {

            System.out.print("Enter username: ");
            String loginUser = input.nextLine();

            System.out.print("Enter password: ");
            String loginPass = input.nextLine();

            if (userDatabase.containsKey(loginUser)
                    && userDatabase.get(loginUser)[0].equals(loginPass)) {

                System.out.println("Login successful. Welcome " + firstName + " " + lastName + "!");
                loggedIn = true;
                break;

            } else {
                attempts++;
                System.out.println("Login failed. Attempts left: " + (3 - attempts));
            }
        }

        // Only allow messaging if the login succeeded
        if (!loggedIn) {

            System.out.println("Access denied.");
            return;
        }

        // THE MAIN MENU LOOP
        int maxMessages = 0;

        while (true) {

            System.out.println("\n========== MENU ==========");
            System.out.println("1) Send Message");
            System.out.println("2) Show Sent Messages");
            System.out.println("3) Quit");

            System.out.print("Choose option: ");
            String choice = input.nextLine();

            // Option 1: Send Messages
            if (choice.equals("1")) {

                // Ask how many messages the user wants to send
                if (maxMessages == 0) {

                    while (true) {
                        System.out.print("How many messages would you like to send? ");
                        try {
                            maxMessages = Integer.parseInt(input.nextLine());
                            if (maxMessages > 0) break;
                        } catch (Exception e) {
                            System.out.println("Enter a valid number.");
                        }
                    }
                }

                // Check if user reached the message limit
                if (sentMessages.size() >= maxMessages) {
                    System.out.println("Message limit reached.");
                    continue;
                }

                String recipient;

                // Ask until valid number is entered
                while (true) {

                    System.out.print("Enter recipient number: ");
                    recipient = input.nextLine();

                    if (ChatAppLogin.checkRecipientNumber(recipient)) {
                        break;
                    }

                    System.out.println("Invalid recipient number.");
                }

                System.out.print("Enter message (max 250 characters): ");
                String messageText = input.nextLine();

                if (!ChatAppMessages.checkMessageLength(messageText)) {
                    System.out.println("Message too long.");
                    continue;
                }

                ChatAppMessages msg =
                        new ChatAppMessages(sentMessages.size() + 1, recipient, messageText);

                System.out.println("\n1) Send");
                System.out.println("2) Discard");
                System.out.println("3) Store");

                System.out.print("Choose: ");
                String action = input.nextLine();

                if (action.equals("1")) {

                    msg.setStatus("Sent");
                    sentMessages.add(msg);
                    System.out.println("Message sent successfully.");
                    msg.printDetails();

                } else if (action.equals("2")) {

                    msg.setStatus("Discarded");
                    System.out.println("Message discarded.");

                } else if (action.equals("3")) {

                    msg.setStatus("Stored");
                    sentMessages.add(msg);
                    System.out.println("Message stored.");

                } else {

                    System.out.println("Invalid option.");
                }
            }

            // Option 2
            else if (choice.equals("2")) {

                System.out.println("Show Sent Messages");

                if (sentMessages.isEmpty()) {
                    System.out.println("No messages sent yet.");
                } else {
                    for (ChatAppMessages m : sentMessages) {
                        m.printDetails();
                    }
                }
            }

            // Option 3
            else if (choice.equals("3")) {

                System.out.println("Goodbye!");
                break;
            }

            // Invalid option
            else {

                System.out.println("Invalid option.");
            }
        }

        input.close();
    }
}