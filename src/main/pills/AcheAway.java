package pills;

/**
 * This is the subclass AcheAway class 
 * of GelCap which builds the AcheAway pills.
 *
 * @author Squad Dos
 * @version 6.5.23
 */
abstract public class AcheAway extends GelCap 
{

    public final static AcheAway NULL = null;

    /**
     * This is the constructor for AcheAway objects which uses parameters
     * for the strength, volume, and color. Then it calls super();
     * Adding parameters in part 2 for ActiveIngredient, Solution,
     * and Casing types.
     *
     * @param strength strength of the pill
     * @param volume volume of the pill
     * @param color color of the pill
     * @param activeIngredient activeIngredient of the pill
     * @param solution solution of the pill
     * @param casing casing of the pill
     * 
     */
    public AcheAway(double strength, double volume, Color color,
        ActiveIngredient activeIngredient, Solution solution,
        Casing casing) 
    {
        super("AcheAway", strength, volume, color,
            activeIngredient, solution,
            casing);
    }
    /**
     * This is the description method which returns a String representation
     * of a AcheAway object.
     *
     * @return String representation of AcheAway
     */
    @Override
    public String description() 
    {
        return "AcheAway is a pain reliever that "  
            + "is used when treating moderate pain.";
    }

}
