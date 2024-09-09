package pills;

/**
 * Pill class for the child version of Dreamly.
 *
 * @author Squad Dos
 * @version 6.8.23
 */
public class ChildDreamly extends Dreamly
{
    public static final double STRENGTH = 1.25;
    public static final double VOLUME = 4.5;
    public static final Color COLOR = Color.FUCHSIA;

    /**
     * Constructor for child version of Dreamly using super constructor.
     *
     * @param activeIngredient The active ingredient in Dreamly.
     * @param solution The solution in Dreamly.
     * @param casing The casing used for Dreamly.
     */
    public ChildDreamly(ActiveIngredient activeIngredient, 
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
