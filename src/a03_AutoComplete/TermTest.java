package a03_AutoComplete;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TermTest {

	@Test
	public void testTerm() {
		//test constructor is working
		Term myTerm = new Term("aa",2.0);
		assertEquals("aa", myTerm.query);
		assertTrue(myTerm.weight==2.0);
	}
	
	@Rule public ExpectedException thrown = ExpectedException.none();
	
	//test null Query fed to Term
	@Test
	public void testNullQuery(){
		thrown.expect(NullPointerException.class);
    	thrown.expectMessage("Query can not be Null.");
		Term myTerm = new Term(null, 2.0);
	}
	
	//test Negative weight sent to Term
	@Test
	public void testNegativeWeight(){
		thrown.expect(IllegalArgumentException.class);
    	thrown.expectMessage("Weight can not be Negative.");
		Term myTerm = new Term("aa", -2.0);
	}

	@Test
	public void testByReverseWeightOrder() {
		//Term a should be < Term b
        Term a = new Term("aa",2.0);
        Term b = new Term("ab",1.0);
        Comparator c = Term.byReverseWeightOrder();
        
        assertEquals(c.compare(a, a), 0); 			//test if Term a == Term a
        assertNotEquals(c.compare(a, a), 1); 		//test if Term a !> Term a
        assertNotEquals(c.compare(a, a), -1); 		//test if Term a !< Term a
        
        assertEquals(c.compare(a, b), -1);			//test if Term a < Term b
        assertNotEquals(c.compare(a, b), 0);		//test if Term a != Term b
        assertNotEquals(c.compare(a, b), 1);		//test if Term a !> Term b
        
        assertEquals(c.compare(b, a), 1);			//test if Term b > Term a
        assertNotEquals(c.compare(b, a), -1);		//test if Term b !< Term a
        assertNotEquals(c.compare(b, a), 0);		//test if Term b != Term a
	}

	@Test
	public void testByPrefixOrder() {
        Term a = new Term("aa",2.0);
        Term b = new Term("ab",1.0);
        Comparator d = Term.byPrefixOrder(1);		//there is 1 prefix, so a = b

        assertEquals(d.compare(a, a), 0);			//test if Term a == Term a with 1 prefix
        assertNotEquals(d.compare(a, a), -1);		//test if Term a !< Term a with 1 prefix
        assertNotEquals(d.compare(a, a), 1);		//test if Term a !> Term a with 1 prefix
        
        assertEquals(d.compare(a, b), 0);			//test if Term a == Term b with 1 prefix
        assertNotEquals(d.compare(a, b), -1);		//test if Term a !< Term b with 1 prefix
        assertNotEquals(d.compare(a, b), 1);		//test if Term a !> Term b with 1 prefix
        
        assertEquals(d.compare(b, a), 0);			//test if Term b == Term a with 1 prefix
        assertNotEquals(d.compare(b, a), -1);		//test if Term b !< Term a with 1 prefix
        assertNotEquals(d.compare(b, a), 1);		//test if Term b !> Term a with 1 prefix
        

        d = Term.byPrefixOrder(2);					//now there are 2 prefixes, so a < b
        
        assertEquals(d.compare(a, a), 0);			//test if Term a == Term a with 2 prefix
        assertNotEquals(d.compare(a, a), -1);		//test if Term a !< Term a with 2 prefix
        assertNotEquals(d.compare(a, a), 1);		//test if Term a !> Term a with 2 prefix
        
        assertEquals(d.compare(a, b), -1);			//test if Term a < Term b with 2 prefix
        assertNotEquals(d.compare(a, b), 0);		//test if Term a != Term b with 2 prefix
        assertNotEquals(d.compare(a, b), 1);		//test if Term a !> Term b with 2 prefix
        
        assertEquals(d.compare(b, a), 1);			//test if Term b > Term a with 2 prefix
        assertNotEquals(d.compare(b, a), -1);		//test if Term b !< Term a with 2 prefix
        assertNotEquals(d.compare(b, a), 0);		//test if Term b != Term a with 2 prefix
	}

	@Test
	public void testCompareTo() {
		//Term a should be > Term b
        Term a = new Term("aa",1.0);
        Term b = new Term("bb",1.0);
                
        assertEquals(a.compareTo(a), 0); 			//test if Term a == Term a
        assertNotEquals(a.compareTo(a), 1); 		//test if Term a !> Term a
        assertNotEquals(a.compareTo(a), -1); 		//test if Term a !< Term a
        
        assertEquals(a.compareTo(b), -1);			//test if Term a < Term b
        assertNotEquals(a.compareTo(b), 0);			//test if Term a != Term b
        assertNotEquals(a.compareTo(b), 1);			//test if Term a !> Term b
        
        assertEquals(b.compareTo(a), 1);			//test if Term b > Term a
        assertNotEquals(b.compareTo(a), 0);			//test if Term b != Term a
        assertNotEquals(b.compareTo(a), -1);		//test if Term b !< Term a
	}

	@Test
	public void testToString() {
		Term a = new Term("aa",2.0);
		String testString = "2.0\taa";				//this should be the value of a.toString()
		assertEquals(testString, a.toString());		//test a.toString is the same value 
		assertNotEquals("", a.toString());			//test a.toString isn't falsely returning as equal to any String value
	}

}
