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
//        System.out.println();
//        d = Term.byPrefixOrder(2);
//        System.out.println(d.compare(a, a));
//        System.out.println(d.compare(a, b));
//        System.out.println(d.compare(b, a));
//        System.out.println(a);
//        System.out.println(b);
        Term m0 = new Term("aa", 1.0);
        Term m1 = new Term("ba", 1.0);
        Term m2 = new Term("bb", 1.0);
        Term m3 = new Term("bb", 1.0);
        Term m4 = new Term("bc", 1.0);
        Term m5 = new Term("bd", 1.0);
        Term m6 = new Term("be", 1.0);
        Term m7 = new Term("be", 1.0);
        Term m8 = new Term("be", 1.0);
        Term m9 = new Term("ca", 1.0);
        
        Term[] tArray = new Term[]{m0,m1,m2,m3,m4,m5,m6,m7,m8,m9};
        
        System.out.println("test 1");
        
        System.out.println(BinarySearchDeluxe.firstIndexOf(tArray, tArray[8], Term.byPrefixOrder(2)));
        
        System.out.println(BinarySearchDeluxe.lastIndexOf(tArray, tArray[7], Term.byPrefixOrder(2)));
        
    }
    
}
