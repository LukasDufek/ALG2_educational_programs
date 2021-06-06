/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameon;

import elevengame.DataStore;
import elevengame.GameInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author david
 */
public class Board implements GameInterface {

    Deck deck;
    private List<Card> boardCards = new ArrayList();
    private final int size = DataStore.getNCards(); //==9
    private short remainingCards;

    public Board() {
        remainingCards = 43;
        deck = new Deck(); //52
        for (int i = 0; i < size; i++) {
            boardCards.add(deck.getDeckCard(0));
            deck.removeCard();
        }
    }

    @Override
    public String getName() {
        return "Eleven Game";
    }

    @Override
    public int nCards() {
        return size;
    }

    @Override
    public int getDeckSize() {
        return remainingCards;
    }

    @Override
    public String getCardDescriptionAt(int index) {
        return boardCards.get(index).getSymbol() + boardCards.get(index).getValue();
    }

    @Override
    public boolean anotherPlayIsPossible() {
        int cQ = 0, cK = 0, cJ = 0;
        for (int i = 0; i < boardCards.size(); i++) {
            for (int j = 1; j < boardCards.size() - i; j++) {
                if (boardCards.get(i).getnPoints() + boardCards.get(j).getnPoints() == 11) {
                    return true;
                }
            }
            if (boardCards.get(i).getValue() == "jack") {
                cJ++;
            }
            if (boardCards.get(i).getValue() == "queen") {
                cQ++;
            }
            if (boardCards.get(i).getValue() == "king") {
                cK++;
            }
        }
        if (cJ > 0 && cQ > 0 && cK > 0) {
            return true;
        }
        return false;
    }

    /**
     * jako moc nefungujou indexy jinak ok
     *
     * @param iSelectedCards
     * @return
     */
    @Override
    public boolean playAndReplace(List<Integer> iSelectedCards) {
        Collections.sort(iSelectedCards);
        int cQ = 0, cK = 0, cJ = 0;
        boolean resume = false;
        if (iSelectedCards.size() == 2) {
            if ((boardCards.get(iSelectedCards.get(0)).getnPoints() + boardCards.get(iSelectedCards.get(1)).getnPoints()) == 11) {
                resume = true;
                for (int i = boardCards.size() - 1; i >= 0; i--) {
                    if (i == (iSelectedCards.get(0)) || i == (iSelectedCards.get(1))) {
                        boardCards.remove(i);
                    }
                }
//             boardCards.remove(iSelectedCards.get(a1)); //smaze karty ze stolu na vybrane pozici
//                boardCards.remove(iSelectedCards.get(1));

            } else {
                return false;
            }
        } else if (iSelectedCards.size() == 3) {
            for (int i = 0; i < 3; i++) {
                if (boardCards.get(iSelectedCards.get(i)).getValue() == "jack") {
                    cJ++;
                }
                if (boardCards.get(iSelectedCards.get(i)).getValue() == "queen") {
                    cQ++;
                }
                if (boardCards.get(iSelectedCards.get(i)).getValue() == "king") {
                    cK++;
                }
            }

            if ((cJ * cQ * cK) == 1) {
                resume = true;
                for (int i = boardCards.size() - 1; i >= 0; i--) {
                    if (i == (iSelectedCards.get(0)) || i == (iSelectedCards.get(1)) || i == (iSelectedCards.get(2))) {
                        boardCards.remove(i);
                    }
                    //boardCards.remove(iSelectedCards.get(i)); //smaze karty na vybranych pozicich
                }
            } else {
                return false;
            }
        }

        //doplneni do boardu
        for (int i = 0; i < iSelectedCards.size(); i++) {
            boardCards.add(deck.getDeckCard(0)); //bere vzdy vrchni kartu
            deck.removeCard();
            remainingCards--;
        }
        return resume;
    }

    @Override
    public boolean isWon() {
        if (deck.isEmpty() && boardCards.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Board{" + ", boardCards=" + boardCards + ", size=" + size + ", remainingCards=" + remainingCards + '}';
    }

    public String getBoard() {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (Card d : boardCards) {
            sb.append(sum + " ");
            sb.append(d.toString() + "\n");
            sum += 1;
        }
        //sb.append(sum);
        sb.append("zbyva " + remainingCards);
        return sb.toString();
    }

    public void removeCards(int index) {
        for (int i = 0; i < boardCards.size(); i++) {
            if (i == index) {
                boardCards.remove(i);
            }
        }

    }
/* Testování
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> iSelectedCards = new ArrayList();
        Board b = new Board();
        System.out.println(b.getBoard());
        int choice1;
        int choice2;

//        if (b.anotherPlayIsPossible()) {
//            System.out.println("ok");
//        } else {
//            System.out.println("ne ok");
//        }
        while (b.anotherPlayIsPossible() && (choice1 = sc.nextInt()) != -2) {
            if (b.anotherPlayIsPossible()) {
                System.out.println("Hra pokracuje");
            } else {
                System.out.println("nemuzes dal hrat, nemas na to soucet");
            }
            System.out.println(b.getBoard()); //display cards
            System.out.println("vyber, ukonci -1");
            iSelectedCards.clear();
            while ((choice2 = sc.nextInt()) != -1) {
                iSelectedCards.add(choice2);
            }

            if (b.playAndReplace(iSelectedCards)) {
                System.out.println("ok");
            } else {
                System.out.println("no");
                sc.nextLine();
            }

        }

    }
*/
}

