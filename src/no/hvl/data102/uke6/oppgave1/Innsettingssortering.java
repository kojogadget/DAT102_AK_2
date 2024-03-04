package no.hvl.data102.uke6.oppgave1;

public class Innsettingssortering {

    /**
     * Sorterer en tabell med innsettingssortering hvor den minste verdien blir
     * flyttet til første indeks, og deretter sorterer tabellen to og to
     * 
     * @param tab tabellen
     */
    public static <T extends Comparable<? super T>> void innsettingSortering2(T[] tab) {
        // Finner minste verdi og flytter den til første indeks
        int minIndeks = finnMinsteIndeks(tab);
        bytt(tab, 0, minIndeks);

        // Sorterer to og to elementer
        for (int i = 1; i < tab.length - 1; i += 2) {
            // Finner minste og storste verdi
            T minste, storste;
            if (tab[i].compareTo(tab[i + 1]) <= 0) {
                minste = tab[i];
                storste = tab[i + 1];
            } else {
                minste = tab[i + 1];
                storste = tab[i];
            }

            int j = i - 1;
            // Finn riktig plass for største
            while (j >= 0 && tab[j].compareTo(storste) > 0) {
                tab[j + 2] = tab[j];
                j--;
            }
            tab[j + 2] = storste;

            // Finn riktig plass for minste
            while (j >= 0 && tab[j].compareTo(minste) > 0) {
                tab[j + 1] = tab[j];
                j--;
            }
            tab[j + 1] = minste;
        }

        // Hvis tabellen har et partall antall elementer vil ikke det siste elementet bli sortert
        // Derfor sorterer vi det siste elementet her
        if (tab.length % 2 == 0) {
            T siste = tab[tab.length - 1];
            int j = tab.length - 2;
            while (j >= 0 && tab[j].compareTo(siste) > 0) {
                tab[j + 1] = tab[j];
                j--;
            }
            tab[j + 1] = siste;
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
