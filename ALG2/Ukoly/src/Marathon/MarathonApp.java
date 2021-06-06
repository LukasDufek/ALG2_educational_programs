package _Dufek_Marathon;

public class MarathonApp {

    public static final int zacatek = (9 * 3600) + (15 * 60); //v sekundach
    private static final int draha = 42195; //v metrech
    private int pocet_bezcu=0;
    //private Bezci bezci;
    private Bezec[] bezci;

    

    public MarathonApp(int pocet_bezcu) {
        bezci= new Bezec[pocet_bezcu];
    }

    public void inicializaceBezcu(int [][] bezci_udaje){
        for(int i=0;i< bezci_udaje.length;i++)
            bezci[i]=new Bezec(bezci_udaje[i][0],bezci_udaje[i][1],bezci_udaje[i][2],bezci_udaje[i][3], zacatek);
        
        
    }

    public void pridejBezce(int cisloBezce, int hodiny, int minuty, int sekundy){
        
        bezci[pocet_bezcu]=new Bezec(cisloBezce, hodiny, minuty, sekundy, zacatek);
        pocet_bezcu++;
    }
    
    
    //1) kolik bezcu melo pod 2:07:00
    public int BezciPodCasem(int kontrolniCas ){ //v sekundach
        int pocetBezcu = 0;

        for(Bezec b : bezci){
            if(b.getDobaBehu()<kontrolniCas){
                pocetBezcu++;
            }
        }
        return pocetBezcu;
    }
    //2) cislo nejrychlejsiho bezce 
    public int cisloNejrychlejsiho(){
       return prvniBezec().getCisloBezce();

    }

    //3) ztrata posledniho bezce
    public String ztrataPosledniho(){
        
        int prvni= prvniBezec().getDobaBehu();
        
        int posledni = Integer.MIN_VALUE;

        for(Bezec b: bezci){
            
            if(b.getDobaBehu()>posledni)
                posledni=b.getDobaBehu();
        }
        posledni = posledni - prvni;
        int hh = posledni / 3600;
        int mm = (posledni % 3600) / 60;
        int ss = (posledni % 3600) % 60;
        return String.format("%02d:%02d:%02d",hh,mm,ss);
    }

    //4) prumerny cas na kilometr nejryclhejsiho bezce
    public String prumernyCasNaKilometrNejrychlejsihoBezce(){
        int prvni=casPrvniho();
        
        double drahaD = draha;
        double prvniD = prvni;
        double prumernyCas = (prvniD) / (drahaD / 1000);
        double h = prumernyCas/3600;
        double m = Math.floor((prumernyCas%3600)/60);
        double s = (prumernyCas%3600)%60;
        return String.format("%.0f:%.0f",m,s);
    }

    //5) prumerna rychlost nejrychlejsiho bezce
    public double prumernaRychlostNejrychlejsiho(){
        
        int prvni=casPrvniho();

        double rychlostPrvniho=((double)draha/(double) prvni)* 3.6;
        return rychlostPrvniho;
    }
    
    public int casPrvniho(){
        int prvni = Integer.MAX_VALUE;
        
        for(Bezec b: bezci){
            if(b.getDobaBehu()<prvni)
                prvni=b.getDobaBehu();
        }
        return prvni;
    }
    
    public Bezec prvniBezec(){
        int prvniCas = Integer.MAX_VALUE;
        Bezec prvni= null;
        
        for(Bezec b: bezci){
            if(b.getDobaBehu() < prvniCas){
                prvniCas=b.getDobaBehu();
                prvni= b;
            }   
        }
        return prvni;
    }
    
    
    
    
    
}



