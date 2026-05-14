/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;
import java.util.HashMap;
import java.util.Scanner;

public class ChatApp {

    // A HashMap stores all registered users.
    // the key is the username
    private static HashMap<String, String[]> userDatabase = new HashMap<>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

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
                System.out.println("The username is not correctly formatted. "
                        + "Please ensure that your username contains an underscore and is at least five characters in length.");
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
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            }
        }

        // Loop until a valid South African cell phone number is entered
        while (true) {
            System.out.print("Enter South African cell phone number (e.g., +27831234567): ");
            cellNumber = input.nextLine();

            if (ChatAppLogin.checkCellPhoneNumber(cellNumber)) {
                System.out.println("Cell phone number successfully added.");
                break;
            } else {
                System.out.println("Cell phone number is incorrect or does not contain an international code.");
            }
        }

        // this stores the users data in a HashMap after successful registration
        userDatabase.put(username, new String[]{password, lastName, firstName, cellNumber});
        System.out.println("You have successfully registered.");

        // this is the login section
        // The user gets 3 attempts to login
        System.out.println("\n--- LOGIN ---");

        boolean loggedIn = false;
        int     attempts = 0;

        while (attempts < 3) {
            System.out.print("Enter username: ");
            String loginUser = input.nextLine();

            System.out.print("Enter password: ");
            String loginPass = input.nextLine();

            if (userDatabase.containsKey(loginUser)) {
                String storedPassword = userDatabase.get(loginUser)[0];

                if (storedPassword.equals(loginPass)) {
                    System.out.println("Login successful. Welcome " + firstName + " " + lastName + "!");
                    loggedIn = true;
                    break;
                } else {
                    attempts++;
                    int remaining = 3 - attempts;
                    if (remaining > 0) {
                        System.out.println("Login failed. Incorrect password. "
                                + "You have " + remaining + " attempt(s) remaining.");
                    } else {
                        System.out.println("Login failed. You have exceeded the maximum number of attempts.");
                    }
                }
            } else {
                attempts++;
                int remaining = 3 - attempts;
                if (remaining > 0) {
                    System.out.println("Login failed. Username does not exist. "
                            + "You have " + remaining + " attempt(s) remaining.");
                } else {
                    System.out.println("Login failed. You have exceeded the maximum number of attempts.");
                }
            }
        }
        // Only allow messaging if login succeeded 
        if (!loggedIn) {
            System.out.println("Access denied. Exiting application.");
            input.close();
        }
        
    }
}
            