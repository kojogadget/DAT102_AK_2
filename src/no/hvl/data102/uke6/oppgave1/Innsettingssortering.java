package no.hvl.data102.uke6.oppgave1;

public class Innsettingssortering {

    /**
     * Sorterer en tabell med innsettingssortering hvor den minste verdien blir
     * flyttet til første indeks, og deretter sorterer tabellen to og to
     * 
     * @param tab tabellen
     */
    public static <T extends Comparable<? super T>> void innsettingSortering2(T[] tab) {
        int minIndeks = finnMinsteIndeks(tab);
        bytt(tab, 0, minIndeks);

        for (int i = 1; i < tab.length - 1; i += 2) {
            T minste;
            T storste;

            if (tab[i].compareTo(tab[i + 1]) <= 0) {
                minste = tab[i];
                storste = tab[i + 1];
            } else {
                minste = tab[i + 1];
                storste = tab[i];
            }

            int j = i;
            while (j > 0 && tab[j - 1].compareTo(minste) >= 0) {
                tab[j] = tab[j - 1];
                j--;
            }
            tab[j] = minste;

            int k = i + 2;
            while (k < tab.length - 1 && tab[k].compareTo(storste) < 0) {
                tab[k - 1] = tab[k];
                k += 2;
            }
            tab[k - 1] = storste;
        }

        // Hvis tabellen har et partall antall elementer vil ikke det siste elementet bli sortert
        // Derfor sorterer vi det siste elementet her
        if (tab.length % 2 == 0) {
            int j = tab.length - 1;
            while (j >= 0 && tab[j].compareTo(tab[j - 1]) < 0) {
                bytt(tab, j, j - 1);
                j--;
            }
        }
    }

    /**
     * Sorterer en tabell med innsettingssortering hvor den minste verdien blir
     * flyttet til første indeks, og deretter sorterer tabellen
     * 
     * @param tab tabellen
     */
    public static <T extends Comparable<? super T>> void innsettingSortering(T[] tab) {
        int minIndeks = finnMinsteIndeks(tab);
        bytt(tab, 0, minIndeks);

        for (int i = 1; i < tab.length; i++) {
            int j = i;
            while (j >= 0 && tab[j].compareTo(tab[j - 1]) < 0) {
                bytt(tab, j, j - 1);
                j--;
            }
        }
    }

    /**
     * Bytter om to elementer i en tabell
     * 
     * @param tab tabellen
     * @param i   indeksen til det første elementet
     * @param j   indeksen til det andre elementet
     */
    private static <T extends Comparable<? super T>> void bytt(T[] tab, int i, int j) {
        T temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
    }

    /**
     * Finner indeksen til det minste elementet i en tabell
     * 
     * @param tab tabellen
     * @return indeksen til det minste elementet
     */
    private static <T extends Comparable<? super T>> int finnMinsteIndeks(T[] tab) {
        int minIndeks = 0;
        for (int i = 0; i < tab.length - 1; i++) {
            if (tab[i].compareTo(tab[minIndeks]) < 0) {
                minIndeks = i;
            }
        }
        return minIndeks;
    }
}
