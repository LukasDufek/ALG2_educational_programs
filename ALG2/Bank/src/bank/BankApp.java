package bank;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Lukáš
 */
public class BankApp {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String vys = "";
        System.out.println("Zadej přijmení");
        Person pekar = new Person(sc.nextLine());
        System.out.println("Zadej přijmení");
        Person svecova = new Person(sc.nextLine());
        System.out.println("Zadej přijmení");
        Company skoda = new Company(sc.nextLine());

        ArrayList<Client> klienti = new ArrayList();
        klienti.add(pekar);
        klienti.add(svecova);
        klienti.add(skoda);

        //Pekarovi pridame jeden ucet s vkladem 1000 a druhy s vkladem 500
        pekar.pridejUcet(1000);
        pekar.pridejUcet(500);
        svecova.pridejUcet(1200);
        skoda.pridejUcet(120);

        
        System.out.println("Seřazení podle sumy");
        
        Collections.sort(klienti); //compareTo
        System.out.println(zobrazeni(klienti));
        
        System.out.println("Seřazení podle přijmení");
         seradPodlePrijmeni(klienti);
         System.out.println(zobrazeni(klienti));
        
       
    }
    
    
    public static String zobrazeni(ArrayList array) {
        StringBuilder sb = new StringBuilder();
        for (Object o : array) {
            sb.append(o + "\n");
            //
        }

        return sb.toString();

    }
    
    public static void seradPodlePrijmeni(ArrayList<Client> klienti) { //annonymni trida
        Collections.sort(klienti, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                Collator col = Collator.getInstance(new Locale("cs", "CZ")); //kvuli prijmenim jako napr: Šimon
                return col.compare(o1.getJmeno(), o2.getJmeno());
            }
        });
    }
    
    

}
