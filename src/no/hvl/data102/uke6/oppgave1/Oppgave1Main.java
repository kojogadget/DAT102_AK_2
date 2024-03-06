package no.hvl.data102.uke6.oppgave1;

import java.util.Random;

public class Oppgave1Main {
        
    public static void main(String[] args) {
        int n = 32000;
        int antall = 10;

        Integer[][] a = new Integer[antall][n];
        Integer[][] b = new Integer[antall][n];

        lagRandomListe(a, antall, n);
        lagRandomListe(b, antall, n);

        // Test kjøretid på vanlig innsettingssortering
        long start = (int) System.currentTimeMillis();         
        
        for (int i = 0; i < antall; i++) {
            Innsettingssortering.innsettingSortering(a[i]);  
        }
       
        long slutt = (int) System.currentTimeMillis();        

        System.out.println("Tid vanlig: " + ((slutt - start) / 1000F) + " sekunder");
       
        // Test kjøretid på modifisert innsettingssortering
        start = (int) System.currentTimeMillis();           
        
        for (int i = 0; i < antall; i++) {
            Innsettingssortering.innsettingSortering2(a[i]);
        }

        slutt = (int) System.currentTimeMillis();          

        System.out.println("Tid modifisert: " + ((slutt - start) / 1000F) + " sekunder");
    }

    private static void lagRandomListe(Integer[][] tab, int antall, int n) {
        Random tilfeldig = new Random();

        for (int i = 0; i < antall; i++) {
            for (int j = 0; j < n; j++) {
                tab[i][j] = tilfeldig.nextInt();
            }
        }

    }
}
