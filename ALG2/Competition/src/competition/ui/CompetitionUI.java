package competition.ui;

import competition.model.Competition;
import competition.utils.UnsetTimeException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author JV
 */
public class CompetitionUI {

    public static Scanner sc = new Scanner(System.in);
    public static Competition comp;
    public static File dataDirectory;

    public static void main(String[] args) throws IOException {
        comp = new Competition();
        String userDir = System.getProperty("user.dir");
        dataDirectory = new File(userDir + File.separator + "data");
        boolean end = false;

        try {
            while (!end) {

                displayMenu();
                System.out.println("Zadej volbu");
                String choice = sc.next();
                switch (choice) {
                    case "0":
                        System.out.println("Konec");
                        end = true;
                        break;
                    case "1":
                        try {
                            System.out.println("Zadej soubor registrace");
                            String registrationFile = sc.next();
                            comp.loadRegistration(new File(dataDirectory, registrationFile));

                        } catch (FileNotFoundException e) {
                            System.out.println("Zadali jste neexistujici soubor. Zkuste znova" + e.getMessage());
                        }
                        break;
                    case "2":
                        try {
                            System.out.println("Zadej soubor startu");
                            String startFile = sc.next();
                            comp.loadStart(new File(dataDirectory, startFile));
                        } catch (FileNotFoundException e) {
                            System.out.println("Zadali jste neexistujici soubor. Zkuste znova" + e.getMessage());
                        }catch(NoSuchElementException e){
                            System.out.println("Nezadali jste soubor registrace");
                        }
                        break;
                    case "3":
                        try {
                            System.out.println("Zadej soubor cile");
                            String finishFile = sc.next();
                            comp.loadFinish(new File(dataDirectory, finishFile));
                        } catch (FileNotFoundException e) {
                            System.out.println("Zadali jste neexistujici soubor. Zkuste znova" + e.getMessage());
                        }
                        break;
                    case "4":
                        try {
                            System.out.println(comp.getRunnersByRunningTime());
                        } catch (UnsetTimeException e) {
                            System.out.println("Neni nastaveny cas startu nebo cile");
                        }catch(NoSuchElementException e){
                            System.out.println("Nezadali jste soubor registrace");
                        }
                        break;
                    case "5":
                        System.out.println("Zadej soubor vysledku (bez pripony)");
                        String resultFile = sc.next();
                        comp.saveResultsToText(new File(dataDirectory, resultFile + ".txt"));
                        comp.saveResultsToBinary(new File(dataDirectory, resultFile + ".dat"));
                        break;
                    default:
                        System.out.println("Neplatná volba");
                }

            }
        } catch (IOException e) {
            //Logger.getLogger(CompetitionUI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Nastal problem" + e.getMessage());
        }


    }

    public static void displayMenu() {
        System.out.println("*****************************************************************");
        System.out.println("*        Prosím zadejte svoji volbu                             *");
        System.out.println("* 1.Načíst soubor registrace                                    *");
        System.out.println("* 2.Načíst soubor startu                                        *");
        System.out.println("* 3.Načíst soubor cíle                                          *");
        System.out.println("* 4.Zobrazit výsledkovou listinu                                *");
        System.out.println("* 5.Uložení výsledkové listiny do souboru                       *");
        System.out.println("* 0.Konec                                                       *");
        System.out.println("*****************************************************************");
    }

}
