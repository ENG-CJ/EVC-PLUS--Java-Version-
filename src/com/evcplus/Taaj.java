package com.evcplus;

import java.util.Scanner;

// taaj class inherit evc and implement the functionality of interface class called Messages
public class Taaj extends  Evc implements Messages{
    static  Taaj taaj;
    static Evc evc;
    static  Messages messages;

    public static void taajAccount(){
        messages=new Taaj();
        taaj=new Taaj();

        System.out.println("Taaj");
        System.out.println("1. Dibadda\n2. Ogoow Khidmada\n3. Maclumadka Xawilaadda\n");
        Scanner hormuud=new Scanner(System.in);
        String selection=hormuud.next();
        switch (selection){
            case "1"->{
                System.out.print("Fadlan Geli Talefanka  Qaataha: ");
                String number=hormuud.next();

                System.out.print("Fadlan Geli Magaca Qaataha: ");
                String name=hormuud.next();

                System.out.print("Fadlan Geli Magaalada Qaataha Uujogo: ");
                String city=hormuud.next();

                System.out.print("Fadlan Geli Lacagta: ");
                int currency=hormuud.nextInt();

                System.out.print("Fadlan Geli Macluumad: ");
                String description=hormuud.next();

                System.out.println("Khidmada Ma Xisaabtada Ayaa Laga Jarayaa\n1. Haa\n2. Maya");
                String UserAns=hormuud.next();
                if (UserAns.equals("1")){
                    System.out.println("Mahubtaa Inaad $"+currency+" Udirtid "+
                            name+" Oo Wata Number-ka "+number+"\n1. Haa\n2. Maya");
                    String ans=hormuud.next();
                    if (ans.equals("1")){
                        int pin=hormuud.nextInt();
                        if(Validations.validPin(pin,taaj.getPin())){
                            if (Validations.validBalance(currency,taaj.getBalance())){
                                System.out.println("[TAAJ]");
                                System.out.println("Waxaad $"+currency+"Udirtay "
                                +name+" Oo Wata "+number+"\n"+
                                        "Haragagu Waa $"+Validations.remainBalance(taaj.getBalance(),currency));
                            }else{

                                System.out.println(messages.errorMessage("Haragagu Xisaabta Kuguma Filna!"));
                            }
                        }else
                            System.out.println(messages.errorMessage("Number-ka Sirta Waa Khalad"));
                    }else if(ans.equals("2")){
                        System.out.println("Macsalama");
                    }else
                        taaj.error();
                }else if(UserAns.equals("2"))
                    System.out.println("Program Terminated.");
                else
                    taaj.error();


            }

            case "2", "3" -> System.out.println(messages.infoMessage("this is Not Currently Working"));
            default -> taaj.error();

        }
    }
}
