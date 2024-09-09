package pills;

/**
 * This is the abstract GelCap class which builds the gelcap pills.
 *
 * @author Squad Dos
 * @version 6.1.23
 */
public abstract class GelCap
{
    protected String name;
    protected double strength;
    protected double volume;
    protected Color color;
    protected Casing casing;
    protected Solution solution;
    protected ActiveIngredient activeIngredient;
    
    /**
     * This is the constructor for GelCap objects which uses parameters
     * for the name, strength, volume, and color. Then it calls manufacture();
     *
     * @param name name of the pill
     * @param strength strength of the pill
     * @param volume volume of the pill
     * @param color color of the pill
     * @param activeIngredient activeIngredient of the pill
     * @param solution solution of the pill
     * @param casing casing of the pill
     */
    public GelCap(String name, double strength, double volume,
			Color color, ActiveIngredient activeIngredient,
            Solution solution, Casing casing)
    {
        this.name = name;
        this.strength = strength;
        this.volume = volume;
        this.color = color;
        this.activeIngredient = activeIngredient;
        this.solution = solution;
        this.casing = casing;
    }

    /**
     * This is the toString method which returns a String representation
     * of a GelCap object.
     *
     * @return String representation of GelCap
     */
    public String toString()
    {
        return String.format("%.2fmg %s Pill ", strength, name);
    }

    /**
     * The getName method returns the name of a GelCap object.
     *
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * The getStrength method returns the strength of a GelCap object.
     *
     * @return strength
     */
    public double getStrength()
    {
        return strength;
    }

    /**
     * The getVolume method returns the volume of a GelCap object.
     *
     * @return volume
     */
    public double getVolume()
    {
        return volume;
    }

    /**
     * The getColor method returns the color of a GelCap object.
     *
     * @return color
     */
    public Color getColor()
    {
        return color;
    }

    /**
     * The getCasing method returns the casing of a GelCap object.
     *
     * @return casing
     */
    public Casing getCasing()
    {
        return casing;
    }

    /**
     * The getSolution method returns the solution of a GelCap object.
     *
     * @return solution
     */
    public Solution getSolution()
    {
        return solution;
    }

    /**
     * The getActiveIngredient method returns the active ingredient
     * of a GelCap object.
     *
     * @return activeIngredient
     */
    public ActiveIngredient getActiveIngredient()
    {
        return activeIngredient;
    }

    /**
     * The abstract method description() returns a String description
     * of a GelCap object.
     *
     * @return String description
     */
    public abstract String description();

}
