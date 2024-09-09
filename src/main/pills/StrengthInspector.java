package pills;

/**
 * Inspector class for the Strength of both
 * AcheAway and Dreamly pills.
 * 
 * @author Squad Dos
 * @version 6.23.23
 */
public class StrengthInspector extends Inspector 
{
    private double acheAwayStrength;
    private double dreamlyStrength;

    /**
     * Inspects the Adult AcheAway pill.
     * @param pill The AdultAcheAway pill.
     */
    public void inspect(AdultAcheAway pill) 
    {
        this.acheAwayStrength += pill.getStrength();
    }

    /**
     * Inspects the Child AcheAway pill.
     * @param pill The ChildAcheAway pill.
     */
    public void inspect(ChildAcheAway pill) 
    {
        this.acheAwayStrength += pill.getStrength();
    }

    /**
     * Inspects the Adult Dreamly pill.
     * @param pill The AdultDreamly pill.
     */
    public void inspect(AdultDreamly pill) 
    {
        this.dreamlyStrength += pill.getStrength();
    }

    /**
     * Inspects the Child Dreamly pill.
     * @param pill The ChildDreamly pill.
     */
    public void inspect(ChildDreamly pill) 
    {
        this.dreamlyStrength += pill.getStrength();
    }


    /**
     * Runs the report for the program if applicable.
     * @return The report generated.
     */
    public String report() 
    {
        return "AcheAway strength of order: " 
            + getAcheAwayStrength() 
            + "\nDreamly strength of order: " 
            + getDreamlyStrength() + "\n";
    }

    /**
     * Resets the program if applicable.
     */
    public void reset() 
    {
        this.acheAwayStrength = 0;
        this.dreamlyStrength = 0;
    }

    /**
     * Getter for acheAwayStrength field.
     * 
     * @return Strength of ActiveIngredient.
     */
    public double getAcheAwayStrength()
    {
        return this.acheAwayStrength;
    }

    /**
     * Getter for dreamlyStrength field.
     * 
     * @return Strength of ActiveIngredient.
     */
    public double getDreamlyStrength()
    {
        return this.dreamlyStrength;
    }
}
