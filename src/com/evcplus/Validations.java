package com.evcplus;

public class Validations {
    static  boolean validPin(int pin, int InputPin){
        return pin==InputPin;
    }
    static  boolean validBalance(int currency, int balance){
        return currency<=balance;
    }
    static int remainBalance(int balance, int currency){
        return balance-currency;
    }

    static boolean validMobile(int mobile){
        return mobile>=610000000 && mobile<=619999999;
    }
    static boolean validMobile( String account){
        return account.length()>6 && account.length()<=8;
    }
    static  boolean confirmationValidation(int firstPin, int secondPin){
        return firstPin==secondPin;
    }
}
