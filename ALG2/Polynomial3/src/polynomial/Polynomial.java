/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomial;
import java.util.Arrays;

/**
 *
 * @author Lukáš
 */
public class Polynomial {
    
    //3x^2 +5x -1
    //ulozit konstanty pro exponent napr: [-1, 5 3]
    private double [] coefR; //R- obraceny
    
    public Polynomial(double k){
        coefR = new double[1];
        this.coefR[0]=k;
        
    }
    
    public Polynomial(double a, double b){ //ax +b [b a]
        coefR = new double[2];
        this.coefR[0]=b;
        this.coefR[1]=a;
        
    }
    
    private Polynomial(double [] coefR){ //3x^2 +5x -1 --> [-1, 5 3]
        this.coefR = Arrays.copyOf(coefR, coefR.length); //kopie pole, ulozena do coefR, tzv definzivni kopie
        
    }
    /*
    public Polynomial(double [] CoefR){  
    }
    */
    
    /*
    public Polynomial(double [] c, boolean reverted){ 
        
    }
    */
    
    
    //1.tovarni metoda
    public static Polynomial getInstance(double... coef){// 3 tecky, jakykoliv pocet dobulu, ale uklada se do pole, sama to udela pole
        double[] coefR = new double [coef.length];
        for (int i = 0; i < coefR.length; i++) {
            coefR[i]= coef[coef.length-1-i];
        }
        return new Polynomial(coefR);
        
    }
    
    //2.tovarni metoda
    public static Polynomial getInstanceFromR(double...coefR){
        
        return new Polynomial(coefR);
        }
        
     public double[] getCoefArr(){
        double[] coef = new double[coefR.length];   
        for (int i = 0; i < coefR.length; i++) {
            coef[i] = coefR[coefR.length - 1 -i];
        }
        return coef;
    }
    
    
    public int getDegree(){
        return coefR.length-1;
    }
    
     public static void main(String[] args) {
       //3x^2 +5x -1
       Polynomial p1 = Polynomial.getInstance(3, 1, 2);
//         System.out.println(p1.getDegree());
//         Polynomial dp1=p1.derivate();
//         System.out.println(dp1);
         System.out.println(p1.toFormatedString());
    }
     
     
     public Polynomial derivate() {
        double[] derivate = new double[coefR.length - 1];
        for (int i = 0; i < derivate.length; i++) {
            derivate[i] = coefR[i + 1] * (i + 1);

        }
        return new Polynomial(derivate);

    }

    @Override
   public String toString(){
       String output = "";
        for (int i = coefR.length - 1 ;i >=0 ;i--) {
            if (coefR[i] != 0) {
                if (coefR[i] != 1) {
                    if (coefR[i] > 0) {
                        output += "+";

                    }else {
                        output += " ";
                    }
                    output += coefR[i];
                }
                if (i > 1) {
                    output += "x^" + i + " ";

                } else {
                    if(i == 1){
                        output += "x ";
                    }
                }

            }

        }
        return output;
   }
     
    
    //hornerovo schema
    public double computeValue(double x){
        
        double[] arr = getCoefArr();
        double y = 0;
        for (int i = arr.length-1; i >=y; i--) {
               y = y * x + arr[i]; 
        }
        return y;
    }
    
    
    public double getCoefAt(int exponent){
        double[] coef = getCoefArr(); //prevrati pole abych dostaval spravne hodnoty pro spravne indexy a neslo to odzadu
    return coef[exponent];
    }
    
    public double[] getAllCoef(){
    return Arrays.copyOf(coefR, coefR.length); //defenzivni kopie
    }
    
    public String toFormatedString(){
        String result= "";
        if(coefR[0] != 0){
        if(coefR[0] > 0){
        result += coefR[0];
        } else{
        result += coefR[0];
        }
        }
        for (int i = 1; i < coefR.length; i++) {
            if(coefR[i] != 0){
            if(coefR[i] > 0){
            result += "+" + coefR[i] + "x" + (i != 1 ? "^" +i : "");
            } else{
            result += coefR[i] + "x" + (i != 1 ? "^" +i : "");
            }
            }
            }
       return result;
}
    
    

            
    }
