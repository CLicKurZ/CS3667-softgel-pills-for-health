package pills;

/**
 * This is a subclass of Dreamly for adult dreamly.
 *
 * @author Squad Dos
 * @version 6.8.2023
 */
public class AdultDreamly extends Dreamly
{
    public static final double STRENGTH = 5.20;
    public static final double VOLUME = 12.24;
    public static final Color COLOR = Color.TAN;
    
    /**
     * The constructor for AdultDreamly.
     *
     * @param activeIngredient activeIngredient of the pill
     * @param solution solution of the pill
     * @param casing casing of the pill
     */ 
    public AdultDreamly(ActiveIngredient activeIngredient,
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
