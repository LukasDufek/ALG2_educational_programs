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
        int celkovyCilovyCas = cilovyCasH*3600 + cilovyCasM*60 + cilovyCasS;
        int dobaBehu = celkovyCilovyCas - zacatek;
        return dobaBehu;
    }

    public int getCisloBezce() {
        return cisloBezce;
    }
    
    
}