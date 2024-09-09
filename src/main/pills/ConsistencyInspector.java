package pills;

/**
 * Inspector class for the Consistency of the order
 * being made (whether or not it is fully Adult or Child pills).
 * 
 * @author Squad Dos
 * @version 6.23.23
 */
public class ConsistencyInspector extends Inspector 
{
    private int adultCount;
    private int childCount;

    /**
     * Inspects the Adult AcheAway pill.
     * @param pill The AdultAcheAway pill.
     */
    public void inspect(AdultAcheAway pill) 
    {
        if (pill != null)
        {
            adultCount++;
        }
    }

    /**
     * Inspects the Child AcheAway pill.
     * @param pill The ChildAcheAway pill.
     */
    public void inspect(ChildAcheAway pill) 
    {
        if (pill != null)
        {
            childCount++;
        }
    }

    /**
     * Inspects the Adult Dreamly pill.
     * @param pill The AdultDreamly pill.
     */
    public void inspect(AdultDreamly pill) 
    {
        if (pill != null)
        {
            adultCount++;
        }
    }

    /**
     * Inspects the Child Dreamly pill.
     * @param pill The ChildDreamly pill.
     */
    public void inspect(ChildDreamly pill) 
    {
        if (pill != null)
        {
            childCount++;
        }
    }

    /**
     * Runs the report for the program if applicable.
     * @return The report generated.
     */
    public String report()
    {
        if (soFarSoConsistent())
        {
            return "This order is consistent.";
        }
        else 
        {
            return "This order is inconsistent.";
        }
    }

    /**
     * Resets the program if applicable.
     */
    public void reset()
    {
        this.adultCount = 0;
        this.childCount = 0;
    }

    /**
     * Ensures consistency is accurate.
     * 
     * @return if order is consistent.
     */
    public boolean soFarSoConsistent()
    {
        if ((adultCount > 0 && childCount == 0) 
            || (adultCount == 0 && childCount > 0))
        {
            return true;
        }
        return false;
    }
}
