package pills;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * This is the test suite for the Dreamly class.
 *
 * @author Squad Dos
 * @version 6.6.23
 */
public class DreamlyTest
{
    private static final String CORRECT_NAME = "Dreamly";
    private static final double ADULT_STRENGTH = 5.20;
    private static final double ADULT_VOLUME = 12.24;
    private static final Color ADULT_COLOR = Color.TAN;
    private static final double CHILD_STRENGTH = 1.25;
    private static final double CHILD_VOLUME = 4.5;
    private static final Color CHILD_COLOR = Color.FUCHSIA;
    private static final Casing CORRECT_CASING = Casing.PLASTICIZER;
    private static final Solution CORRECT_SOLUTION = Solution.OIL;
    private static final ActiveIngredient CORRECT_ACTIVE_INGREDIENT =
        ActiveIngredient.ZOLPIDEM;

    private Dreamly dreamly;
    private Dreamly adultDreamly;
    private Dreamly childDreamly;
    private ByteArrayOutputStream baos;
    //private PrintStream oldOut;

    /**
     * This is the BeforeEach method. It constructs redirects System.out
     * and constructs an Dreamly object for testing.
     *
     * Changed because we do not need to redirect System.out.
     */
    @BeforeEach
    public void beforeEach()
    {
        //this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        this.dreamly = new DreamlyMock(CORRECT_NAME, ADULT_STRENGTH, 
            ADULT_VOLUME, ADULT_COLOR, CORRECT_ACTIVE_INGREDIENT, 
            CORRECT_SOLUTION, CORRECT_CASING);
        this.adultDreamly = new DreamlyMock(CORRECT_NAME, ADULT_STRENGTH, 
            ADULT_VOLUME, ADULT_COLOR, CORRECT_ACTIVE_INGREDIENT, 
            CORRECT_SOLUTION, CORRECT_CASING);
        this.childDreamly = new DreamlyMock(CORRECT_NAME, CHILD_STRENGTH, 
            CHILD_VOLUME, CHILD_COLOR, CORRECT_ACTIVE_INGREDIENT, 
            CORRECT_SOLUTION, CORRECT_CASING);
    }


    /**
     * This is the testName test method. It tests that the object was built
     * correctly by the constructor, and it tests the getName() method.
     */
    @Test
    public void testName()
    {
        assertEquals(CORRECT_NAME, dreamly.getName());
        assertEquals(CORRECT_NAME, adultDreamly.getName());
        assertEquals(CORRECT_NAME, childDreamly.getName());
    }

    /**
     * This is the testStrength test method. It tests that the object was
     * built correctly by the constructor, and it tests the getStrength()
     * method.
     */
    @Test
    public void testStrength()
    {
        assertEquals(ADULT_STRENGTH, dreamly.getStrength());
        assertEquals(ADULT_STRENGTH, adultDreamly.getStrength());
        assertEquals(CHILD_STRENGTH, childDreamly.getStrength());
    }

    /**
     * This is the testVolume test method. It tests that the object was
     * built correctly by the constructor, and it tests the getVolume()
     * method.
     */
    @Test
    public void testVolume()
    {
        assertEquals(ADULT_VOLUME, dreamly.getVolume());
        assertEquals(ADULT_VOLUME, adultDreamly.getVolume());
        assertEquals(CHILD_VOLUME, childDreamly.getVolume());
    }

    /**
     * This is the testColor test method. It tests that the object was
     * built correctly by the constructor, and it tests the getColor()
     * method.
     */
    @Test
    public void testColor()
    {
        assertEquals(ADULT_COLOR, dreamly.getColor());
        assertEquals(ADULT_COLOR, adultDreamly.getColor());
        assertEquals(CHILD_COLOR, childDreamly.getColor());
    }

    /**
     * This is the testCasing method. It tests that the object was built
     * correctly by the constructor, and it tests the getCasing() method.
     */
    @Test
    public void testCasing()
    {
        assertEquals(CORRECT_CASING, dreamly.getCasing());
        assertEquals(CORRECT_CASING, adultDreamly.getCasing());
        assertEquals(CORRECT_CASING, childDreamly.getCasing());
    }

    /**
     * This is the testSolution method. It tests that the object was built
     * correctly by the constructor, and it tests the getSolution() method.
     */
    @Test
    public void testSolution()
    {
        assertEquals(CORRECT_SOLUTION, dreamly.getSolution());
        assertEquals(CORRECT_SOLUTION, adultDreamly.getSolution());
        assertEquals(CORRECT_SOLUTION, childDreamly.getSolution());
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
            dreamly.getActiveIngredient());
        assertEquals(CORRECT_ACTIVE_INGREDIENT,
            adultDreamly.getActiveIngredient());
        assertEquals(CORRECT_ACTIVE_INGREDIENT,
            childDreamly.getActiveIngredient());
    }

}
