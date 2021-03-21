package _Dufek_Marathon;

import java.util.Scanner;

public class MarathonApp {

    public static final int zacatek = (9 * 3600) + (15 * 60); //v sekundach
    private static final int draha = 42195; //v metrech

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Zadej pocet bezcu");
        int n = sc.nextInt();

        int[][] bezci = new int[n][5];

        for (int i = 0; i < bezci.length; i++) {
            bezci[i][0] = sc.nextInt();
            bezci[i][1] = sc.nextInt();
            bezci[i][2] = sc.nextInt();
            bezci[i][3] = sc.nextInt();
            bezci[i][4] = Bezec.getDobaBehu(bezci[i][1], bezci[i][2], bezci[i][3], zacatek);

        }

        Bezci bb = new Bezci(bezci);


    //1) kolik bezcu melo pod 2:07:00
        int kontrolniCas = 2 * 3600 + 7 * 60; //v sekundach
        int pocetBezcu = 0;
    
        for (int i = 0; i < bezci.length; i++) {
            if (bezci[i][4] < kontrolniCas) {
                pocetBezcu++;
            }
        }

        System.out.println(pocetBezcu + " bezci meli pod 2:07:00.");

        
    //2) cislo nejrychlejsiho bezce  
        int prvni = Integer.MAX_VALUE;
        int posledni = Integer.MIN_VALUE;
        int cisloPrvniho = 0;

        for (int i = 0; i < bezci.length; i++) {
            if (bezci[i][4] < prvni) {

                prvni = bezci[i][4];
                cisloPrvniho = bezci[i][0];

            }
            //hledani posledniho
            if (bezci[i][4] > posledni) {
                posledni = bezci[i][4];

            }

        }
        
        
        System.out.println("Nejrychlejsi bezec mel cislo " + cisloPrvniho+".");

    //3) ztrata posledniho bezce
        posledni = posledni - prvni;
        int hh = posledni / 3600;
        int mm = (posledni % 3600) / 60;
        int ss = (posledni % 3600) % 60;
        System.out.format("Posledni bezec mel ztratu na prvniho %02d:%02d:%02d.", hh, mm, ss);
        System.out.println("");

   //4) prumerny cas na kilometr nejryclhejsiho
        double drahaD = draha;
        double prvniD = prvni;
        double prumernyCas = (prvniD) / (drahaD / 1000); 
        double h = prumernyCas/3600;
        double m = Math.floor((prumernyCas%3600)/60);
        double s = (prumernyCas%3600)%60;
        
        System.out.format("Prumerny cas nejrychlejsiho bezce na 1 km byl %.0f:%.0f.", m, s);
        System.out.println("");
        
    //5) prumerna rychlost nejrychlejsiho bezce
        double rychlostPrvniho = (drahaD / prvniD) * 3.6;
        System.out.format("Prumerna rychlost nejrychlejsiho bezce byla %.2f km/h  ", rychlostPrvniho);
        System.out.println("");


}
    
    
    
    
}
