
package calendar;

import java.util.Scanner;
import java.lang.StringBuffer;

/**
 *
 * @author David Bálik
 */
public class Calendar {
    static Scanner sc = new Scanner(System.in);
    
    private int day;
    private int month;
    private int year;
    private int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //12 mesicu po delce dni

    public static void main(String[] args) {
        //inicializace
        System.out.println("Zadejte den, mesic a rok");
        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();
        
        Calendar cal1 = new Calendar(day, month, year);
        System.out.println(isLeapYear(year));
        System.out.println(cal1.getCalendar());
        callMenu(cal1);
        
        
       
        
        
    }
    
    public static void callMenu(Calendar k) {
        int vysledek = k.getMenu();
        while (vysledek != 0) {
            if (vysledek == 1) {
                k.nextMonth();
            } else if (vysledek == -1) {
                k.previousMonth();
            }
            System.out.println(k.getCalendar());
            vysledek = k.getMenu();
        }
    }
    
    
    public int getMenu(){
        int choise;
        System.out.println("Pokud chcete posunout mesic vyberte: ");
        System.out.println("Posunout o mesic dopredu 1, o mesic zpet -1");
        choise = sc.nextInt();
        if (choise == 1) {
            return 1;
        }
        else if (choise == -1) {
            return -1;
        }else{
            return 0;
        }
    }
    
    
    //constructor
    public Calendar(int day, int month, int year) {
        if(day < 1 ){
                
            throw new IllegalArgumentException("Takovy den neexistuje");
        }
        else{
        this.day = day;
        }
        if(month < 1 || month > 12){
            throw new IllegalArgumentException("Takovy mesic neexistuje");
        }
        else{
          this.month = month;  
        }
        
        this.year = year;
    }
    
    

    public int Zeller(int day, int month, int year) { //den v tydnu
        int dayOfWeek;
        int h;
        int q = day;
        int m;       
        int K = year % 100;
        int J = year / 100;
        
        switch(month){
            case 1:
                m = 13;
                K -= 1;
                break;
            case 2:
                m = 14;
                K -= 1;
                break;
            default:
                m = month;
                break;
        }

        h = (q + ((13 * (m + 1)) / 5) + K + (K / 4) + (J / 4) + 5 * J) % 7; //spocita den v tydnu od nedele(utery = 3)
        return dayOfWeek = ((h + 5) % 7) + 1; //spocita den v tydnu od pondeli(utery = 2)
    }
    
    
    

    public static boolean isLeapYear(int year) { //prestupny rok
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;

    }
    

    public static int numberOfDays(int year) {
        if (isLeapYear(year)) { //==true?
            year = 366;
        } else {
            year = 365;
        }
        return year;
    }

    public void nextMonth() {
        this.day = 1;
        if (this.month == 12) {
            this.month = 1;
        } else {
            this.month += 1;
        }
    }

    public void previousMonth() {
        this.day = 1;
        if (this.month == 1) {
            this.month = 12;
        } else {
            this.month -= 1;
        }
    }

    public String getCalendar() {
        int daysmonth = daysInMonth[this.month - 1];
        StringBuilder sb = new StringBuilder();
        sb.append("mo ");
        sb.append("tu ");
        sb.append("we ");
        sb.append("th ");
        sb.append("fr ");
        sb.append("sa ");
        sb.append("su");

        sb.append("\n");

        if (isLeapYear(year) == true && month == 2) {
            daysmonth += 1;
        }

        for (int i = 1; i < Zeller(1, month, year); i++) {
            sb.append("   ");
        }
        
        for (int i = 1; i <= daysmonth; i++) {
            if (i < 10) {
                sb.append(i + "  ");
            } else {
                sb.append(i + " ");
            }
                if (Zeller(i, month, year) == 7) {
                    sb.append("\n");
                }
            }

            String st = sb.toString();
            return st;

        }
    
    }


 