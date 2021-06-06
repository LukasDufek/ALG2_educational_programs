
package cmd;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Lukáš
 */
class CommandLine {
    
    private boolean isRunning;
    private File currentDir;
 
    public CommandLine() {
        isRunning = true;
        currentDir = new File(System.getProperty("user.dir")); //zavolani aktualniho adresare
    }
 
    public String getCurrentDirAbsolutePath() {
        try {
            return currentDir.getCanonicalPath(); // raletivni cesta
        } catch (Exception e) {
            return e.toString();
        }
    }
 
    public String parseAndExecute(String line) {
        String[] parsed = line.split(" ");
        switch (parsed[0]) {
            case "help":
                return help();
            case "dir":
                return dir();
            case "dir-r":
                return dirR(parsed[1]);
            case "cd":
                return cd(parsed[1]); 
            case "mkfile":
                return mkfile(parsed[1]);
            case "mkdir":
                return mkdir(parsed[1]);
            case "mkdirs":
                return mkdirs(parsed[1]);
            case "rename":
                return rename(parsed[1], parsed[2]);
            case "exit":
                isRunning = false;
                return "Konec.\n";
            default:
                return "Neplatný příkaz\n";
        }
    }
    
    public String rename(String jm1, String jm2)throws ArrayIndexOutOfBoundsException{
        File path = new File(currentDir, jm1);
        File dest = new File(currentDir, jm2);
        if (path.renameTo(dest)) {
            return "Složka nebo soubor přejmenován\n";
        } else {
            return "Složku nebo soubor se nepodařilo přejmenovat\n";
        }
    }
    
    public String mkdirs(String folder) {
        File path = new File(currentDir, folder);
        if (path.mkdirs()) {
            return "Adresář vytvořen\n";
        } else {
            return "Adresář se nepodařilo vytvořit\n";
        }
    }
    
    public String mkdir(String folder) {
        File path = new File(currentDir, folder);
        if (path.mkdir()) {
            return "Adresář vytvořen\n";
        } else {
            return "Adresář se nepodařilo vytvořit\n";
        }
    }
    
    public String mkfile(String file) {
        File path = new File(currentDir, file);
        try {
            if (path.createNewFile()) {
                return "Soubor vytvořen\n";
            } else {
                return "Soubor se nepodařilo vytvořit\n";
            }
        }
        catch (Exception e) {
            return "Soubor se nepodařilo vytvořit\n"; // ošetřit
        }
    }
    
    public String cd(String path) {
        File tmp = new File(currentDir, path);
        if (tmp.exists()) {
            currentDir = tmp;
            return "\n";
        } else {
            return "Nepodařilo se vyřešit cestu\n";
        }
    }
    
    public String dir() {
        StringBuilder sb = new StringBuilder();
        List<String> contents = Arrays.asList(currentDir.list());
        for (String element : contents) {
            sb.append(element + "\n");
        }
        return sb.toString();
    }
    
public String dirR(String addr){
    StringBuilder sb = new StringBuilder();
    File [] filesList = new File(addr).listFiles();
    if(filesList == null){
        return sb.toString();
    }
    for (File file : filesList) {
        sb.append("-").append(file.getName()).append("\n");
        if(file.isDirectory()){
            sb.append("-").append(dirR(file.getAbsolutePath()));
        }
    }
    return sb.toString();
}
    
    public String help() {
        return    "dir                            - vypíše obsah aktuálního adresáře\n"
                + "dir-r [directoryName]          - vypíše obsah zadaného adresáře\n"
                + "cd [path]                      - změna aktuálního adresáře\n"
                + "mkfile [fileName]              - vytvoří soubor\n"
                + "mkdir [directoryName]          - vytvoří složku\n"
                + "mkdirs [directoryName]         - vytvoří složku včetně cesty\n"
                + "rename [fileName] [fileName]   - přejmenuje soubor nebo složku\n"
                + "exit                           - ukončí program\n";
    }
 
    public boolean isRunning() {
        return isRunning;
    }
    
    
    
    private String arrayStringToString(String [] a){ //prevod pole stringu do stringu
        StringBuilder sb = new StringBuilder();
        for (String string : a) {
            sb.append(string).append("\n");
        }
        return sb.toString();
    }

    
    
    
}
