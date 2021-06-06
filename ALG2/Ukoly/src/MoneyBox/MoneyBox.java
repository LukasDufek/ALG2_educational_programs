
package _21_Dufek_MoneyBox;


public class MoneyBox {
    
    private String majitel;
    private int pocetKorun;
    private int pocetDvoukorun;
    public int suma = pocetKorun+(2*pocetDvoukorun);

    
    //1.kostruktor
    public MoneyBox(String majitel) {
        this.majitel = majitel;
    }
    
    
    //2.konstruktor
    public MoneyBox(String majitel, int pocetKorun, int pocetDvoukorun) {
        this.majitel = majitel;
        this.pocetKorun = pocetKorun;
        this.pocetDvoukorun = pocetDvoukorun;
        this.suma = pocetKorun+(2*pocetDvoukorun);
    }

    
    //nastaveni/zmena majitele pokladnicky
    public void setMajitel(String majitel) {
        this.majitel = majitel;
    }

    //vraci sumu v pokladnicce
    public int getSuma() {
        return suma;
    }
    
    //vlozit korunu
public void plusKoruna (){
    this.suma= suma+1;
}   

//vlozit dvoukorunu
public void plusDvoukoruna (){
    this.suma= suma+2;
}  

    //vlozit pocet korun a dvoukorun
public void vlozMince(int a, int b){
    this.suma=suma+ a+ (2*b);
    
}

    @Override
    public String toString() {
        
        return majitel + "ma v pokladnicce "+ suma+ " -- "+pocetKorun+ "x1Kč,"+ pocetDvoukorun+"x2Kč." ;
    }

    public String getMajitel() {
        return majitel;
    }

    public int getPocetKorun() {
        pocetKorun=suma%2;
        return pocetKorun;
    }

    public int getPocetDvoukorun() {
        pocetDvoukorun=suma/2;
        return pocetDvoukorun;
    }
    
    


    
}
