package _Dufek_Marathon;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Zadej pocet bezcu");
        int n = sc.nextInt();
        MarathonApp marathon=new MarathonApp(n);
        System.out.println("Zadej cislo bezce a hodiny, minuty a sekundy");
        for (int i = 0; i < n; i++) {
            marathon.pridejBezce(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

     
        
        System.out.println(marathon.BezciPodCasem(2*3600+7*60) + " bezci meli pod 2:07:00.");
        System.out.println("Nejrychlejsi bezec mel cislo " + marathon.cisloNejrychlejsiho()+".");
        System.out.format("Posledni bezec mel ztratu na prvniho %s.\n",marathon.ztrataPosledniho());
        System.out.format("Prumerny cas nejrychlejsiho bezce na 1 km byl %s.\n",marathon.prumernyCasNaKilometrNejrychlejsihoBezce());
        System.out.format("Prumerna rychlost nejrychlejsiho bezce byla %.2f km/h.\n",marathon.prumernaRychlostNejrychlejsiho());
    }
    
    /* testovaci vstup
5
1001 11 16 39
1002 11 21 48
1004 11 21 23
1012 11 23 46
1013 11 23 16
    */
}
