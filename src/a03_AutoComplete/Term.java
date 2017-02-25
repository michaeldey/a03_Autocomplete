/*
 * Michael Dey Walter Scott Domain
 * CSIS 2420
 * Assignment A03_Autocomplete
 */

package a03_AutoComplete;

import java.util.Comparator;

public class Term implements Comparable<Term> {


    // Initialize a term with the given query string and weight.
    public Term(String query, double weight)
    {
    	/*
    	 * The constructor should throw a java.lang.NullPointerException if query is null and a java.lang.IllegalArgumentException 
    	 * unless weight is nonnegative. The byPrefixOrder() method should throw a java.lang.IllegalArgumentException if r is negative.
    	 */
    }

    // Compare the terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder()
    {
		return null;    	
    }

    // Compare the terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r)
    {
		return null;    	
    }

    // Compare the terms in lexicographic order by query.
    public int compareTo(Term that)
    {
    	return 0;
    }

    // Return a string representation of the term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString()
    {
    	return null;
    }
}