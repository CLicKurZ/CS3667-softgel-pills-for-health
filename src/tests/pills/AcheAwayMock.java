package pills;
/**
 * This is the mock class for the AcheAway class
 * in order to use tests.
 *
 * @author Squad Dos
 * @version 6.6.23
 */
public class AcheAwayMock extends AcheAway
{
    /**
     * This is the constructor for the AcheAwayMock class
     * which uses the super contructor from AcheAway.
     *
     * @param name Name of the pill
     * @param strength Strength of the pill
     * @param volume volume of the pill
     * @param color Color of the pill
     * @param activeIngredient ActiveIngredient of the pill
     * @param solution Solution of the pill
     * @param casing Casing of the pill
     */
    public AcheAwayMock(String name, double strength, double volume,
        Color color, ActiveIngredient activeIngredient,
        Solution solution, Casing casing)
    {
        super(strength, volume, color, activeIngredient,
            solution, casing);
    }
}
