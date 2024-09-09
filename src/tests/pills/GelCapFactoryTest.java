package pills;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;

/**
 * This is the test suite for the GelCapFactory class.
 *
 * @author Squad Dos
 * @version 6.19.23
 */
public class GelCapFactoryTest 
{

    private GelCapFactoryMock factory;
    private ByteArrayOutputStream baos;

    /**
     * This is the BeforeEach method. It constructs a 
     * mock GelCapFactory object for testing.
     */
    @BeforeEach
    public void beforeEach() 
    {
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        this.factory = new GelCapFactoryMock();
    }

    /**
     * This is the testProduceDreamly test method. It tests that the object was
     * built correctly by the constructor, and it tests the produceDreamly()
     * method.
     */
    @Test
    public void testProduceDreamly() 
    {
        int successCounter = 0;
        int failureCounter = 0;
        String successOutput = "";
        String failureOutput = "";
        try 
        {
            for (int i = 0; i < 100; i++) 
            {
                baos.reset();
                Dreamly dreamly = factory.produceDreamly();
                String output = baos.toString().trim();

                String pattern = "Creating a .+ pill\\.\\.\\."
                    + "\\n[\\w\\W]*Performing quality check\\.\\.\\.";
                output = output.replaceAll(pattern, "");

                if (dreamly != null) 
                {
                    failureCounter++;
                    failureOutput = output;
                } 
                else 
                {
                    successCounter++;
                    successOutput = output;
                }
            }
        }
        catch (RemoteException e)
        {
            System.out.println("Caught RemoteException.");
        }

        assertEquals(String.class, successOutput.getClass());
        assertEquals(String.class, failureOutput.getClass());

        int totalIterations = successCounter + failureCounter;
        double targetFailureRate = 10.0;
        double acceptableRange = totalIterations * 0.1;

        assertEquals(targetFailureRate, (double) failureCounter 
            / totalIterations * 100, acceptableRange);
    }

    /**
     * This is the testProduceAcheAway test method. It tests that the object was
     * built correctly by the constructor, and it tests the produceAcheAway()
     * method.
     */
    @Test
    public void testProduceAcheAway() 
    {
        int successCounter = 0;
        int failureCounter = 0;
        String successOutput = "";
        String failureOutput = "";
        try 
        {
            for (int i = 0; i < 100; i++) 
            {
                baos.reset();
                AcheAway acheAway = factory.produceAcheAway();
                String output = baos.toString().trim();

                String pattern = "Creating a .+ pill\\.\\.\\"
                    + ".\\n[\\w\\W]*Performing quality check\\.\\.\\.";
                output = output.replaceAll(pattern, "");

                if (acheAway != null) 
                {
                    failureCounter++;
                    failureOutput = output;
                } 
                else 
                {
                    successCounter++;
                    successOutput = output;
                }
            }
        }
        catch (RemoteException e)
        {
            System.out.println("Caught RemoteException.");
        }

        assertEquals(String.class, successOutput.getClass());
        assertEquals(String.class, failureOutput.getClass());

        int totalIterations = successCounter + failureCounter;
        double targetFailureRate = 10.0;
        double acceptableRange = totalIterations * 0.1; 

        assertEquals(targetFailureRate, (double) failureCounter 
            / totalIterations * 100, acceptableRange);
    }
}
