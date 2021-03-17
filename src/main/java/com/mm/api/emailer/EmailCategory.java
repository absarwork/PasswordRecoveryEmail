/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mm.api.emailer;

/**
 * This enum represents status in different entities
 *
 * @author Adeel.Asghar
 *
 */
public enum EmailCategory {

    Account_Activation("Account Activation"),
    Account_Validation("Account Validation"),
    Password_Reset("Password Reset");

    public String val;

    // Constructor 
    EmailCategory(String v) {
        val = v;
    }

    public static EmailCategory getStatus(String value) {
        switch (value) {
            case "Account Activation":
                return EmailCategory.Account_Activation;
            case "Account Validation":
                return EmailCategory.Account_Validation;
            case "Password Reset":
                return EmailCategory.Password_Reset;
        }
        return null;
    }

}
