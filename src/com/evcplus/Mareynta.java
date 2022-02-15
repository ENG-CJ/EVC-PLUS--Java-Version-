package com.evcplus;

import java.util.Scanner;

public class Mareynta extends  Evc implements Messages{
    public static   Mareynta mareynta;
    public  static  Messages messages;

    static void maareeynta(){
        // inital instance
        mareynta=new Mareynta();
        messages=new Mareynta();

        System.out.println("Maareynta");
        Scanner hormuud=new Scanner(System.in);
        System.out.print("1. Badel Lamarka Sirta\n2. Badel Luqadda\n3. Wargelin Mobile Lumay\n");
        String select=hormuud.next();
        switch (select){
            case "1" ->{
                System.out.print("Fadlan geli Pin-ka Cusub: ");
                int newPin= hormuud.nextInt();
                System.out.print("Fadlan Kuceli  Pin-ka Cusub: ");
                int confirmPin= hormuud.nextInt();
                if (Validations.confirmationValidation(newPin,confirmPin)){
                    System.out.print("Geli Number-kaaga Sirta ah: ");
                    int pin=hormuud.nextInt();
                    if(Validations.validPin(pin,mareynta.getPin())){
                        System.out.println("Waad Ku Guuleysaty Inaad Badasho \nNumber-ka Sirt AH");
                    }else
                        mareynta.error();
                }else {

                    System.out.println(messages.errorMessage("Isku Mid Ma ahan Pin-ka Aad Gelisay"));
                }


            }
            case "2"->{
                System.out.println("Luqqadda");
                System.out.println("1. English\n2. Arabic\n");
                String selected=hormuud.next();
                switch (selected){
                    case "1"-> System.out.println("Waad Ku Guuleysaty inaad Badasho Luuqadda");
                    case  "2"-> System.out.println("Waad Ku Guuleysaty inaad Badasho Luuqadda");
                    default -> mareynta.error();
                }

            }

            case  "3"->{
                System.out.print("Fadlan Geli Mobile-ka Lumay: ");
                int mobile=hormuud.nextInt();
                if (Validations.validMobile(mobile)){
                    System.out.print("Fadlan Geli Number-kisa Sirta: ");
                    int secretKey=hormuud.nextInt();
                    System.out.println(
                            "Mahubtaa Inaad udiwaan Geliso Number-kaan "+mobile
                            +" Inuu Lumay?\n1. Haa \n2.Maya\n"
                    );
                    String ans=hormuud.next();
                    if (ans.equals("1"))
                        System.out.println("Waad ku guuleysaty Inaad Udiwaan Geliso" +
                                " Number-kaan "+mobile+" Inuu Lumay");
                    else if (ans.equals("2"))
                        System.out.println("Macsalama!");
                }else{
                    System.out.println(messages.errorMessage("Number-kaan Ma Ahan Mid Jira"));
                }

            }
            default -> mareynta.error();
        }

    }
}
