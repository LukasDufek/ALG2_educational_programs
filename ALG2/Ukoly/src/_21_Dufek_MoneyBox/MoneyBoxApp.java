
package _21_Dufek_MoneyBox;


public class MoneyBoxApp {

   
    public static void main(String[] args) {
        
        MoneyBox pokladnicka1 = new MoneyBox("Alice", 40, 6);
        MoneyBox pokladnicka2= new MoneyBox("Bob");
        
        pokladnicka2.plusKoruna();
        pokladnicka2.plusKoruna();
        
        pokladnicka2.plusDvoukoruna();
        pokladnicka2.plusDvoukoruna();
        pokladnicka2.plusDvoukoruna();
        
        pokladnicka2.vlozMince(5, 10);
        
        //kolik ma Alice a kolik ma Bob
        System.out.println("Alice ma:"+pokladnicka1.getSuma());
        System.out.println("Bob ma:"+pokladnicka2.getSuma());
        
        //vsechny informace o obou pokladnickach
        System.out.println("Majitel je: "+pokladnicka1.getMajitel()+", v pokladnicce ma: "+ pokladnicka1.getSuma()+"Kc, "+pokladnicka1.getPocetKorun()+"x1Kc, "+pokladnicka1.getPocetDvoukorun()+"x2Kc.");
        System.out.println("Majitel je: "+pokladnicka2.getMajitel()+", v pokladnicce ma: "+ pokladnicka2.getSuma()+"Kc, "+pokladnicka2.getPocetKorun()+"x1Kc, "+pokladnicka2.getPocetDvoukorun()+"x2Kc.");
    
        
        if(pokladnicka1.getSuma()>=39){
            System.out.println(pokladnicka1.getMajitel()+ " si muze koupit hamburger");
        }
        if(pokladnicka2.getSuma()>=39){
            System.out.println(pokladnicka2.getMajitel()+ " si muze koupit hamburger");
        }
        
        
        
        //kdo ma vic penez
      if(pokladnicka1.getSuma() > pokladnicka2.getSuma()){
          System.out.println(pokladnicka1.getMajitel()+" ma vic penez");
      }else if(pokladnicka2.getSuma() > pokladnicka1.getSuma()){
          System.out.println(pokladnicka2.getMajitel()+" ma vic penez");
      }else{
          System.out.println("Maji stejne");
      }
        
        
    }
    
    
    
    
}
