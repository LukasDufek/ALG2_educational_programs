
package _Dufek_Marathon;


public class Bezec{
    
    private int cisloBezce;
    private int cilovyCasH;
    private int cilovyCasM;
    private int cilovyCasS;
    public int dobaBehu;

    
    //konstruktor
    public Bezec(int cisloBezce, int cilovyCasH, int cilovyCasM, int cilovyCasS) {
        this.cisloBezce = cisloBezce;
        this.cilovyCasH = cilovyCasH;
        this.cilovyCasM = cilovyCasM;
        this.cilovyCasS = cilovyCasS;
    }   
    
    public static int getDobaBehu(int cilovyCasH, int cilovyCasM, int cilovyCasS, int zacatek){
        int celkovyCilovyCas = cilovyCasH*3600 + cilovyCasM*60 + cilovyCasS;
        int dobaBehu = celkovyCilovyCas - zacatek;
        return dobaBehu;
    }

    public int setCisloBezce(int cisloBezce) {
        this.cisloBezce = cisloBezce;
        return cisloBezce;
    }

    public int setCilovyCasH(int cilovyCasH) {
        this.cilovyCasH = cilovyCasH;
        return cilovyCasH;
    }

    public int setCilovyCasM(int cilovyCasM) {
        this.cilovyCasM = cilovyCasM;
        return cilovyCasM;
    }

    public int setCilovyCasS(int cilovyCasS) {
        this.cilovyCasS = cilovyCasS;
        return cilovyCasS;
    }


    
    


    
    
    
    
    
}
