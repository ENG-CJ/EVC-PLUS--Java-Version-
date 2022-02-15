package com.evcplus;

import java.util.Scanner;

public class Evc implements Messages{
    // variables
    private final int pin;
    private final String code;
    private final int balance;



    // constructors and getters
    public Evc(){
        this.pin=2244;
        this.code="*770#";
        this.balance=200;
    }

    // getters methods
    public int getPin(){
        return pin;
    }

    public int getBalance() {
        return balance;
    }

    public String getCode() {
        return code;
    }

    // messages under this class
    public boolean error(int pinnumber, int pin){
        return pinnumber==pin;
    }

    public boolean error(String codeInput, String Code){
        return codeInput.equals(Code);
    }

    public void error(){
        System.out.println("Invalid Code NUMBER");
    }

    // Main method  Controlling our evc functionality
    public static void main(String[] args) {
        // initials
        Messages messages=new Evc();
        Evc evc=new Evc();

        // entry point (code)
      Scanner hormuud=new Scanner(System.in);
      System.out.print("");
      String code_number=hormuud.next();
      // checking entry point
      if (evc.error(code_number, evc.getCode())){
          System.out.print("Fadlan Geli Pin-kaaga: ");
          int pinNumber=hormuud.nextInt();
          if (evc.error(pinNumber, evc.getPin())){
              System.out.println("\n");
              System.out.println(
                      """
                      1. Itus Haraaga
                      2. Kaarka Hadalka
                      3. Bixi Biil
                      4. Uwareeji Evc-Plus
                      5. Warbixin Kooban
                      6. Salaam Bank
                      7. Mareynta 
                      8. Taaj
                      0. Kabax
                              
                      """
              );

              String selection=hormuud.next();
              // haraga option
              switch (selection) {
                  case "1" -> System.out.println("[EVC-PLUS]\nHaraagagu Waa $" + evc.getBalance());

                  // qeeybta kaarka hadalka
                  case "2" -> {
                      System.out.println("Kaarka Hadalka");
                      System.out.println("1. Kushubo Airtime");
                      System.out.println("2. Ugushub Airtime");
                      String kaarka_hadalka = hormuud.next();
                      // under kaarka hadalka
                      if (kaarka_hadalka.equals("1")) {
                          System.out.print("\nGeli Lacagta: ");
                          int currency = hormuud.nextInt();
                          System.out.println("Mahubtaa Inad Kushubato  $" + currency + "\n1. Haa\n2. Maya");
                          String ans = hormuud.next();
                          if (ans.equals("1")) {
                              if (currency <= evc.getBalance()) {
                                  System.out.println("[EVC-PLUS]\nWaxaa Kushubatay $" + currency
                                          + "\nHaragagu Waa $" + (evc.getBalance() - currency)
                                  );
                              } else {
                                  System.out.println("Haragagu Xisaabta Kuguma Filna! ");
                              }
                          } else if (ans.equals("2"))
                              System.out.println("Macsalama!");
                          else {
                              evc.error();
                          }


                      }// end number-1 kaarka hadalka
                      else if (kaarka_hadalka.equals("2")) {
                          System.out.print("Geli Mobile-ka Aad Lacagta Ugu Shubaysid: ");
                          int mobile = hormuud.nextInt();
                          // checking number
                          if (Validations.validMobile(mobile)) {
                              System.out.print("Geli Lacagta: ");
                              int currency = hormuud.nextInt();
                              System.out.println("Mahubtaa Inaad $" + currency +
                                      " Ugu Shubtid Number-ka " + mobile + "\n1. Haa\n2. Maya");
                              String ans = hormuud.next();

                              if (ans.equals("1")) {
                                  if (currency <= evc.getBalance()) {
                                      System.out.println("[EVC-PLUS]\nWaxaad $" + currency
                                              + " Ugu Shubtay Number-ka " + mobile +
                                              "\nHaragagu Waa $" + (evc.getBalance() - currency));
                                  } else
                                      System.out.println("Haragagu Xisaabta Kuguma Filna!");
                              } else if (ans.equals("2"))
                                  System.out.println("Macsalama!");
                              else
                                  evc.error();

                          } else
                              System.out.println(messages.errorMessage("Number-ka Aad Gelisay Ma ahan Mid Jira."));
                      }// end number-2 kaarka hadalk
                  }
                  // bixi Biil
                  case "3" -> {
                      BixiBiil.bixiBiil();
                      String select = hormuud.next();
                      if (select.equals("1"))
                          System.out.println( messages.infoMessage("This is Not Currently Working"));
                      else if (select.equals("2"))
                          System.out.println( messages.infoMessage("This is Not Currently Working"));
                      else
                          evc.error();
                  }

                  //uwareeji evc
                  case "4" -> {
                      System.out.println("Uwareeji Evc-Plus");
                      System.out.print("Fadlan Geli Mobile-ka: ");
                      int mobile = hormuud.nextInt();
                      if (Validations.validMobile(mobile)) {
                          System.out.print("Fadlan Geli Lacgta: ");
                          int currency = hormuud.nextInt();
                          System.out.println("Mahubtaa Inaad $" + currency + " Uwareejisid Number-ka " +
                                  +mobile + "\n1. Haa\n2. Maya");
                          String ans = hormuud.next();
                          if (ans.equals("1")) {
                              System.out.print("fadlan Geli Pin-kaaga: ");
                              int pin = hormuud.nextInt();
                              if (Validations.validPin(evc.getPin(),pin)){
                                  if (Validations.validBalance(currency,evc.getBalance())){
                                      System.out.println("[EVC-PLUS]\nWaxad $"+currency
                                      +" Uwarejisay Number-ka "+mobile+"\nHaragagu Waa $"
                                      +Validations.remainBalance(evc.getBalance(),currency));
                                  }else{
                                      System.out.println(messages.errorMessage("Haragagu Kuguma Filna!"));
                                  }
                              }else
                                  System.out.println(messages.errorMessage("Number-ka Sirta Waa Khalad"));
                          }

                      }else {
                          System.out.println(messages.errorMessage("Number-ka Aad Gelisay Ma aham Mid Jira."));
                      }
                  }

                  // case 5
                  case "5" ->{
                      WarbixinKoban.warbixinkooban();
                      String select=hormuud.next();
                      if (
                              select.equals("1")||
                              select.equals("2")||
                              select.equals("3")||
                              select.equals("4")||
                              select.equals("5")
                      ){
                          System.out.println(messages.infoMessage("This is Not currently Working"));
                      }
                  }
                  case "6"->SalamBank.salaamBankAccount();

                  case "7"-> Mareynta.maareeynta();

                  case "8"-> Taaj.taajAccount();
                  case "0"-> System.out.println(messages.infoMessage("Macsalama!"));


              }


          }// breaking condition pin
         else
              System.out.println("Pin-ka Aad Gelisay Waa Khalad");

      }

      // if its false this code will be executed
      else{

          System.out.println(messages.errorMessage("Sida Aad Isticmamashay Waa Khalad\nFadlan Isticmal *770#."));
      }
    }


    @Override
    public String errorMessage(String message) {
        return message;
    }

    @Override
    public String infoMessage(String message) {
        return message;
    }
}
