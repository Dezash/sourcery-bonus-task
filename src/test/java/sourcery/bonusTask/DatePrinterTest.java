package sourcery.bonusTask;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DatePrinterTest
{
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void printBonusDatesBetween_2011to2012_2011_11_02()
    {
        String[] expected = new String[] {"2011-11-02"};

        DatePrinter.printBonusDatesBetween(2011, 2012);
        assertEquals(String.join(System.getProperty("line.separator"), expected), outputStreamCaptor.toString().trim());
    }

    @Test
    void printBonusDatesBetween_2010to2015_twoDates()
    {
        String[] expected = new String[] {"2010-01-02", "2011-11-02"};

        DatePrinter.printBonusDatesBetween(2010, 2015);
        assertEquals(String.join(System.getProperty("line.separator"), expected), outputStreamCaptor.toString().trim());
    }

    @Test
    void printBonusDatesBetween_9250to10000_fiveDates()
    {
        String[] expected = new String[] {"9250-05-29", "9260-06-29", "9270-07-29", "9280-08-29", "9290-09-29"};

        DatePrinter.printBonusDatesBetween(9250, 10000);
        assertEquals(String.join(System.getProperty("line.separator"), expected), outputStreamCaptor.toString().trim());
    }

    @Test
    void printBonusDatesBetween_0to999_noResult()
    {
        DatePrinter.printBonusDatesBetween(0, 999);
        assertEquals("", outputStreamCaptor.toString().trim());
    }

    @Test
    void printBonusDatesBetween_10000toMaxInt_noResult()
    {
        DatePrinter.printBonusDatesBetween(10000, Integer.MAX_VALUE);
        assertEquals("", outputStreamCaptor.toString().trim());
    }
}
