package pills;

/**
 * This is the mock class for the Inspector class
 * in order to use tests.
 *
 * @author Squad Dos
 * @version 6.26.23
 */
public class InspectorMock extends Inspector
{
    private String reportResult;
    private boolean resetCalled = false;

    /**
    * Constructs a new instance of InspectorMock.
    *
    * @param reportResult
    */
    public InspectorMock(String reportResult) 
    {
        this.reportResult = reportResult;
    }

    /**
    * Returns the report result.
    * 
    * @return The report result string.
    */ 
    @Override
    public String report() 
    {
        return reportResult;
    }

    /**
     * Resets the state of this mock object.
     */
    @Override
    public void reset() 
    {
        resetCalled = true;
    }

    /**
     * Check if the method was called.
     * 
     * @return resetCalled
     */
    public boolean wasResetCalled() 
    {
        return resetCalled;
    } 
}
