
package bank;

/**
 *
 * @author Lukáš
 */
public class Account {
    
    private double penize;

    public Account() {
    }

    public Account(double penize) {
        this.penize = penize;
    }


    
    public void vklad(double suma){
        this.penize= this.penize +suma;
        
    }
    
    public double vyber(double suma){
        if(this.penize>=suma && suma>0){
        this.penize= this.penize -suma;
        return suma;
        }else{
            throw new IllegalArgumentException("Ucet nelze precerpat");
        }

    }

    public double getKonto() {
        return penize;
    }
    
    
    
}
