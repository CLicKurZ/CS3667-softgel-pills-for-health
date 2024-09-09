package pills;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * This is the test suite for the AcheAway class.
 *
 * @author Squad Dos
 * @version 6.5.23
 */
public class AcheAwayTest
{
    private static final String CORRECT_NAME = "AcheAway";
    private static final double ADULT_STRENGTH = 825.00;
    private static final double ADULT_VOLUME = 8.50;
    private static final Color ADULT_COLOR = Color.WHITE;
    private static final double CHILD_STRENGTH = 415.00;
    private static final double CHILD_VOLUME = 3.25;
    private static final Color CHILD_COLOR = Color.CYAN;
    private static final Casing CORRECT_CASING = Casing.GELATIN;
    private static final Solution CORRECT_SOLUTION = Solution.SALINE;
    private static final ActiveIngredient CORRECT_ACTIVE_INGREDIENT =
        ActiveIngredient.ACETAMINOPHEN;
    private AcheAway acheAway;
    private AcheAway adultAcheAway;
    private AcheAway childAcheAway;
    private ByteArrayOutputStream baos;
    //private PrintStream oldOut;

    /**
     * This is the BeforeEach method. It constructs redirects System.out
     * and constructs an AcheAway object for testing.
     */
    @BeforeEach
    public void beforeEach()
    {
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        this.acheAway = new AcheAwayMock(
            CORRECT_NAME, ADULT_STRENGTH, ADULT_VOLUME,
            ADULT_COLOR, CORRECT_ACTIVE_INGREDIENT,
            CORRECT_SOLUTION, CORRECT_CASING);
        this.adultAcheAway = new AcheAwayMock(
            CORRECT_NAME, ADULT_STRENGTH, ADULT_VOLUME,
            ADULT_COLOR, CORRECT_ACTIVE_INGREDIENT,
            CORRECT_SOLUTION, CORRECT_CASING);
        this.childAcheAway = new AcheAwayMock(
            CORRECT_NAME, CHILD_STRENGTH, CHILD_VOLUME,
            CHILD_COLOR, CORRECT_ACTIVE_INGREDIENT,
            CORRECT_SOLUTION, CORRECT_CASING);
    }


    /**
     * This is the testName test method. It tests that the object was built
     * correctly by the constructor, and it tests the getName() method.
     */
    @Test
    public void testName()
    {
        assertEquals(CORRECT_NAME, acheAway.getName());
        assertEquals(CORRECT_NAME, adultAcheAway.getName());
        assertEquals(CORRECT_NAME, childAcheAway.getName());
    }

    /**
     * This is the testStrength test method. It tests that the object was
     * built correctly by the constructor, and it tests the getStrength()
     * method.
     */
    @Test
    public void testStrength()
    {
        assertEquals(ADULT_STRENGTH, acheAway.getStrength());
        assertEquals(ADULT_STRENGTH, adultAcheAway.getStrength());
        assertEquals(CHILD_STRENGTH, childAcheAway.getStrength());
    }

    /**
     * This is the testVolume test method. It tests that the object was
     * built correctly by the constructor, and it tests the getVolume()
     * method.
     */
    @Test
    public void testVolume()
    {
        assertEquals(ADULT_VOLUME, acheAway.getVolume());
        assertEquals(ADULT_VOLUME, adultAcheAway.getVolume());
        assertEquals(CHILD_VOLUME, childAcheAway.getVolume());    
    }

    /**
     * This is the testColor test method. It tests that the object was
     * built correctly by the constructor, and it tests the getColor()
     * method.
     */
    @Test
    public void testColor()
    {
        assertEquals(ADULT_COLOR, acheAway.getColor());
        assertEquals(ADULT_COLOR, adultAcheAway.getColor());
        assertEquals(CHILD_COLOR, childAcheAway.getColor());
    }

    /**
     * This is the testCasing method. It tests that the object was built
     * correctly by the constructor, and it tests the getCasing() method.
     */
    @Test
    public void testCasing()
    {
        assertEquals(CORRECT_CASING, acheAway.getCasing());
        assertEquals(CORRECT_CASING, adultAcheAway.getCasing());
        assertEquals(CORRECT_CASING, childAcheAway.getCasing());
    }

    /**
     * This is the testSolution method. It tests that the object was built
     * correctly by the constructor, and it tests the getSolution() method.
     */
    @Test
    public void testSolution()
    {
        assertEquals(CORRECT_SOLUTION, acheAway.getSolution());
        assertEquals(CORRECT_SOLUTION, adultAcheAway.getSolution());
        assertEquals(CORRECT_SOLUTION, childAcheAway.getSolution());
    }

    /**
     * This is the testActive method. It tests that the object was built
     * correctly by the constructor, and it tests the
     * getActiveIngredient() method.
     */
    @Test
    public void testActive()
    {
        assertEquals(CORRECT_ACTIVE_INGREDIENT,
            acheAway.getActiveIngredient());
        assertEquals(CORRECT_ACTIVE_INGREDIENT,
            adultAcheAway.getActiveIngredient());
        assertEquals(CORRECT_ACTIVE_INGREDIENT,
            childAcheAway.getActiveIngredient());
    }

}
