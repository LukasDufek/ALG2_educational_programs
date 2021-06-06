/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameon;

/**
 *
 * @author david
 */
public class Card {
    private String symbol;  
    private String value;  //rank
    private int nPoints; 
    
    //methods

    public Card(String symbol, String value, int nPoints) {
        this.symbol = symbol;
        this.value = value;
        this.nPoints = nPoints;
    }

    public String getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getnPoints() {
        return nPoints;
    }

    @Override
    public String toString() {
        return "Card{" + "symbol = " + symbol + ", value = " + value + ", nPoints = " + nPoints + '}';
    }
}
