package no.hvl.data102.uke6.oppgave2;

// import java.util.Random;

public class OppgaveMain {
	public static void main(String[] args) {
		int n = 128000;
		int antall = 10;

		Integer[][] a = new Integer[antall][n];

		for (int i = 0; i < antall; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = j;
			}
		}

		// Test kjøretid på vanlig innsettingssortering
		long start = (int) System.currentTimeMillis();         

		for (int i = 0; i < antall; i++) {
			Sortering.kvikksortering(a[i]);
		}

		long slutt = (int) System.currentTimeMillis();        

		System.out.println("Tid: " + ((slutt - start) / 1000F) + " sekunder");
	}

	// private static void lagRandomListe(Integer[][] tab, int antall, int n) {
	// 	Random tilfeldig = new Random();
	//
	// 	for (int i = 0; i < antall; i++) {
	// 		for (int j = 0; j < n; j++) {
	// 			tab[i][j] = tilfeldig.nextInt();
	// 		}
	// 	}
	//
	// }
}
