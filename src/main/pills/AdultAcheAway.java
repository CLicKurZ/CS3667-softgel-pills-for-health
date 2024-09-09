package pills;
/**
 * Adult version of AcheAway class.
 *
 * @author Squad Dos
 * @version 6.8.2023
 */
public class AdultAcheAway extends AcheAway
{
    public static final double STRENGTH = 825.00;
    public static final double VOLUME = 8.50;
    public static final Color COLOR = Color.WHITE;
    /**
     * This is the constructor for AdultAcheAway.
     *
     * @param activeIngredient activeIngredient of the pill
     * @param solution solution of the pill
     * @param casing casing of the pill
     */
    public AdultAcheAway(ActiveIngredient activeIngredient,
        Solution solution, Casing casing)
    {
        super(STRENGTH, VOLUME, COLOR, activeIngredient,
            solution, casing);
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
