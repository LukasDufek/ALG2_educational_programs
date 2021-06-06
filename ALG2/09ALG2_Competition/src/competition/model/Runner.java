package competition.model;

import competition.utils.UnsetTimeException;
import java.text.Collator;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 *
 * @author JV
 */
public class Runner implements Comparable<Runner>{
    private String firstName;
    private String lastName;
    private char gender;
    private LocalDate born;
    private String club;
    private String nationality;
    
    private int number;
    private LocalTime startTime;
    private LocalTime finishTime;
    
    //Comparator s vyuzitim anonymni tridy
    public static final Comparator<Runner> COMP_RUNNING = new Comparator<Runner>() { 
        @Override
        public int compare(Runner r1, Runner r2) {        
            return r1.runningTime().compareTo(r2.runningTime());
        }
    };
    
    //Comparator s vyuzitim lambda vyrazu
    public static Collator col = Collator.getInstance(new Locale("cs", "CZ"));
    public static final Comparator<Runner> COMP_NAME = (Runner r1, Runner r2) -> {
        int result = col.compare(r1.lastName,r2.lastName);
        if(result == 0){ //if same lastName, compare using firstName
            result = col.compare(r1.firstName,r2.firstName);
        }
        return result;
    };
    public static final Comparator<Runner> COMP_CLUB = (Runner r1, Runner r2) -> {
        return col.compare(r1.club,r2.club);
    };
    public static final Comparator<Runner> COMP_NATIONALITY = (Runner r1, Runner r2) -> r1.nationality.compareTo(r2.nationality);
    
    public Runner(String firstName, String lastName, char gender, LocalDate born, String club, String nationality, int number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.born = born;
        this.club = club;
        this.nationality = nationality;
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBorn() {
        return born;
    }

    public String getClub() {
        return club;
    }

    public String getNationality() {
        return nationality;
    }

    public int getNumber() {
        return number;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getFinishTime() {
        return finishTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setFinishTime(LocalTime finishTime) {
        if(startTime == null){
            throw new UnsetTimeException("Start time not set yet."); //own exception
        }
        this.finishTime = finishTime;
    }
    
    public LocalTime runningTime() {
        if(startTime == null || finishTime == null){
            throw new UnsetTimeException("Start or finish time not set, not possible to calculate running time.");
        }
        //return LocalTime.ofNanoOfDay(Duration.between(startTime, finishTime).toNanos());
        return LocalTime.ofNanoOfDay(finishTime.toNanoOfDay() - startTime.toNanoOfDay());
    }

    @Override
    public String toString() {
        String s = String.format("%-10s %-10s %s %s %10s %s %d", firstName, lastName, gender,born.format(DateTimeFormatter.ISO_LOCAL_DATE), club, nationality, number);
        if(startTime != null){
            s += String.format(" %12s ", startTime); //default format  ISO-8601 HH:mm:ss.SSS 
        }else{
            s += String.format(" %12s ", "----");
        }
        if(finishTime != null){
            s += String.format(" %12s ", finishTime);
        }else{
            s += String.format(" %12s ", "----");
        }
        if(startTime != null && finishTime != null){
            s += String.format(" %12s ", runningTime().format(Competition.dtfTime));
        }else{
            s += String.format(" %12s ", "----");
        }

        return s;
    }
    
    
    @Override
    public int compareTo(Runner o) {
        return this.number - o.number;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Runner other = (Runner) obj;
        if (this.number != other.number) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.born, other.born)) {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Runner r = new Runner("Alice", "Mala", 'F', LocalDate.parse("3/21/2000", Competition.dtfDate), "SK Liberec", "CZE", 2);
        System.out.println(r);
        try{
            System.out.println(r.runningTime().format(DateTimeFormatter.ISO_LOCAL_TIME));
        }catch(UnsetTimeException e){
            System.out.println(e.getMessage());
        }
        r.setStartTime(LocalTime.of(1, 20, 0));
        System.out.println(r);
        r.setFinishTime(LocalTime.of(2, 15, 0));
        System.out.println(r);
    }
}
