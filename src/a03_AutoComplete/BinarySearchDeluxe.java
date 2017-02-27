package a03_AutoComplete;

import java.util.Comparator;

public class BinarySearchDeluxe {
	
	/*
	 * Corner cases.  Each static method should throw a java.lang.NullPointerException if any of its arguments is null. 
	 */

    // Return the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key extends Comparable<Key>> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator){
    	validate(a, key, comparator);
        int low = 0;
        int high = a.length;
        while (low <= high){
            int i = (low+high)/2;
            if (comparator.compare(key, a[i]) == 0) {
            	if (i == 0)return i;
            	if (comparator.compare(key, a[i-1]) == 0){
            		high = i-1;
            	} else return i;
            }
            if (comparator.compare(key, a[i]) < 0){
                high = i-1;
            }else if (comparator.compare(key, a[i]) > 0){
                low = i+1;
            }
        }
        return -1;
    }

    // Return the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key extends Comparable<Key>> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator){
    	validate(a, key, comparator);
        int low = 0;
        int high = a.length;
        while (low <= high){
            int i = (low+high)/2;
            if (comparator.compare(key, a[i]) == 0) {
                	if (i == a.length-1)return i;
                	if (comparator.compare(key, a[i+1]) == 0){
                		low = i+1;
                	} else return i;
            }
            if (comparator.compare(key, a[i]) < 0){
                high = i-1;
            }else if (comparator.compare(key, a[i]) > 0){
                low = i+1;
            }
        }
        return -1;
    }
    
    private static <Key> void validate(Key[] a, Key key, Comparator<Key> comparator){
    	if (a == null)throw new NullPointerException("Array can not be Null.");
    	if (key == null)throw new NullPointerException("Key can not be Null.");
    	if (comparator == null)throw new NullPointerException("Comparator can not be Null.");
    }
}
