package _Dufek_Marathon;

public class Bezec {
    private int cisloBezce;
    private int cilovyCasH;
    private int cilovyCasM;
    private int cilovyCasS;
    private final int zacatek;


    //konstruktor
    public Bezec(int cisloBezce, int hod, int min, int sek, int zacatek) {
        this.cisloBezce = cisloBezce;
        this.cilovyCasH = hod;
        this.cilovyCasM = min;
        this.cilovyCasS = sek;
        this.zacatek = zacatek;
    }

    public int getDobaBehu(){
        int celkovyCilovyCas = this.cilovyCasH*3600 + this.cilovyCasM*60 + this.cilovyCasS;
        int dobaBehu = celkovyCilovyCas - this.zacatek;
        return dobaBehu;
    }

    public int getCisloBezce() {
        return cisloBezce;
    }

    @Override
    public String toString() {
        return "Bezec{" + "cisloBezce=" + cisloBezce + ", cilovyCasH=" + cilovyCasH + ", cilovyCasM=" + cilovyCasM + ", cilovyCasS=" + cilovyCasS + ", zacatek=" + zacatek + '}';
    }
    
    
    
    
}