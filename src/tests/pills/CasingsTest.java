package pills;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;

/**
 * This is the test suite for the CasingsTest class.
 *
 * @author Squad Dos
 * @version 6.17.23
 */
public class CasingsTest
{
    private static final double CORRECT_VOLUME = 10.00;
    private static final Color CORRECT_COLOR = Color.BLUE;
    private static final Casing CORRECT_PLASTICIZER_RETURN =
        Casing.PLASTICIZER;
    private static final Casing CORRECT_GELATIN_RETURN =
        Casing.GELATIN;

    private static final String GENERATE_PLASTICIZER_FSTRING =
        String.format("Mixing starch, water, opacifier, and glycerin...\n"
            + "Shaping...\n Returning %.2fml %s plasticizer casing...\n",
            CORRECT_VOLUME, CORRECT_COLOR);
    private static final String GENERATE_GELATIN_FSTRING =
        String.format("Mixing gelatin, water, opacifier, and glycerin...\n"
            + "Shaping...\n Returning %.2fml %s gelatin casing...\n",
            CORRECT_VOLUME, CORRECT_COLOR);

    private PlasticizerGenerator pGen;
    private GelatinGenerator gGen;
    private ByteArrayOutputStream baos;
    private PrintStream oldOut;

    /**
     * This is the BeforeEach method. It constructs redirects System.out
     * and constructs saline and oil solution objects for testing.
     * 
     * @throws RemoteException
     */
    @BeforeEach
    public void beforeEach() throws RemoteException
    {
        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        this.pGen = new PlasticizerGenerator();
        this.gGen = new GelatinGenerator();
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
     * This is the testPlasticizer test method. It tests that the object
     * was built correctly by the constructor, and it tests the
     * generateCasing() method.
     * 
     * @throws RemoteException
     */
    @Test
    public void testPlasticizer() throws RemoteException
    {
        assertEquals(CORRECT_PLASTICIZER_RETURN,
            pGen.generateCasing(CORRECT_VOLUME, CORRECT_COLOR));
        assertEquals(GENERATE_PLASTICIZER_FSTRING,
            getOutput());
    }

    /**
     * This is the testPlasticizer test method. It tests that the object
     * was built correctly by the constructor, and it tests the
     * generateCasing() method.
     * 
     * @throws RemoteException
     */
    @Test
    public void testGelatin() throws RemoteException
    {
        assertEquals(CORRECT_GELATIN_RETURN,
            gGen.generateCasing(CORRECT_VOLUME, CORRECT_COLOR));
        assertEquals(GENERATE_GELATIN_FSTRING,
            getOutput());
    }
}
