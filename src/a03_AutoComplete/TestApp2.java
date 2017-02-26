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
public class TestApp2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Term a = new Term("aa",2.0);
//        Term b = new Term("ab",1.0);
//        Comparator c = Term.byReverseWeightOrder();
//        Comparator d = Term.byPrefixOrder(1);
//        System.out.println(c.compare(a, a));
//        System.out.println(c.compare(a, b));
//        System.out.println(c.compare(b, a));
//        System.out.println(d.compare(a, a));
//        System.out.println(d.compare(a, b));
//        System.out.println(d.compare(b, a));
//        d = Term.byPrefixOrder(2);
//        System.out.println(d.compare(a, a));
//        System.out.println(d.compare(a, b));
//        System.out.println(d.compare(b, a));
//        System.out.println(a);
//        System.out.println(b);
        Term m1 = new Term("aa", 1.0);
        Term m2 = new Term("aa", 1.0);
        Term m3 = new Term("aa", 1.0);
        
        
        Term[] tArray = new Term[]{m1,m2,m3};
        
        System.out.println("test 1");
        
//        BinarySearchDeluxe<Term> search = new BinarySearchDeluxe<>();
        
//        System.out.println(search.firstIndexOf(tArray, tArray[1], Term.byPrefixOrder(1)));
        
        System.out.println("first index:");
        System.out.println(BinarySearchDeluxe.firstIndexOf(tArray, tArray[0], Term.byPrefixOrder(1)));
        
    }
    
}
