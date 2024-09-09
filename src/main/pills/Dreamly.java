package pills;

/**
 * This is the subclass Dreamly class of GelCap which builds the Dreamly pills.
 *
 * @author Squad Dos
 * @version 6.5.23
 */
abstract public class Dreamly extends GelCap 
{

    public final static Dreamly NULL = null;

    /**
     * This is the constructor for Dreamly objects which uses parameters
     * for the strength, volume, and color. Then it calls super();
     *
     * @param strength strength of the pill
     * @param volume volume of the pill
     * @param color color of the pill
     * @param activeIngredient activeIngredient of the pill
     * @param solution solution of the pill
     * @param casing casing of the pill
     * 
     */
    public Dreamly(double strength, double volume, Color color,
        ActiveIngredient activeIngredient, Solution solution,
        Casing casing)
    {
        super("Dreamly", strength, volume, color,
            activeIngredient, solution, casing);
    }

    @Override
    public String description() 
    {
        return "Dreamly is a sleep aid that " 
            + "is used when treating adult insomnia.";
    }
}
