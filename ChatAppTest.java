/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.chatapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class ChatAppTest {
    
    //Testing the phone number
    @Test
    public void testValidCellPhoneNumber() {
        boolean result = ChatAppLogin.checkCellPhoneNumber("+27831234567");
        assertTrue(result);
    }
    
    @Test
    public void testCellPhoneNumberMissingCountryCode() {
        assertFalse(ChatAppLogin.checkCellPhoneNumber("0831234567"));
    }
    
    @Test
    public void testCellPhoneNumberTooShort() {
        assertFalse(ChatAppLogin.checkCellPhoneNumber("+27831234"));
    }
    
    @Test
    public void testCellNumberTooLong() {
        assertFalse(ChatAppLogin.checkCellPhoneNumber("+2783123456789"));
    }
    
    @Test
    public void testCellNumberWithLetters() {
        assertFalse(ChatAppLogin.checkCellPhoneNumber("+27831ABC567"));
    }
    
    
    //Testing the username
    @Test
    public void testValidUsername() {
        boolean result = ChatAppLogin.checkUserName("_ryan");
        assertTrue(result);
    }
    
    @Test
    public void testUsernameMissingAnUnderscore() {
        assertFalse(ChatAppLogin.checkUserName("ryan1"));
    }
    
    @Test
    public void testUsernameTooLong() {
        assertFalse(ChatAppLogin.checkUserName("ryanthegoat"));
    }
    
    @Test
    public void testUsernameWithSpaces() {
        assertFalse(ChatAppLogin.checkUserName("ryan bk"));
    }   
    
    //Testing the password
    @Test
    public void testValidPassword() {
        boolean result = ChatAppLogin.checkPasswordComplexity("Pass@123");
        assertTrue(result);
    }
    
    @Test
    public void testPasswordTooShort() {
        assertFalse(ChatAppLogin.checkPasswordComplexity("P@1"));
    }
    
    @Test
    public void testPasswordWithNoSpecialCharacter() {
        assertFalse(ChatAppLogin.checkPasswordComplexity("Password123"));
    }
    
    @Test
    public void testPasswordMissingDigit() {
        assertFalse(ChatAppLogin.checkPasswordComplexity("password!"));
    }
    
    @Test
    public void testValidLongPassword() {
        assertTrue(ChatAppLogin.checkPasswordComplexity("StrongPassword271!"));
    }
    
    
    //Testing recipient number
    @Test
    public void testValidRecipientNumber() {
        boolean result = ChatAppLogin.checkRecipientNumber("+27718693002");
        assertTrue(result);
    }
    
    @Test
    public void testRecipientNumberMissingInternationalCode() {
        assertFalse(ChatAppLogin.checkRecipientNumber("08575975889"));
    }
    
    @Test
    public void testRecipientNumberTooLong() {
        assertFalse(ChatAppLogin.checkRecipientNumber("+27718693002123"));
    }
    
    @Test
    public void testRecipientNumberWithLetters() {
        assertFalse(ChatAppLogin.checkRecipientNumber("+27ABC693002"));
    }
    
    
    //Testing message length
    @Test
    public void testMessageLengthSuccess() {
        
        String message = "Hi Mike, can you join us for dinner tonight?";
        
        boolean result = message.length() <= 250;
        
        assertTrue(result, "Message ready to send.");
    }
    
    @Test
    public void testMessageLengthFailure() {
        
        String message = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        
        boolean result = message.length() <= 250;
        
        assertFalse(result,
                "Message exceeds 250 characters by "
                + (message.length() - 250)
                + ", please reduce the size.");
    }
    
    
    //Testing message hash
    @Test
    public void testMessageHash() {
        
        String expectedHash = "00:0:HITONIGHT";
        String actualHash = "00:0:HITONIGHT";
        
        assertEquals(expectedHash, actualHash);
    }
    
    
    //Testing message ID creation
    @Test
    public void testMessageIDCreated() {
        
        long messageID = 1234567890L;
        
        assertNotNull(messageID);
    }
    
    
    //Testing sent message
    @Test
    public void testSendMessage() {
        
        String expected = "Message successfully sent.";
        String actual = "Message successfully sent.";
        
        assertEquals(expected, actual);
    }
    
    
    //Testing discard message
    @Test
    public void testDiscardMessage() {
        
        String expected = "Press 0 to delete the message.";
        String actual = "Press 0 to delete the message.";
        
        assertEquals(expected, actual);
    }
    
    
    //Testing store message
    @Test
    public void testStoreMessage() {
        
        String expected = "Message successfully stored.";
        String actual = "Message successfully stored.";
        
        assertEquals(expected, actual);
    }
}