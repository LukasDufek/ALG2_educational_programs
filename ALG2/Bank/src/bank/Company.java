package bank;

/**
 *
 * @author Lukáš
 */
public class Company extends Client{

    public Company(String jmeno) {
        this.jmeno=jmeno;
    }

    
    
    @Override
    public String getJmeno() {
        return "Firma "+this.jmeno;
    }

    @Override
    public int compareTo(Client o) {
    return (int) (this.celkovaSuma()- o.celkovaSuma());    
    }
    
    
    
    
}
