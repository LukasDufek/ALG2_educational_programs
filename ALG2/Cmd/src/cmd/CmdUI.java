/*
    Ma 3 hlavni funkce
    1) kde se nachazi
    2) nacte od uzivatel
    3) vrati vystup
 */
package cmd;

import java.util.Scanner;

/**
 *
 * @author Lukáš
 */
public class CmdUI {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        CommandLine cmd = new CommandLine();
        
        
        do {
            System.out.print(cmd.getCurrentDirAbsolutePath() + ">  ");
            String command = sc.nextLine();
            try{
                System.out.print(cmd.parseAndExecute(command));
            }catch(ArrayIndexOutOfBoundsException e){ //rename
                System.out.println("Neplatny prikaz");
            }
            
        } while (cmd.isRunning());
        
    }
    
}
