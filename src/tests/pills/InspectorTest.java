package pills;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This is the test suite for the Inspector class.
 *
 * @author Squad Dos
 * @version 6.26.23
 */
public class InspectorTest 
{
    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    /**
     * This is the BeforeEach method. 
     * Sets up the output streams before each test.
     */
    @BeforeEach
    public void setUpStreams() 
    {
        System.setOut(new PrintStream(baos));
    }

    /**
     * This is the AfterEach method.
     * Restores the output streams after each test.
     */
    @AfterEach
    public void restoreStreams() 
    {
        System.setOut(originalOut);
    }

    /**
     * Tests the report() method of the InspectorMock class.
     * This test constructs an instance
     *  of InspectorMock with a preset report 
     * result, and verifies that the report() 
     * method returns the expected result.
     */
    @Test
    public void testReport() 
    {
        InspectorMock inspector = new InspectorMock("Test report");
        assertEquals("Test report", inspector.report());
    }

    /**
     * Tests the reset() method of the InspectorMock class.
     * This test constructs an instance of 
     * InspectorMock, calls its reset() method, 
     * and verifies that wasResetCalled() returns true,
     *  indicating that the reset() method was called.
     */
    @Test
    public void testReset() 
    {
        InspectorMock inspector = new InspectorMock("Test report");
        inspector.reset();
        assertTrue(inspector.wasResetCalled());
    }
}
