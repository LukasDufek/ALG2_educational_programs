/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

import java.io.File;
import java.time.LocalDate;

/**
 *
 * @author Lukáš
 */
class CommandLine {
    
    private boolean isRunning;
    private File currentDir;
 
    public CommandLine() {
        isRunning = true;
        currentDir = new File(System.getProperty("user.dir"));
    }
 
    public String getCurrentDirAbsolutePath() {
        try {
            return currentDir.getCanonicalPath();
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
                return dir(parsed.length > 1 ? parsed[1] : "");
            case "cd":
                return cd(parsed[1]); // ../ui/nda
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
    
    public String dir(String path) {
        File absolutePath = new File(path);
        File[] list = absolutePath.listFiles();
        String result = "";
        for (File file : list) {
            result += String.format("%25s", file.getName()); //TODO: long to time
        }
        return result;
    }
    
    /*
    public String dir() {
        File absolutePath = new File(path);
        File[] list = absolutePath.listFiles();
        String result = "";
        for (File file : list) {
            result += String.format("%25s", file.getName()); //TODO: long to time
        }
        return result;
    }
    */
    
    public String help() {
        return    "dir                            - vypíše obsah aktuálního adresáře\n"
                + "dir [directoryPath]            - vypíše obsah zadaného adresáře\n"
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
//    private String dir(String [] parts){
//        String [] filesWithExtension = currentDir.list(new ExTensionFilter(parts[2]));
//        return arrayToString(filesWithExtension);
//    }
    
    
    
}
