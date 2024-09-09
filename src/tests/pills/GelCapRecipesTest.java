package pills;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * This is the test suite for the GelCapRecipes class.
 *
 * @author Squad Dos
 * @version 6.15.23
 */
public class GelCapRecipesTest
{
    private ByteArrayOutputStream baos;
    private PrintStream oldOut;

    /**
     * This is the BeforeEach method. It constructs redirects System.out
     * and creates a new GelCapRecipes object.
     */
    @BeforeEach
    public void beforeEach()
    {
        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
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
     * This is the testCasings test method. Each assert statement 
     * checks that the generator returned from the HashMap is of
     * the correct type.
     */
    @Test
    public void testCasings()
    {
        try
        {
            assertTrue(GelCapRecipes.CASINGS.get("dreamly")
                instanceof CasingGenerator);
            assertTrue(GelCapRecipes.CASINGS.get("acheaway")
                instanceof CasingGenerator);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This is the testSolutions test method. Each assert statement 
     * checks that the generator returned from the HashMap is of
     * the correct type.
     */
    @Test
    public void testSolutions()
    {
        try
        {
            assertTrue(GelCapRecipes.SOLUTIONS.get("dreamly")
                instanceof SolutionGenerator);
            assertTrue(GelCapRecipes.SOLUTIONS.get("acheaway")
                instanceof SolutionGenerator);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * This is the testActives test method. Each assert statement 
     * checks that the generator returned from the HashMap is of
     * the correct type.
     */
    @Test
    public void testActives()
    {
        try
        {
            assertTrue(GelCapRecipes.ACTIVES.get("dreamly")
                instanceof ActiveIngredientGenerator);
            assertTrue(GelCapRecipes.ACTIVES.get("acheaway")
                instanceof ActiveIngredientGenerator);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
