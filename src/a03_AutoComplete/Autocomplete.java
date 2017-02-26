package a03_AutoComplete;

public class Autocomplete {
	/*
	 * Corner cases.  The constructor and each method should throw a java.lang.NullPointerException its argument is null.
	 */

    // Initialize the data structure from the given array of terms.
    public Autocomplete(Term[] terms){
        
    }


    // Return all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix){
        Term[] a = {new Term("a",1.0), new Term("a",1.0)};
        return a;
    }

    // Return the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix){
        return -1;
    }
}
