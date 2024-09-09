package pills;

/**
 * This is the mock class for the GelCap class
 * in order to use tests.
 *
 * @author Squad Dos
 * @version 6.6.23
 */
public class GelCapMock extends GelCap
{
    /**
     * This is the constructor for the GelCapMock class
     * which uses the super contructor from GelCap.
     *
     * @param name Name of the pill
     * @param strength Strength of the pill
     * @param volume volume of the pill
     * @param color Color of the pill
     * @param activeIngredient ActiveIngredient of the pill
     * @param solution Solution of the pill
     * @param casing Casing of the pill
     */
    public GelCapMock(String name, double strength, double volume,
        Color color, ActiveIngredient activeIngredient,
        Solution solution, Casing casing)
    {
        super(name, strength, volume, color, activeIngredient,
            solution, casing);
    }

    /**
     * The description method returns the description of the GelCap pill.
     *
     * @return String
     */
    @Override
    public String description()
    {
        return String.format("GelCap is the parent pill that Dreamly"
            + "and AcheAway inherit from.");
    }
    
    /**
     * This is the addCasing method. It prints a message and sets
     * the casing to GELATIN.
     */
    public void addCasing()
    {
        this.casing = Casing.GELATIN;
        System.out.println("Adding "
            + casing
            + " casing");
    }

    /**
     * This is the addSolution method. It prints a message and sets
     * the solution to OIL.
     */
    public void addSolution()
    {
        this.solution = Solution.OIL;
        System.out.println("Adding "
            + solution
            + " solution");
    }

    /**
     * This is the addActiveIngredient method. It prints a message and sets
     * the activeIngredient to ZOLPIDEM.
     */
    public void addActiveIngredient()
    {
        this.activeIngredient = ActiveIngredient.ZOLPIDEM;
        System.out.println("Adding "
            + activeIngredient
            + " active ingredient");
    }
}
