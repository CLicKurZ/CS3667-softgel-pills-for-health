package pills;

/**
 * This is the mock class for the Dreamly class
 * in order to use tests.
 *
 * @author Squad Dos
 * @version 6.15.23
 */
public class DreamlyMock extends Dreamly
{
    /**
     * This is the constructor for the DreamlyMock class
     * which uses the super contructor from Dreamly.
     *
     * @param name Name of the pill
     * @param strength Strength of the pill
     * @param volume volume of the pill
     * @param color Color of the pill
     * @param activeIngredient ActiveIngredient of the pill
     * @param solution Solution of the pill
     * @param casing Casing of the pill
     */
    public DreamlyMock(String name, double strength, double volume,
        Color color, ActiveIngredient activeIngredient,
        Solution solution, Casing casing)
    {
        super(strength, volume, color, activeIngredient,
            solution, casing);
    }
}
