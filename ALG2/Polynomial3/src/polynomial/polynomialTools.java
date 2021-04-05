/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomial;

/**
 *
 * @author Lukáš
 */
public class polynomialTools {
    
     private polynomialTools() {

    }

    public static Polynomial sum(Polynomial a, Polynomial b) {
        Polynomial max = a.getDegree() > b.getDegree() ? a : b;
        Polynomial min = a.getDegree() <= b.getDegree() ? a : b;
        double[] sum = new double[max.getDegree() + 1];
        //double d;
        for (int i = 0; i < sum.length; i++) {
           // d = sum[i];
            sum[i] = max.getCoefAt(i);
           
        }
         //System.out.println(Arrays.toString(sum));

        for (int i = 0; i < min.getDegree()+1; i++) {
            sum[i] += min.getCoefAt(i);
        }
         //System.out.println(Arrays.toString(sum));
        return Polynomial.getInstance(sum);
    }
    
        public static Polynomial multiply(Polynomial a, Polynomial b){
       double array[] = new double[10] ;
       String output = "";
       double mult;
       int pow;
        for (int i = 0; i <= a.getDegree(); i++) {
            for (int j = 0; j <= b.getDegree(); j++) {
                mult = a.getCoefAt(i) * b.getCoefAt(j);
                pow = (a.getDegree()-i) + (b.getDegree()-j);
                array[pow]+= mult; 
            }          
        }
        for (int j = array.length-1; j >= 0; j--) {
                if(array[j]>0){
                    System.out.print(" +"+array[j]+"x^"+j);
                }
            }
        
        Polynomial c = Polynomial.getInstanceFromR(array);
       // c.toString();
        
       return c;
    }
    
}
