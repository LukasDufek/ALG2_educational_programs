
package _15_Dufek_Fraction;


public class fractionApp {

   
    public static void main(String[] args) {
        
        Fraction f= new Fraction(12,6);
        Fraction fs = new Fraction ("12/5");
        
        
        //citatel
        System.out.println(f.getA());
        //jmenovatel
        System.out.println(f.getB());
        //zlomek
        System.out.println(f.toString());
        f.reducedFraction();
        fs.reducedFraction();
        
        
        
    }
    
}
