
package _15_Dufek_Fraction;


public class Fraction {
   private int a;
   private int b;
 
   
 //1.konstruktor  
public Fraction(int a, int b){
    this.a = a;
    this.b = b;
     
}
 //2.konstruktor  
public Fraction (String fraction) {
    String [] frac = fraction.split("/");
    this.a= Integer.parseInt(frac[0]);
    this.b= Integer.parseInt(frac[1]);
}
//konstruktor se musi jmenovat stejne jako nazev tridy-- konstrukce objektu


   @Override
   public String toString(){
   return  a+"/"+b;
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
        int a1=a;
        int b1=b;
        
        if( ( (a1!=0) && (b1!=0) )  &&  ((x%y ==0) || (y%x ==0))){
            System.out.println("Zakladni tvar: "+ (this.a)/x);
        }else{
        System.out.println("zakladni tvar: " + (this.a/x) + "/" + (this.b/x));
    }
        
}

}
