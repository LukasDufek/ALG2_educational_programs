package bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Lukáš
 */
public class BankApp {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String vys = "";
        Person pekar = new Person(sc.nextLine());
        Person svecova = new Person(sc.nextLine());
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

        ArrayList<Double> sumy = new ArrayList();

        for (Client c : klienti) {
            System.out.println(c.getJmeno() + ": " + c.celkovaSuma());
            sumy.add(c.celkovaSuma());

        }

        Collections.sort(sumy);
        for (int i = 0; i < sumy.size(); i++) {
            System.out.println(sumy.get(i).doubleValue());

        }

        ArrayList<String> prijmeni = new ArrayList();
        for (String string : prijmeni) {
            prijmeni.add(pekar.getJmeno());
            prijmeni.add(svecova.getJmeno());
            prijmeni.add(skoda.getJmeno());
        }

        prijmeni.sort(Comparator.naturalOrder());
        System.out.println(prijmeni);

    }

}
