package a03_AutoComplete;

import java.util.Comparator;

public class BinarySearchDeluxe {
	
	/*
	 * Corner cases.  Each static method should throw a java.lang.NullPointerException if any of its arguments is null. 
	 */

    // Return the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key extends Comparable<Key>> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator){
        System.out.println("Test");
//        int low = 0;
//        int high = a.length;
//        while (low <= high){
//            int i = (low+high)/2;
//            if (key == a[i]) return i;
//            if (comparator.compare(key, a[i]) < 0){
//                high = i-1;
//            }else if (comparator.compare(key, a[i]) > 0){
//                low = i+1;
//            }
//        }
        return -1;
    }

    // Return the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key extends Comparable<Key>> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator){
        int low = 0;
        int high = a.length;
        while (low <= high){
            int i = (low+high)/2;
            if (key == a[i]) return i;
            if (comparator.compare(key, a[i]) < 0){
                high = i-1;
            }else if (comparator.compare(key, a[i]) > 0){
                low = i+1;
            }
        }
        return -1;
    }
}
