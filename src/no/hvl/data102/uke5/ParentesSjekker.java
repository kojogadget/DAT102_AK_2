package no.hvl.data102.uke5;

import java.util.Set;

public class ParentesSjekker {
	
	private static final Set<Character> STARTPARENTESER = Set.of('{', '(', '[', '<');
	private static final Set<Character> SLUTTPARENTESER = Set.of('}', ')', ']', '>');
	private static final Set<String>    PARENTESPAR = Set.of("{}", "()", "[]", "<>");
	
	public static boolean sjekkParenteser(String s) {
		
		StabelADT<Character> stabel = new TabellStabel<>();

		char[] test = s.toCharArray();

		for (char c : test) {
			if (erStartParentes(c)) {
				stabel.push(c);
			} else if (erSluttParentes(c)) {
				if (stabel.isEmpty()) {
					return false;
				}

				if (!erParentesPar(stabel.pop(), c)) {
					return false;
				}
			}
		}

		return true;
	}

	private static boolean erStartParentes(char c) {

		return STARTPARENTESER.contains(c);
	}
	
	private static boolean erSluttParentes(char c) {

		return SLUTTPARENTESER.contains(c);
	}
	
	private static boolean erParentesPar(char start, char slutt) {
		
		return PARENTESPAR.contains(String.valueOf(start) + String.valueOf(slutt));
	}
}
