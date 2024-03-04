package no.hvl.data102.uke6.oppgave1;

import java.util.Random;

public class Oppgave1Main {
        
    public static void main(String[] args) {
        
        Random tilfeldig = new Random();
        int n = 32000;
        int antall = 10;

        Integer[][] a = new Integer[antall][n];

        // set inn tilfeldige heltall i alle rekkene
        for (int i = 0; i < antall; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = tilfeldig.nextInt();
            }
        }

        // start tidsmåling
        long start = (int) System.currentTimeMillis();

        // sorter alle radene
        for (int i = 0; i < antall; i++) {
            Innsettingssortering.innsettingSortering(a[i]);
        }

        // slutt tidsmåling
        long slutt = (int) System.currentTimeMillis();

        System.out.println("Tid: " + ((slutt - start) / 1000F) + " sekunder");

    }
}
