package _15_Dufek_Fraction;

public class Fraction {

    private int a;
    private int b;

    //1.konstruktor  
    public Fraction(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Jmenovatel nesmi byt 0");
        }
        this.a = a;
        this.b = b;

    }
    //2.konstruktor  

    public Fraction(String fraction) {
        String[] frac = fraction.split("/");
        this.a = Integer.parseInt(frac[0]);
        this.b = Integer.parseInt(frac[1]);
    }
//konstruktor se musi jmenovat stejne jako nazev tridy-- konstrukce objektu

    @Override
    public String toString() {

        if (this.b == 1) {
            return "" + this.a;
        }
        else if((a%b)==0){
            return""+ a/b;
        }else {
            return a + "/" + b;
        }
    }

//citatel
    public int getA() {
        return a;
    }
//jmenovatel

    public int getB() {
        return b;
    }
//zlomek

    public double getValue() {
        return (double) a / b;
    }

    public void reducedFraction() {
        int temp = 0;
        int x = this.a;
        int y = this.b;
        if (x < y) {
            temp = x;
            x = y;
            y = temp;
        }

        while (y != 0) {
            temp = y;
            y = x % y;
            x = temp; // x = nejvetsi spolecny delitel
        }
        System.out.println("zakladni tvar: " + (this.a / x) + "/" + (this.b / x));
    }

    /**
     * @return spolecny delitel
     */


public static int leastCommonDivisor(int a, int b) {
        int temp = 0;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp; // a = nejvetsi spolecny delitel
        }
        return a;
    }


    public void simplify() {
        int divisor = leastCommonDivisor(this.a, this.b);
        this.a = this.a / divisor;
        this.b = this.b / divisor;

    }

    public Fraction simplify2() {
        int divisor = leastCommonDivisor(this.a, this.b);
        int redNum = this.a / divisor;
        int redDenum = this.b / divisor;
        Fraction f = new Fraction(redNum, redDenum);
        return f;

        // return new Fraction(redNum,redDenum); zkraceny zapis
    }

}