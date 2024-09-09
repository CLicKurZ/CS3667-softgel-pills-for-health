package pills;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * This is the test suite for the GelCap class.
 *
 * @author Squad Dos
 * @version 6.6.23
 */
public class GelCapTest
{
    private static final String CORRECT_NAME = "GelCap";
    private static final double TEST_STRENGTH = 20;
    private static final double TEST_VOLUME = 100;
    private static final Color TEST_COLOR = Color.BLUE;
    private static final Casing CORRECT_CASING = Casing.GELATIN;
    private static final Solution CORRECT_SOLUTION = Solution.OIL;
    private static final ActiveIngredient CORRECT_ACTIVE_INGREDIENT = 
        ActiveIngredient.ZOLPIDEM;
    private static final String TOSTRING_FSTRING = 
        String.format("%.2fmg %s Pill ", TEST_STRENGTH, CORRECT_NAME);

    private GelCap obj;
    private ByteArrayOutputStream baos;

    /**
     * This is the BeforeEach method. It constructs a 
     * mock GelCap object for testing.
     */
    @BeforeEach
    public void beforeEach()
    {
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        this.obj = new GelCapMock(CORRECT_NAME, TEST_STRENGTH, 
            TEST_VOLUME, TEST_COLOR, CORRECT_ACTIVE_INGREDIENT,
            CORRECT_SOLUTION, CORRECT_CASING);
    }
    

    /**
     * This is the testName test method. It tests that the object was built
     * correctly by the constructor, and it tests the getName() method.
     */
    @Test
    public void testName()
    {
        assertEquals(CORRECT_NAME, obj.getName());
    }

    /**
     * This is the testStrength test method. It tests that the object was
     * built correctly by the constructor, and it tests the getStrength()
     * method.
     */
    @Test
    public void testStrength()
    {
        assertEquals(TEST_STRENGTH, obj.getStrength());
    }

    /**
     * This is the testVolume test method. It tests that the object was
     * built correctly by the constructor, and it tests the getVolume()
     * method.
     */
    @Test
    public void testVolume()
    {
        assertEquals(TEST_VOLUME, obj.getVolume());
    }


    /**
     * This is the testColor test method. It tests that the object was
     * built correctly by the constructor, and it tests the getColor()
     * method.
     */
    @Test
    public void testColor()
    {
        assertEquals(TEST_COLOR, obj.getColor());
    }

    /**
     * This is the testCasing method. It tests that the object was built
     * correctly by the constructor, and it tests the getCasing() method.
     */
    @Test
    public void testCasing()
    {
        assertEquals(CORRECT_CASING, obj.getCasing());
    }

    /**
     * This is the testSolution method. It tests that the object was built
     * correctly by the constructor, and it tests the getSolution() method.
     */
    @Test
    public void testSolution()
    {
        assertEquals(CORRECT_SOLUTION, obj.getSolution());
    }

    /**
     * This is the testActive method. It tests that the object was built
     * correctly by the constructor, and it tests the
     * getActiveIngredient() method.
     */
    @Test
    public void testActive()
    {
        assertEquals(CORRECT_ACTIVE_INGREDIENT, obj.getActiveIngredient());
    }

    /**
     * This is the testToString method. It tests that the toString()
     * method builds the correct string.
     */
    @Test
    public void testToString()
    {
        assertEquals(TOSTRING_FSTRING, obj.toString());
    }
}
