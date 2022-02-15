package com.evcplus;


import java.util.Scanner;

public class SalamBank extends Evc  implements Messages{
        static SalamBank salamBank;
        static Messages messages;
        static Evc evc;
    // Initial Object Using Evc(Salaam Bank)

    static void salaamBankAccount(){
        // initial object
        salamBank=new SalamBank();
        messages= new SalamBank();

        System.out.println("\n");
        System.out.println("Salam Bank");
        Scanner salam_bank=new Scanner(System.in);
        System.out.print("1. Kawareeji EVC-PLUS: ");
        String select=salam_bank.next();
        if (select.equals("1")){
            System.out.println("Fadlan Dooro Xisaabta Bangiga");
            System.out.print("1. Salam SOMALI BANK\n2. Salam SCH");
            String selected=salam_bank.next();
            if (selected.equals("1")){
                System.out.print("Fadlan Geli account-ga: ");
                String account=salam_bank.next();
                if (Validations.validMobile(account)){
                    System.out.print("Geli Faahfahin: ");
                    String faahfahin=salam_bank.next();
                    System.out.print("Fadlan Geli Lacagta: ");
                    int currency=salam_bank.nextInt();
                    System.out.println("[SALAAM BANK]\n");
                    System.out.print("Mahubtaa Inaad Kudirto $"+currency
                    +" Account-ga "+account+"\n1. Haa\n2. Maya");
                    String ans=salam_bank.next();
                    if (ans.equals("1")){
                        System.out.print("Fadlan Geli number-ka Sirta: ");
                        int pin=salam_bank.nextInt();
                        if (Validations.validPin(pin,salamBank.getPin())){
                            if(Validations.validBalance(currency,salamBank.getBalance())){
                                System.out.println("Waxaad $"+currency+ " Kudirtay Account ("+account+")"
                                +"\nHaragagu Waa $"
                                        +Validations.remainBalance(salamBank.getBalance(),currency));
                            }else
                                System.out.println(messages.errorMessage("Haragagu Kuguma Filna"));
                        }else
                            System.out.println(messages.errorMessage("Number-ka Sirta Waa Khalad."));
                    }else if(ans.equals("2")) {

                        System.out.println(messages.infoMessage("Macsalama!"));
                    }
                    else {

                        System.out.println(messages.errorMessage("Invalid Code Number"));
                    }



                }else{
                    System.out.println(messages.errorMessage("Account-ga Ma ahan Mid Jira"));
                }

            }else if (selected.equals("2")){
                System.out.println(messages.infoMessage("This is Not Currently Working"));
            }else
                salamBank.error();
        }
        else
           salamBank.error();




    }

}
