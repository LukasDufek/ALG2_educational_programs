
package bank;

/**
 *
 * @author Lukáš
 */
public class Person extends Client{

    public Person(String jmeno) {
        this.jmeno = jmeno;
        
    }

    

    @Override
    public String getJmeno() {
        if ("ova".equals(this.jmeno.substring(this.jmeno.length() - 3))) {
            return "pani " + this.jmeno;
        }else{
            return "pan " + this.jmeno;
        }

    
    
    
    }
}
