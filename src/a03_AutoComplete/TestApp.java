/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a03_AutoComplete;

import a03_AutoComplete.Term;
import java.util.Comparator;

/**
 *
 * @author Owner
 */
public class TestApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Term a = new Term("aa",2.0);
        Term b = new Term("ab",1.0);
        Comparator c = Term.byReverseWeightOrder();
        Comparator d = Term.byPrefixOrder(1);
        System.out.println(c.compare(a, a));
        System.out.println(c.compare(a, b));
        System.out.println(c.compare(b, a));
        System.out.println(d.compare(a, a));
        System.out.println(d.compare(a, b));
        System.out.println(d.compare(b, a));
        d = Term.byPrefixOrder(2);
        System.out.println(d.compare(a, a));
        System.out.println(d.compare(a, b));
        System.out.println(d.compare(b, a));
        
        Term m1 = new Term("aa",2.0);
        Term m2 = new Term("ba",1.0);
        Term m3 = new Term("ca",2.5);
        
        Term[] myArray = new Term[]{m1, m2, m3};
        
        System.out.println("first index:");
        System.out.println(BinarySearchDeluxe.firstIndexOf(myArray, myArray[0], d));
        
        System.out.println("last index:");
        System.out.println(BinarySearchDeluxe.lastIndexOf(myArray, myArray[1], d));
    }
    
}
