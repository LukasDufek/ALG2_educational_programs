/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author david
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> zk = new ArrayList();
        int choice;
        System.out.println("zadej cisla");
         while((choice = sc.nextInt()) != -1){
                zk.add(choice);
            }
         System.out.println("vypsana cisla");
         for (int i = 0; i < zk.size(); i++) {
             System.out.println(zk.get(i).toString());
        }
         
//         System.out.println("remove cisla");
//         for (int i = 0; i < zk.size(); i++) {
//             if (i == 4  || i == 6 || i == 2) {
//                 zk.remove(i);
//             }
//        }
         
         System.out.println("serazeny");
         sortList(zk);
           for (int i = 0; i < zk.size(); i++) {
             System.out.println(zk.get(i).toString());
           }
           
           
           System.out.println("Serazeny collections");
           Collections.sort(zk);
            for (int i = 0; i < zk.size(); i++) {
             System.out.println(zk.get(i).toString());
           }
         
//         for (int i = 0; i < zk.size(); i++) {
//            System.out.println(zk.get(i).toString());
//        }
//         
//         System.out.println("vytvorenej board");
//         Board b = new Board();
//         System.out.println(b.getBoard());
//       
//         for (int i = 0; i < 9; i++) {
//            b.removeCards(i+2);
//        }
//         
//         System.out.println("removnutej board");
//         System.out.println(b.getBoard());
         
         
         
         
         
         
         
    }
    
        public static void sortList(List<Integer> iSelectedCards){
          //serazeni   
        int tmp;
        for (int i = 1; i < iSelectedCards.size(); i++) {
            if (iSelectedCards.get(i - 1) > iSelectedCards.get(i)) {
                tmp = iSelectedCards.get(i-1);
                iSelectedCards.remove(i-1);
                iSelectedCards.add(tmp);
            }
        }
    }
    
}
