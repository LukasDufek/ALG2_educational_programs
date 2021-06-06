package competition.model;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import static competition.model.Competition.dtfDate;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 *
 * @author JV
 */
public class Competition {

    public static DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("M/d/yyyy");
    public static DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("H:mm:ss.S");
    private List<Runner> runners;

    public Competition() {
        runners = new ArrayList<>();
    }

    //nacteni s vyuzitim BufferedReader
    //textovy soubor typu csv (comma separated values) se zahlavim s daty na radcich s oddelovacim znakem carka
    public void loadRegistration(File filename) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int number;
            LocalDate born;
            String firstName, lastName, club, nationality;
            char gender;
            Runner r;
            br.readLine(); //preskoceni zahlavi
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); //32,Mala Alice,F,3/21/1999,Silvini,CZE
                number = Integer.parseInt(parts[0]);
                gender = parts[2].charAt(0);
                born = LocalDate.parse(parts[3], dtfDate);
                club = parts[4];
                nationality = parts[5];
                String[] firstLast = parts[1].split(" ");
                firstName = firstLast[1];
                lastName = firstLast[0];
                r = new Runner(firstName, lastName, gender, born, club, nationality, number);
                runners.add(r);
            }
        }
    }

    /* pomoci vlastni vseobecne tridy, ktera "jakykoliv" textovy soubor a vrati jej jako list poli Stringu
    public void loadRegistration(File filename, String regexSeparator, boolean header) throws FileNotFoundException, IOException {
            TextFileReader in = new TextFileReader();
            List<String[]> data = in.readFile(filename, regexSeparator, header);
            registrationDataToRunners(data);    
    }
    
    private void registrationDataToRunners(List<String[]> data){
        int number;
            LocalDate born;
            String firstName, lastName, club, nationality;
            char gender;
            Runner r;
            for (String[] parts : data) { //|32|Mala Alice|F|3/21/1999|Silvini|CZE|
                number = Integer.parseInt(parts[0]);
                gender = parts[2].charAt(0);
                born = LocalDate.parse(parts[3], dtfDate);
                club = parts[4];
                nationality = parts[5];
                String[] firstLast = parts[1].split(" ");
                firstName = firstLast[1];
                lastName = firstLast[0];
                r = new Runner(firstName, lastName, gender, born, club, nationality, number);
                runners.add(r);
            }
    }*/
    public void setMassStartTime(int hours, int minutes) {
        for (Runner runner : runners) {
            runner.setStartTime(LocalTime.of(hours, minutes));
        }
    }

    //nacteni s vyuzitim Scanner
    //textovy soubor typu csv (comma separated values) se zahlavim s daty na radcich s oddelovacim znakem carka
    public void loadStart(File filename) throws FileNotFoundException, IOException {
        try (Scanner br = new Scanner(new FileReader(filename))) {
            String line;
            int number;
            LocalTime startTime;
            Runner r;
            br.nextLine(); //preskoceni zahlavi
            while (br.hasNext()) {
                line = br.nextLine();
                String[] parts = line.split(","); //32,1:10:00.0
                number = Integer.parseInt(parts[0]);
                startTime = LocalTime.parse(parts[1], dtfTime);
                r = findByNumber(number);
                r.setStartTime(startTime);
            }
        }
    }

    //textovy soubor bez zahlavi s daty na radcich s oddelovacim znakem jednou nebo vice mezerami
    public void loadFinish(File filename) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int number;
            LocalTime finishTime;
            Runner r;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" +"); //32    2:30:12.0
                number = Integer.parseInt(parts[0]);
                finishTime = LocalTime.parse(parts[1], dtfTime);
                r = findByNumber(number);
                r.setFinishTime(finishTime);
            }
        }
    }

    /*
    public void loadFinish(File filename, String regexSeparator, boolean header) throws FileNotFoundException, IOException {
            TextFileReader in = new TextFileReader();
            List<String[]> data = in.readFile(filename, regexSeparator, header);
            finishDataToRunners(data);   
    }
    
    private void finishDataToRunners(List<String[]> data){ // |2|2:31:21.1|
        int number;
        LocalTime finishTime;
        Runner r;
        for (String[] parts : data) {// |2|2:31:21.1|
            number = Integer.parseInt(parts[0]);
            finishTime = LocalTime.parse(parts[1], dtfTime);
            r = findByNumber(number);
            r.setFinishTime(finishTime);
        }
    }*/
    private Runner findByNumber(int number) {
        for (Runner r : runners) {
            if (r.getNumber() == number) {
                return r;
            }
        }
        throw new NoSuchElementException("Runner with number " + number + "does not exist.");
    }

    public String getResults() {
        StringBuilder sb = new StringBuilder();
        for (Runner r : runners) {
            sb.append(r).append("\n");
        }
        return sb.toString();
    }


    public String getRunnersByRunningTime() {
        Collections.sort(runners, Runner.COMP_RUNNING);
        return getResults();
    }

    public String getRunnersByName() {
        Collections.sort(runners, Runner.COMP_NAME);
        return getResults();
    }

    public String getRunnersByNumber() {
        Collections.sort(runners);
        return getResults();
    }

    //ulozeni vysledku do textoveho souboru, oddelovaci znak je mezera
    public void saveResultsToText(File resultFile) throws IOException {
        Collections.sort(runners, Runner.COMP_RUNNING);
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(resultFile, false)))) { //true (append) - zapise data na konec souboru
            pw.println(String.format("%s %s %s %s", "Cislo", "Jmeno", "Prijmeni", "Cas_behu")); //zahlavi
            String s;
            for (Runner runner : runners) {
                s = String.format("%d %s %s %s", runner.getNumber(), runner.getFirstName(), runner.getLastName(), runner.runningTime().format(dtfTime));
                pw.println(s);
            }
        }
    }

    //ulozeni vysledku do binarniho souboru (bez oddelovacich znaku)
    public void saveResultsToBinary(File resultFile) throws FileNotFoundException, IOException {
        Collections.sort(runners, Runner.COMP_RUNNING);
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(resultFile))) {
            for (Runner runner : runners) {
                dos.writeInt(runner.getNumber());
                dos.writeUTF(runner.getFirstName());
                int nChars = runner.getLastName().length();
                dos.writeInt(nChars);
                for (int i = 0; i < nChars; i++) {
                    dos.writeChar(runner.getLastName().charAt(i));
                }
                dos.writeLong(runner.runningTime().toNanoOfDay());
            }
        }
    }
}
