package _25_Dufek_Bus;

import java.util.Scanner;

public class BusApp {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Bus autobus = new Bus(41, 15, "DPMLJ");

        autobus.setPocetCestujicich(0);

        
        for (int i = 1; i < 5; i++) {
            System.out.println(i+".zastavka");
        System.out.println(autobus.toString());
        System.out.println("Zadej kolik lidi chce vystoupit a kolik nastoupit");
        autobus.nechatVystoupitPocetCestujicich(sc.nextInt());
        autobus.nechatNastoupitPocetCestujicich(sc.nextInt());
        System.out.println(autobus.toString());
        System.out.println("");
        }

        
        System.out.println("5.zastavka. Konecna");
        System.out.println(autobus.toString());
        System.out.println("Zadej kolik lidi chce vystoupit a kolik nastoupit");
        autobus.nechatVystoupitPocetCestujicich(sc.nextInt());
        autobus.nechatNastoupitPocetCestujicich(sc.nextInt());
        System.out.println(autobus.toString());
        System.out.println("");
        
        autobus.vystupVsichni();
         System.out.println(autobus.toString());
        
        
        
        
        
    }

}
