package pills;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;

/**
 * This is the test suite for the ActivesTest class.
 *
 * @author Squad Dos
 * @version 6.17.23
 */
public class ActivesTest
{
    private static final double CORRECT_VOLUME = 7.50;
    private static final ActiveIngredient CORRECT_ACETAMINOPHEN_RETURN =
        ActiveIngredient.ACETAMINOPHEN;
    private static final ActiveIngredient CORRECT_ZOLPIDEM_RETURN =
        ActiveIngredient.ZOLPIDEM;

    private static final String GENERATE_ACETAMINOPHEN_FSTRING =
        String.format("Acetylating para-aminophenol with acetic "
            + "anhydride\nCarefully extracting %.2fmg of acetaminophen\n"
            + "Returning %.2fmg of acetaminophen\n",
            CORRECT_VOLUME, CORRECT_VOLUME);
    private static final String GENERATE_ZOLPIDEM_FSTRING =
        String.format("Opening secure storage area...\n"
            + "Carefully extracting %.2fmg of zolpidem\n"
            + "Returning %.2fmg of zolpidem\n",
            CORRECT_VOLUME, CORRECT_VOLUME);

    private AcetaminophenGenerator aGen;
    private ZolpidemGenerator zGen;
    private ByteArrayOutputStream baos;
    private PrintStream oldOut;

    /**
     * This is the BeforeEach method. It constructs redirects System.out
     * and constructs acetaminophen and zolpidem active objects for testing.
     * 
     * @throws RemoteException
     */
    @BeforeEach
    public void beforeEach() throws RemoteException
    {
        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        this.aGen = new AcetaminophenGenerator();
        this.zGen = new ZolpidemGenerator();
    }

    /**
     * This is the AfterEach method. It redirects System.out
     * back to the old out.
     */
    @AfterEach
    public void afterEach()
    {
        System.setOut(oldOut);
    }

    /**
     * This is the getOutput helper method. It gets the printed output
     * from the baos.
     *
     * @return String output
     */
    private String getOutput()
    {
        System.out.flush();
        return baos.toString().replaceAll("\r", "");
    }

    /**
     * This is the testAcetaminophen test method. It tests that the object
     * was built correctly by the constructor, and it tests the
     * generateActiveIngredient() method.
     * 
     * @throws RemoteException
     */
    @Test
    public void testAcetaminophen() throws RemoteException
    {
        assertEquals(CORRECT_ACETAMINOPHEN_RETURN,
            aGen.generateActiveIngredient(CORRECT_VOLUME));
        assertEquals(GENERATE_ACETAMINOPHEN_FSTRING,
            getOutput());
    }

    /**
     * This is the testZolpidem test method. It tests that the object
     * was built correctly by the constructor, and it tests the
     * generateActiveIngredient() method.
     * 
     * @throws RemoteException
     */
    @Test
    public void testZolpidem() throws RemoteException
    {
        assertEquals(CORRECT_ZOLPIDEM_RETURN,
            zGen.generateActiveIngredient(CORRECT_VOLUME));
        assertEquals(GENERATE_ZOLPIDEM_FSTRING,
            getOutput());
    }
}
