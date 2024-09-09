package pills;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;

/**
 * This is the test suite for the SolutionsTest class.
 *
 * @author Squad Dos
 * @version 6.17.23
 */
public class SolutionsTest
{
    private static final double CORRECT_VOLUME = 8.50;
    private static final Solution CORRECT_SALINE_RETURN = Solution.SALINE;
    private static final Solution CORRECT_OIL_RETURN = Solution.OIL;

    private static final String GENERATE_SALINE_FSTRING =
        String.format("Mixing salt and water...\n"
            + "Verifying ratio...\n"
            + "Returning %.2fmL saline solution", CORRECT_VOLUME);
    private static final String GENERATE_OIL_FSTRING =
        String.format("Extracting pill-sized quantity of oil...\n"
            + "Returning %.2fmL oil solution\n", CORRECT_VOLUME);

    private SalineGenerator sGen;
    private OilGenerator oGen;
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
        this.sGen = new SalineGenerator();
        this.oGen = new OilGenerator();
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
     * This is the testOil test method. It tests that the object was built
     * correctly by the constructor, and it tests the generateSolution()
     * method.
     * 
     * @throws RemoteException
     */
    @Test
    public void testOil() throws RemoteException
    {
        assertEquals(CORRECT_OIL_RETURN,
            oGen.generateSolution(CORRECT_VOLUME));
        assertEquals(GENERATE_OIL_FSTRING,
            getOutput());
    }

    /**
     * This is the testSaline test method. It tests that the object was built
     * correctly by the constructor, and it tests the generateSolution()
     * method.
     * 
     * @throws RemoteException
     */
    @Test
    public void testSaline() throws RemoteException
    {
        assertEquals(CORRECT_SALINE_RETURN,
            sGen.generateSolution(CORRECT_VOLUME));
        assertEquals(GENERATE_SALINE_FSTRING,
            getOutput());
    }
}
