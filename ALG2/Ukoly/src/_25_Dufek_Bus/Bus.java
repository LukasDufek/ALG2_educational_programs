
package _25_Dufek_Bus;


public class Bus {
    
    private final int pocetSedadel; //nemeny
    private int cisloLinky;
    private String nazevSpolecnosti; //referencni datovy typ
    private int pocetCestujicich;
    

    public Bus(int pocetSedadel, int cisloLinky, String nazevSpolecnosti) {
        this.pocetSedadel = pocetSedadel;
        this.cisloLinky = cisloLinky;
        this.nazevSpolecnosti = nazevSpolecnosti;
        this.pocetCestujicich = 0;

    }

    public Bus(int pocetSedadel) {
        this.pocetSedadel = 40;
        this.pocetCestujicich=0;
    }
    
    
    //zjisti sedadel
    public int getPocetSedadel() {
        return pocetSedadel;
    }

    //zjisti cislo linky
    public int getCisloLinky() {
        return cisloLinky;
    }

    
    //zjisti nazev spolecnosti
    public String getNazevSpolecnosti() {
        return nazevSpolecnosti;
    }

    //zjisti aktualni pocetCestujicich
    public int getPocetCestujicich() {
        return pocetCestujicich;
    }

    
    //zmen cislo linky
    public void setCisloLinky(int cisloLinky) {
        this.cisloLinky = cisloLinky;
    }

    //zmen nazev spolecnosti
    public void setNazevSpolecnosti(String nazevSpolecnosti) {
        this.nazevSpolecnosti = nazevSpolecnosti;
    }

    @Override
    public String toString() {
        
        return "Autobus cislo "+ cisloLinky +" spolecnosti " + nazevSpolecnosti +" s poctem sedadel "+ pocetSedadel +" veze " + pocetCestujicich+" cestujicich.";
   
    }

    public void setPocetCestujicich(int pocetCestujicich) {
        this.pocetCestujicich = pocetCestujicich;
    }
    
    

    public void setNechatVystoupitPocetCestujicich(int pocetCestujicichV) {
        this.pocetCestujicich -= pocetCestujicichV;
        

    }

    public void setNechatNastoupitPocetCestujicich(int pocetCestujicich) {
        this.pocetCestujicich += pocetCestujicich;

    }
    
    
    public void setNechatVystoupitVsechnyCestujici() {
        this.pocetCestujicich =0;
    }
    
    
    
    
}
