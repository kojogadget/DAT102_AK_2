package no.hvl.data102.uke6.oppgave2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SorteringTest {

    Integer[] tab;
    Integer[] tab2;
    Integer[] tab3;   
    String[] tab4;   

    @BeforeEach
    void setUp() {
        tab = new Integer[]{8, 3, 5, 7, 2, 4, 9, 1, 6};
        tab2 = new Integer[]{8, 5, 3, 6, 1, 7, 4, 2};
        tab3 = new Integer[]{2, 1, 2, 3, 2, 3, 1, 1, 3};
        tab4 = new String[]{"B", "A", "D", "C"};
    }

    @AfterEach
    void sjekkSortert() {
        assertEquals(1, tab[0]);
        assertEquals(2, tab[1]);
        assertEquals(3, tab[2]);
        assertEquals(4, tab[3]);
        assertEquals(5, tab[4]);
        assertEquals(6, tab[5]);
        assertEquals(7, tab[6]);
        assertEquals(8, tab[7]);
        assertEquals(9, tab[8]);

        assertEquals(1, tab2[0]);
        assertEquals(2, tab2[1]);
        assertEquals(3, tab2[2]);
        assertEquals(4, tab2[3]);
        assertEquals(5, tab2[4]);
        assertEquals(6, tab2[5]);
        assertEquals(7, tab2[6]);
        assertEquals(8, tab2[7]);

        assertEquals(1, tab3[0]);
        assertEquals(1, tab3[1]);
        assertEquals(1, tab3[2]);
        assertEquals(2, tab3[3]);
        assertEquals(2, tab3[4]);
        assertEquals(2, tab3[5]);
        assertEquals(3, tab3[6]);
        assertEquals(3, tab3[7]);
        assertEquals(3, tab3[8]);

        assertEquals("A", tab4[0]);
        assertEquals("B", tab4[1]);
        assertEquals("C", tab4[2]);
        assertEquals("D", tab4[3]);
    }

    @Test
    void testInnsetting() {
        Sortering.innsettingssortering(tab);
        Sortering.innsettingssortering(tab2);
        Sortering.innsettingssortering(tab3);
        Sortering.innsettingssortering(tab4);
    }

    @Test
    void testUtvalg() {
        Sortering.utvalgssortering(tab);
        Sortering.utvalgssortering(tab2);
        Sortering.utvalgssortering(tab3);
        Sortering.utvalgssortering(tab4);
    }

    @Test
    void testKvikk() {
        Sortering.kvikksortering(tab);
        Sortering.kvikksortering(tab2);
        Sortering.kvikksortering(tab3);
        Sortering.kvikksortering(tab4);
    }

    @Test
    void testFlette() {
        Sortering.flettesortering(tab);
        Sortering.flettesortering(tab2);
        Sortering.flettesortering(tab3);
        Sortering.flettesortering(tab4);
    }
}
