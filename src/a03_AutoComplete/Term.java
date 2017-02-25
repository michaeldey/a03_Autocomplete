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
        this.query = query;
        this.weight = weight;
    }
    
    // Compare the terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder(){
        return byReverseWeightOrderHelper;
    }
    
    private static Comparator<Term> byReverseWeightOrderHelper = new Comparator<Term>(){
        public int compare(Term t1, Term t2){
            double weight1 = t1.getWeight();
            double weight2 = t2.getWeight();
            return Double.compare(weight2 , weight1);
        };
    };

    // Compare the terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r){
        return new ByPrefixOrderHelper(r);
    }
    // Compare the terms in lexicographic order by query.
    public int compareTo(Term that){
        return(Double.compare(this.getWeight(), that.getWeight()));
    }

    // Return a string representation of the term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString(){
        return " ";
    }

    public String getQuery() {
        return query;
    }

    public double getWeight() {
        return weight;
    }
        
    // Compare the terms in lexicographic order but using only the first r characters of each query.
    private static class ByPrefixOrderHelper implements Comparator<Term> {
        private int r;
        ByPrefixOrderHelper(int r){
            setR(r);
        }
        
        private void setR(int r){
            this.r = r;
        }
        
        public int compare(Term t1, Term t2){
                String query1 = t1.getQuery().substring(0, r);
                String query2 = t2.getQuery().substring(0, r);
                return query1.compareToIgnoreCase(query2);
        };
    };
        
}

