/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;
public class ChatAppLogin {

    // Instance variables
    private String username;
    private String password;
    private String cellNumber;
    private String firstName;
    private String lastName;

    // Validates username format
    public static boolean checkUserName(String username) {
        return username.contains("_") && username.length() < 6;
    }

    // Validates password complexity
    public static boolean checkPasswordComplexity(String password) {
        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*()].*");
        boolean isLongEnough = password.length() > 7;

        return hasUppercase && hasDigit && hasSpecialChar && isLongEnough;
    }

    // Validates South African cell number format
    public static boolean checkCellPhoneNumber(String cell) {
        return cell.matches("\\+27\\d{9}");
    }
    /**
     * Validates recipient cell number:
     * Must contain an international code and be no more than 10 characters
     * (after the '+' prefix). Accepts +27 followed by up to 9 digits.
     */
    public static boolean checkRecipientNumber(String cell) {
        // Must start with '+', have international code, and total <= 13 chars
        return cell.matches("\\+\\d{1,3}\\d{1,9}") && cell.length() <= 13;
    }
}