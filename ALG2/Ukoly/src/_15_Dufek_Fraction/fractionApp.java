
package _15_Dufek_Fraction;


public class fractionApp {

   
    public static void main(String[] args) {
        int divisor = Fraction.leastCommonDivisor(0,12);
       System.out.println("d " + divisor);
        Fraction f= new Fraction(12,5);
        Fraction f2 = new Fraction ("12/6");
        
        
        //citatel
        System.out.println(f.getA());
        //jmenovatel
        System.out.println(f.getB());
        //zlomek
        System.out.println(f.getValue());
        System.out.println(f.toString());  

         f.simplify(); //zakladni tvar
        System.out.println("simplified: " + f.toString());
        
        Fraction f3 = new Fraction(-4,-1);
        System.out.println(f3);
        Fraction f4 = f3.simplify2();
        System.out.println("simplified " + f4);
        

        
    }
    
}
