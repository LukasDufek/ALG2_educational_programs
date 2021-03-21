package _25_Dufek_Bus;

import java.util.Scanner;

public class BusApp {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Bus autobus = new Bus(41, 15, "DPMLJ");

        autobus.setPocetCestujicich(0);

        System.out.println("1.zastavka");
        System.out.println(autobus.toString());
        System.out.println("Zadej kolik lidi chce vystoupit a kolik nastoupit");
        autobus.setNechatVystoupitPocetCestujicich(sc.nextInt());
        autobus.setNechatNastoupitPocetCestujicich(sc.nextInt());
        System.out.println(autobus.toString());
        System.out.println("");

        System.out.println("2.zastavka");
        System.out.println(autobus.toString());
        System.out.println("Zadej kolik lidi chce vystoupit a kolik nastoupit");
        autobus.setNechatVystoupitPocetCestujicich(sc.nextInt());
        autobus.setNechatNastoupitPocetCestujicich(sc.nextInt());
        System.out.println(autobus.toString());
        
        
        
        
        
    }

}
