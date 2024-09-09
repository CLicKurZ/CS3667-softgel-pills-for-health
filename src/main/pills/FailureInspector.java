package pills;

/**
 * Inspector class for the Failure rate while
 * making GelCap pills.
 * 
 * @author Squad Dos
 * @version 6.23.23
 */
public class FailureInspector extends Inspector 
{
    private int totalPills;
    private int nullPills;

    /**
     * Inspects the Adult AcheAway pill.
     * @param pill The AdultAcheAway pill.
     */
    public void inspect(AdultAcheAway pill) 
    {
        this.totalPills++;
    }

    /**
     * Inspects the Child AcheAway pill.
     * @param pill The ChildAcheAway pill.
     */
    public void inspect(ChildAcheAway pill) 
    {
        this.totalPills++;
    }

    /**
     * Inspects the Null object for AcheAway pills.
     * @param pill The NullAcheAway object.
     */
    public void inspect(NullAcheAway pill) 
    {
        this.totalPills++;
        this.nullPills++;
    }

    /**
     * Inspects the Adult Dreamly pill.
     * @param pill The AdultDreamly pill.
     */
    public void inspect(AdultDreamly pill) 
    {
        this.totalPills++;
    }

    /**
     * Inspects the Child Dreamly pill.
     * @param pill The ChildDreamly pill.
     */
    public void inspect(ChildDreamly pill) 
    {
        this.totalPills++;
    }

    /**
     * Inspects the Null object for Dreamly pills.
     * @param pill The NullDreamly object.
     */
    public void inspect(NullDreamly pill) 
    {
        this.totalPills++;
        this.nullPills++;
    }

    /**
     * Runs the report for the program if applicable.
     * @return The report generated.
     */
    public String report()
    {
        return String.format("The fail rate of pills is %.2f.",
            this.getFailRate() * 100);
    }

    /**
     * Resets the program if applicable.
     */
    public void reset()
    {
        this.totalPills = 0;
        this.nullPills = 0;
    }

    /**
     * Gets the fail rate of new pills in percent.
     * 
     * @return double Fail rate (percentage).
     */
    public double getFailRate()
    {
        return (double) nullPills / totalPills;
    }
}
