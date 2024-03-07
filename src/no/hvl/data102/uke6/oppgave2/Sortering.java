package no.hvl.data102.uke6.oppgave2;

public class Sortering {
    /**
     * Sorterer en tabell med innsettingssortering.
     * Hjelpefunksjon for å sortere hele tabellen.
     *
     * @param tab tabellen som skal sorteres
     */
    public static <T extends Comparable<? super T>> void innsettingssortering(T[] tab) {
        innsettingssortering(tab, 0, tab.length);
    }

    /**
     * Sorterer en del av en tabell med innsettingssortering.
     *
     * @param tab     tabellen som skal sorteres.
     * @param forste  indeks for den første i deltabellen som skal sorteres.
     * @param siste   indeks for den siste delen i tabellen som skal sorteres.
     */
    private static <T extends Comparable<? super T>> void innsettingssortering(T[] tab, int forste, int siste) {
        for (int i = forste; i < siste; i++) {
            T temp = tab[i];
            int j = i - 1;

            while (j >= 0 && temp.compareTo(tab[j]) < 0) {
                tab[j + 1] = tab[j];
                j--;
            }

            tab[j + 1] = temp;
        }
    }

    /**
     * Sorterer en tabell med utvalgssortering.
     * Hjelpefunksjon for å sortere hele tabellen.
     *
     * @param tab tabellen som skal sorteres.
     */
	public static <T extends Comparable<? super T>> void utvalgssortering(T[] tab) {
		utvalgssortering(tab, tab.length);
	}

    /**
     * Sorterer en del av en tabell med utvalgssortering.
     *
     * @param tab tabellen som skal sorteres.
     * @param n   antall elementer som skal sorteres.
     */
	private static <T extends Comparable<? super T>> void utvalgssortering(T[] tab, int n) {

        for (int i = 0; i < n - 1; i++) {
            T min = tab[i];
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (tab[j].compareTo(min) < 0) {
                    min = tab[j];
                    minIndex = j;
                }
            }

            bytt(tab, i, minIndex);
        }
    }
    
    /**
     * Sorterer en tabell med kvikksortering.
     * Hjelpefunksjon for å sortere hele tabellen.
     *
     * @param tab tabellen som skal sorteres.
     */
    public static <T extends Comparable<? super T>> void kvikksortering(T[] tab) {
        kvikksortering(tab, 0, tab.length - 1);
        innsettingssortering(tab);
    }

    /**
     * Sorterer en del av en tabell med kvikksortering.
     *
     * @param tab     tabellen som skal sorteres.
     * @param forste  indeks for den første i deltabellen som skal sorteres.
     * @param siste   indeks for den siste delen i tabellen som skal sorteres.
     */
    private static <T extends Comparable<? super T>> void kvikksortering(T[] tab, int forste, int siste) {
		if (siste - forste + 1 < 3) {
			 // Basistilfelle: Gjør ingenting
		} else {
			int delepunkt = partition(tab, forste, siste);
			kvikksortering(tab, forste, delepunkt - 1);
			kvikksortering(tab, delepunkt + 1, siste);	
		}
    }

    /**
     * Partisjonerer en tabell slik at elementer mindre enn et pivot-element
     * kommer før, og elementer større enn pivoten kommer etter.
     *
     * @param tab     tabellen som skal partisjoneres.
     * @param forste  indeks for den første i deltabellen som skal partisjoneres.
     * @param siste   indeks for den siste delen i tabellen som skal partisjoneres.
     * @return        indeksen til pivoten.
     */
    private static <T extends Comparable<? super T>> int partition(T[] tab, int forste, int siste) {
		int midten = (forste + siste) / 2;

		// Sorterer første, midterse og siste element slik at de står i stigende rekkefølge til hverandre
		sorterForstMidtSist(tab, forste, midten, siste);

		// Flytter pivot elementet til nest siste plass
		bytt(tab, midten, siste - 1);
		int pivotIndex = siste - 1;
		T pivotValue = tab[pivotIndex];

		// Finn første i venstre del som er mindre enn pivot
		// siste elementet i høyre del som er mindre enn pivot
		int fraVenstre = forste + 1;
		int fraHogre = siste - 2;
		boolean ferdig = false;

        // Loop til fraVenstre og fraHogre krysser hverandre
		while (!ferdig) {

			while (tab[fraVenstre].compareTo(pivotValue) < 0) {
				fraVenstre++;
			}

			while (tab[fraHogre].compareTo(pivotValue) > 0) {
				fraHogre--;
			}

			if (fraVenstre < fraHogre) {
				bytt(tab, fraVenstre, fraHogre);
				fraVenstre++;
				fraHogre--;
			} else {
				ferdig = true;
			}
		}

		// Flytter pivot elementet tilbake til midten mellom fraVenstre og fraHogre
		bytt(tab, pivotIndex, fraVenstre);
		pivotIndex = fraVenstre;

        // Returner indeksen til pivot elementet
		return pivotIndex;
    }

    /**
     * Sorterer tre elementer i en tabell slik at de står i stigende rekkefølge.
     *
     * @param tab     tabellen som skal sorteres.
     * @param forste  indeks for den første i deltabellen som skal sorteres.
     * @param midten  indeks for den midterste i deltabellen som skal sorteres.
     * @param siste   indeks for den siste delen i tabellen som skal sorteres.
     */
    private static <T extends Comparable<? super T>> void sorterForstMidtSist(T[] tab, int forste, int midten, int siste) {
		sorter(tab, forste, midten); 
		sorter(tab, midten, siste); 
		sorter(tab, forste, midten);
    }

    /**
     * Sorterer en tabell med flettesortering.
     * Hjelpefunksjon for å sortere hele tabellen.
     *
     * @param tab tabellen som skal sorteres.
     */
    public static <T extends Comparable<? super T>> void flettesortering(T[] tab) {
        flettesortering(tab, 0, tab.length - 1);
    }

    /**
     * Sorterer en del av en tabell med flettesortering.
     * Lager en hjelpetabell for sorteringen.
     *
     * @param tab     tabellen som skal sorteres.
     * @param forste  indeks for den første i deltabellen som skal sorteres.
     * @param siste   indeks for den siste delen i tabellen som skal sorteres.
     */
    private static <T extends Comparable<? super T>> void flettesortering(T[] tab, int forste, int siste) {

		// Undertrykker warning fordi det nye arrayet ikke inneholder noen elementer
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Comparable<?>[tab.length];

		flettesortering(tab, temp, forste, siste);
    }

    /**
     * Sorterer en del av en tabell med flettesortering ved rekursjon.
     *
     * @param tab      tabellen som skal sorteres.
     * @param tempTab  hjelpetabell for sorteringen.
     * @param forste   indeks for den første i deltabellen som skal sorteres.
     * @param siste    indeks for den siste delen i tabellen som skal sorteres.
     */
    private static <T extends Comparable<? super T>> void flettesortering(T[] tab, T[] tempTab, int forste, int siste) {
		if (forste >= siste) {
			 // Basistilfelle: Gjør ingenting
		} else {
			int midt = (forste + siste) / 2;
			flettesortering(tab, tempTab, forste, midt);
			flettesortering(tab, tempTab, midt + 1, siste);
			flett(tab, tempTab, forste, midt, siste);
		}
    }

    /**
     * Fletter sammen to deler av en tabell til stigende rekkefølge.
     *
     * @param tab      tabellen som skal flettes.
     * @param tempTab  hjelpetabell for flettingen.
     * @param forste   indeks for den første i deltabellen som skal flettes.
     * @param midten   indeks for den midterste i deltabellen som skal flettes.
     * @param siste    indeks for den siste delen i tabellen som skal flettes.
     */
	private static <T extends Comparable<? super T>> void flett(T[] tab, T[] tempTab, int forste, int midten, int siste) {

		// Fletter sammen to deler som ligger ved siden av hverandre
        // Delene er [forste, midten] og [midten + 1, siste]
		int forsteVenstre = forste;
		int sluttVenstre = midten;
		int forsteHoyre = midten + 1;
		int sluttHoyre = siste;

		// Så lenge det er element igjen i begge delene, flytt over den minste til tempTab
		int index = forsteVenstre; // Neste ledige plass i tempTab
		for (; (forsteVenstre <= sluttVenstre) && (forsteHoyre <= sluttHoyre); index++) {
			if (tab[forsteVenstre].compareTo(tab[forsteHoyre]) < 0) {
				tempTab[index] = tab[forsteVenstre];
				forsteVenstre++;
			} else {
				tempTab[index] = tab[forsteHoyre];
				forsteHoyre++;
			}
		}

		// Sjekk om det er elementer igjen i en av delene, og kopier over
		// Venstre del, kan være tom
		for (; forsteVenstre <= sluttVenstre; forsteVenstre++, index++) {
			tempTab[index] = tab[forsteVenstre];
		}

		// Høyre del, kan være tom
		for (; forsteHoyre <= sluttHoyre; forsteHoyre++, index++) {
			tempTab[index] = tab[forsteHoyre];
		}

		// Kopier den sorterte delen tilbake
		for (index = forste; index <= siste; index++) {
			tab[index] = tempTab[index];
		}
	}

    /**
     * Bytter om to elementer i en tabell hvis det ene er større enn det andre.
     *
     * @param tab tabellen der byttingen skal skje.
     * @param i   indeksen til det første elementet.
     * @param j   indeksen til det andre elementet.
     */
    private static <T extends Comparable<? super T>> void sorter(T[] tab, int i, int j) {
        if (tab[j].compareTo(tab[i]) < 0) {
            bytt(tab, i, j);
        }
    }

    /**
     * Bytter om to elementer i en tabell.
     *
     * @param tab tabellen der byttingen skal skje.
     * @param i   indeksen til det første elementet.
     * @param j   indeksen til det andre elementet.
     */
	private static void bytt(Object[] tab, int i, int j) {
		Object temp = tab[i];
		tab[i] = tab[j];
		tab[j] = temp;
	}

}
