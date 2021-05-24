/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.ArrayList;

/**
 *
 * @author Lukáš
 */
public abstract class Client implements Comparable <Client>{
    protected String jmeno;
    ArrayList<Account> ucty = new ArrayList<>();

   

    public abstract String getJmeno();

    @Override
    public String toString() {
        return jmeno+":"+getSuma();
    }


    
    public void pridejUcet(double vklad){
        Account a = new Account(vklad);
        ucty.add(a);
    }
    
    public double celkovaSuma(){
        double suma=0;
        for (Account a : ucty) {
            suma+= a.getKonto();
        }
        return suma;
        
        //for (int i = 0; i < ucty.size(); i++) { 
        //      suma += accounts.get(i).getKonto();
        //        }
    }
    public String getSuma(){
        double suma= celkovaSuma();
        String v= ""+suma;
        return v;
    }
       
    
    
    

}
