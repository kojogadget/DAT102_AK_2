package no.hvl.data102.uke5;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ParentesSjekkerTest {

	@Test
	void test() {
		
		String s1 = "{ [ ( ) ] }"; //er korrekt
		String s2 = "{ [ ( ) }";   //er ikke korrekt. Mangler sluttparentes ]
		String s3 =	"[ ( ) ] }";   //er ikke korrekt. Mangler startparentes {
		String s4 = "{ [ ( ] ) }";  //er ikke korrekt. Sluttparentes ] kommer for tidlig.

		String s5 = """
			class HelloWorld {
			    public static void main(String[] args) {
			        System.out.println("Hello World!");
			    }
			} """; //er korrekt
		
		String s6 = "";
		String s7 = "()";
		
        assertTrue(ParentesSjekker.sjekkParenteser(s1));
        assertFalse(ParentesSjekker.sjekkParenteser(s2));
        assertFalse(ParentesSjekker.sjekkParenteser(s3));
        assertFalse(ParentesSjekker.sjekkParenteser(s4));
        assertTrue(ParentesSjekker.sjekkParenteser(s5));
        assertTrue(ParentesSjekker.sjekkParenteser(s6));
        assertTrue(ParentesSjekker.sjekkParenteser(s7));
		
	}

}
