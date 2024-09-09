package pills;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * This is the test suite for the AdultGelCapFactory class.
 *
 * @author Squad Dos
 * @version 6.18.23
 */
public class ChildGelCapFactoryTest
{
    private SolutionGeneratorMock solutionMock;
    private CasingGeneratorMock casingMock;
    private ActiveIngredientGeneratorMock ingredientMock;
    private ChildGelCapFactory cgcp;
    private ByteArrayOutputStream baos;

    /**
     * This is the BeforeEach method. It constructs redirects System.out
     * and constructs solution, casing,
     *  ingredient, and factory object for testing.
     */
    @BeforeEach
    public void setup() 
    {
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        // Initializing the mocks and the factory instance
        this.solutionMock = new SolutionGeneratorMock();
        this.casingMock = new CasingGeneratorMock();
        this.ingredientMock = new ActiveIngredientGeneratorMock();
        this.cgcp = ChildGelCapFactory.getInstance();
    }

    /**
     * This is the manufactureDreamlyTest test method.
     *  It tests that the object was built
     * correctly by the constructor, and it tests the getSolution(),
     *  getCasing(), and getActiveIngredient() method.
     */
    @Test
    public void manufactureDreamlyTest() 
    {
        Dreamly pill = cgcp.manufactureDreamly(casingMock,
            solutionMock, ingredientMock);

        // Checking for the correct type of pill
        assertEquals(ChildDreamly.class, pill.getClass());

        // Checking that the pill has the correct casing, 
        // solution, and active ingredient
        assertEquals(SolutionGeneratorMock.RETURN_VALUE, pill.getSolution());
        assertEquals(CasingGeneratorMock.RETURN_VALUE, pill.getCasing());
        assertEquals(ActiveIngredientGeneratorMock.RETURN_VALUE,
            pill.getActiveIngredient());

        // Checking the print statement
        String output = baos.toString();
        assertEquals("Manufacturing child version of Dreamly", output.trim());
    }

    /**
     * This is the manufactureAcheAwayTest test method.
     *  It tests that the object was built
     * correctly by the constructor, and it tests the getSolution(),
     *  getCasing(), and getActiveIngredient() method.
     */
    @Test
    public void manufactureAcheAwayTest() 
    {
        AcheAway pill = cgcp.manufactureAcheAway(casingMock, 
            solutionMock, ingredientMock);

        // Checking for the correct type of pill
        assertEquals(ChildAcheAway.class, pill.getClass());

        // Checking that the pill has the correct casing,
        // solution, and active ingredient
        assertEquals(SolutionGeneratorMock.RETURN_VALUE,
            pill.getSolution());
        assertEquals(CasingGeneratorMock.RETURN_VALUE, pill.getCasing());
        assertEquals(ActiveIngredientGeneratorMock.RETURN_VALUE,
            pill.getActiveIngredient());

        // Checking the print statement
        String output = baos.toString();
        assertEquals("Manufacturing child version of AcheAway", output.trim());
    }

}

