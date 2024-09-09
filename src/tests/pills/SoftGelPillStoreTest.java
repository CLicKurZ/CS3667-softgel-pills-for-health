package pills;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * This is the test suite for the SoftGelPillStore class.
 *
 * @author Squad Dos
 * @version 6.29.23
 */
class SoftGelPillStoreTest 
{
    private SoftGelPillStore store;
    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private final PrintStream oldOut = System.out;

    /**
     * This is the BeforeEach method. 
     * Sets up the output streams before each test.
     * @throws RemoteException
     */
    @BeforeEach
    public void beforeEach() throws RemoteException
    {
        store = new SoftGelPillStore();
        System.setOut(new PrintStream(baos));
    }

    /**
     * This is the AfterEach method.
     * Restores the output streams after each test.
     */
    @AfterEach
    public void afterEach()
    {
        System.setOut(oldOut);
    }

    @Test
    public void testLogInAndLogOut() 
    {
        store.logIn("John Doe", 0);
        assertTrue(store.logOut());
    }

    @Test
    public void testCheckOut() 
    {
        store.checkOut();
        String output = baos.toString().trim();
        assertEquals("", output);
    }


    @Test
    public void testSetOutput() 
    {
        PrintStream newOutput = new PrintStream(baos);
        store.setOutput(newOutput);
        assertEquals(newOutput, store.getOutput());
    }

    @Test
    public void testSetInput() 
    {
        Scanner newInput = new Scanner(System.in);
        store.setInput(newInput);
        assertEquals(newInput, store.getInput());
    }

    @Test
    public void testStrengthValues() 
    {
        store.logIn("John Doe", 0);

        assertEquals(0, store.getDreamlyStrength());
        assertEquals(0, store.getAcheAwayStrength());
    }

    @Test
    public void testPrintEmptyOrder() 
    {
        store.printCurrentOrder();
        String output = baos.toString().trim();
        assertEquals("", output);
    }

}
