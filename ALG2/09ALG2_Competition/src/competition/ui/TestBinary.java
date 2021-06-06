package competition.ui;

import competition.model.Competition;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

/**
 *
 * @author JV
 */
public class TestBinary {
    
    public static String readResultsBinary(File filename) throws FileNotFoundException, IOException{
        StringBuilder sb = new StringBuilder();
        try(DataInputStream dis = new DataInputStream(new FileInputStream(filename))){
            int number;
            String firstName = "";
            String lastName = "";
            int nChars;
            LocalTime runningTime;
            boolean end = false;
            while(!end){
                lastName = "";
                try{
                    number = dis.readInt();
                    firstName = dis.readUTF();
                    nChars = dis.readInt();
                    for (int i = 0; i < nChars; i++) {
                        lastName += dis.readChar();
                    }
                    runningTime = LocalTime.ofNanoOfDay(dis.readLong());
                    sb.append(String.format("%d%10s%10s%12s%n", number, firstName, lastName, runningTime.format(Competition.dtfTime)));
                } catch(EOFException e){
                    end = true;
                }
            }
 
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String userDir = System.getProperty("user.dir");
        File dataDirectory = new File(userDir + File.separator + "data");
        System.out.println("Zadej binarni soubor s vysledky");
        String resultFile = sc.next();
        System.out.println(readResultsBinary(new File(dataDirectory, resultFile)));
    }
    
}
