package _15_Dufek_Fraction;

/**
 *
 * @author Lukáš
 */
public class FractionTools {
private FractionTools() {
    }

    public static Fraction add(Fraction f1, Fraction f2) {
        int num = f1.getA() * f2.getB() + f1.getB() * f2.getA();
        int denum = f1.getB() * f2.getB();
        return new Fraction(num, denum);
    }

    public static Fraction substract(Fraction f1, Fraction f2) {
        int num = f1.getA() * f2.getB() - f1.getB() * f2.getA();
        int denum = f1.getB() * f2.getB();
        return new Fraction(num, denum);
    }

    public static Fraction multiply(Fraction f1, Fraction f2) {
        int num = f1.getA() * f2.getA();
        int denum = f1.getB() * f2.getB();
        return new Fraction(num, denum);
    }

    public static Fraction divide(Fraction f1, Fraction f2) {
        int num = f1.getA() * f2.getB();
        int denum = f1.getB() * f2.getA();
        return new Fraction(num, denum);
    }
    
    public static Fraction calculate(Fraction f1, Fraction f2, char operator){
        switch(operator){
            case '+' : return add(f1,f2);
            case '-' : return substract(f1,f2);
            case '*' : return multiply(f1,f2);
            case '/' : return divide(f1,f2);
            default: return new Fraction((int)Double.NaN, (int)Double.NaN);
        }
    }
    
    public static void main(String[] args) {
        Fraction f1= new Fraction(3,4);
        Fraction f2= new Fraction(4,3);
        System.out.println(calculate(f1,f2,'-'));
    }
    
    
}
