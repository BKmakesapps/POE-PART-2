/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;
import java.util.Scanner;


public class ChatApp {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask for the user's first name
        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();

        // Ask for the user's last name
        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();

        // this will loop until a valid username is entered
        while (true) {
            System.out.print("Enter username: ");
            String username = input.nextLine();
            
            if (ChatAppLogin.checkUserName(username)){
                System.out.println("Username has been successfully captured.");
                break;
                } else {
                System.out.println("The username is not correctly formatted. "
                        + "Please ensure that your username contains an underscore and is at least five characters in length.");
            }
        }

           
        // this will loop until a valid password is entered
        while (true) {
            System.out.print("Enter password: ");
            String password = input.nextLine();

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
            String cellNumber = input.nextLine();

            // Must start with +27 and be followed by exactly 9 digits
            if (ChatAppLogin.checkCellPhoneNumber(cellNumber)) {
                System.out.println("Cell phone number successfully added.");
                break;
            } else {
                System.out.println("Cell phone number incorrectly formatted or does not contain long international code.");
            }
        }
    }
    
}
            