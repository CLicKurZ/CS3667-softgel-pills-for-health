package pills;

/**
 * Pill class for the child version of AcheAway.
 *
 * @author Squad Dos
 * @version 6.8.23
 */
public class ChildAcheAway extends AcheAway
{
    public static final double STRENGTH = 415.00;
    public static final double VOLUME = 3.25;
    public static final Color COLOR = Color.CYAN;

    /**
     * Constructor for child version of AcheAway using super constructor.
     *
     * @param activeIngredient The active ingredient in AcheAway.
     * @param solution The solution in AcheAway.
     * @param casing The casing used for AcheAway.
     */
    public ChildAcheAway(ActiveIngredient activeIngredient, 
        Solution solution, Casing casing)
    {
        super(STRENGTH, VOLUME, COLOR,
            activeIngredient, solution, casing);
    }

    /**
     * The accept method from GelCap.
     * 
     * @param i The Inspector object.
     */
    public void accept(Inspector i)
    {
        i.inspect(this);
    }
}
