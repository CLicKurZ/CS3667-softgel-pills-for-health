package pills;

/**
 * This is the Inspector class for the pills.
 * 
 * @author Squad Dos
 * @version 6.26.23
 */
public abstract class Inspector 
{
    /**
     * Inspects the Adult AcheAway pill.
     * @param pill The AdultAcheAway pill.
     */
    public void inspect(AdultAcheAway pill) 
    { }

    /**
     * Inspects the Child AcheAway pill.
     * @param pill The ChildAcheAway pill.
     */
    public void inspect(ChildAcheAway pill) 
    { }

    /**
     * Inspects the Null object for AcheAway pills.
     * @param pill The NullAcheAway object.
     */
    public void inspect(NullAcheAway pill) 
    { }

    /**
     * Inspects the Adult Dreamly pill.
     * @param pill The AdultDreamly pill.
     */
    public void inspect(AdultDreamly pill) 
    { }

    /**
     * Inspects the Child Dreamly pill.
     * @param pill The ChildDreamly pill.
     */
    public void inspect(ChildDreamly pill) 
    { }

    /**
     * Inspects the Null object for Dreamly pills.
     * @param pill The NullDreamly object.
     */
    public void inspect(NullDreamly pill) 
    { }

    /**
     * Runs the report for the program if applicable.
     * @return The report generated.
     */
    public abstract String report();

    /**
     * Resets the program if applicable.
     */
    public abstract void reset();
}
