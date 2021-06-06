/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameon;

import elevengame.GameInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author david
 */
public class UI {

    public static GameInterface board;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        board = new Board();
        List<Integer> iSelectedCards = new ArrayList();
        int choice1;
        int choice2;
        
        System.out.println(board.getBoard());
        System.out.println("hra " + (board.anotherPlayIsPossible() ? "je" : "neni") + " mozna");
        System.out.println("Zmackni 1 pro start, -2 pro ukonceni aplikace");
        while (board.anotherPlayIsPossible() && (choice1 = sc.nextInt()) != -2) {

            System.out.println(board.getBoard()); //display cards
            System.out.println("vyber, ukonci -1");
            iSelectedCards.clear();
            while ((choice2 = sc.nextInt()) != -1) {
                iSelectedCards.add(choice2);
            }

            if (board.playAndReplace(iSelectedCards)) {
                System.out.println("Spravna volba karet");
            } else {
                System.out.println("Ale no tak, tyto karty nemaji soucet 11");
            }
            
            System.out.println(board.anotherPlayIsPossible() ? "Zmackni 1 pro pokracovani, nebo -2 pro ukonceni apliakce" : "Dalsi hra neni mozna");
        }

    }
}
