/*
 * Michael Dey Walter Scott Domain
 * CSIS 2420
 * Assignment A03_Autocomplete
 */

package a03_AutoComplete;

import java.util.Comparator;

public class Term implements Comparable<Term> {
	/*
	 * The constructor should throw a java.lang.NullPointerException if query is null and a java.lang.IllegalArgumentException 
	 * unless weight is nonnegative. The byPrefixOrder() method should throw a java.lang.IllegalArgumentException if r is negative.
	 */
         final String query;
         final double weight;

    // Initialize a term with the given query string and weight.
    public Term(String query, double weight){
        if (query == null){
            throw new NullPointerException("Query can not be Null.");
        }
        if (weight < 0.0){
            throw new IllegalArgumentException("Weight can not be Negative.");
        }
        this.query = query;
        this.weight = weight;
    }
    
    // Compare the terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder(){
        return byReverseWeightOrderHelper;
    }
    
    // Helper for byReverseWeightOrder() Makes code easier to understand and maintaine.
    private static Comparator<Term> byReverseWeightOrderHelper = new Comparator<Term>(){
        public int compare(Term t1, Term t2){
            double weight1 = t1.weight;
            double weight2 = t2.weight;
            return Double.compare(weight2 , weight1);
        };
    };

    // Compare the terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r){
        return new ByPrefixOrderHelper(r);
    }
    
    // Compare the terms in lexicographic order by query.
    
    //@Override
    public int compareTo(Term that){
        return(this.query.compareTo(that.query));
    }

    // Return a string representation of the term in the following format:
    // the weight, followed by a tab, followed by the query.
    @Override
    public String toString(){
        return this.weight + "\t" + this.query;
    }
        
    // Compare the terms in lexicographic order but using only the first r characters of each query.
    private static class ByPrefixOrderHelper implements Comparator<Term> {
        private int r;
        ByPrefixOrderHelper(int r){
            setR(r);
        }
        
        private void setR(int r){
            if(r >= 0){
                this.r = r;
            } else {
                throw new IllegalArgumentException("Can not compare String with less then 0 Characters.");
            }
        }
        
        public int compare(Term t1, Term t2){
                String query1 = t1.query.substring(0, r);
                String query2 = t2.query.substring(0, r);
                return query1.compareToIgnoreCase(query2);
        };
    }
        
}
