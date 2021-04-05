
package _Dufek_Marathon;


public class Bezci {
    
    
    public Bezec [] bezci;
    
    public Bezci(int [][] udaje){
        bezci= new Bezec[udaje.length];
        int cisloBezce;
        int cilovyCasH;
        int cilovyCasM;
        int cilovyCasS;
        
        Bezec b;
        
        for (int i = 0; i < udaje.length; i++) {
            cisloBezce=udaje[i][0];
            cilovyCasH=udaje[i][1];
            cilovyCasM=udaje[i][2];
            cilovyCasS=udaje[i][3];
            
            b= new Bezec(cisloBezce, cilovyCasH, cilovyCasM, cilovyCasS);
            bezci[i]=b;
        }
    }
    
    
    
    
}
