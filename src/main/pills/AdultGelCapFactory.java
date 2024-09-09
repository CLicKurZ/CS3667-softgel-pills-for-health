package pills;

import java.rmi.RemoteException;

/**
 * Factory class for Adult GelCap pills.
 * 
 * @author Squad Dos
 * @version 6.8.23
 */
public class AdultGelCapFactory extends GelCapFactory 
{
    private static AdultGelCapFactory instance;

    /**
     * No-arg constructor for AdultGelCapFactory instance.
     */
    private AdultGelCapFactory()
    {
        super();
    }
    
    /**
     * Manufacture method for Adult Dreamly pills.
     * @param cg the casing type of the pill
     * @param sg the solution used in the pill
     * @param aig the active ingredient of the pill
     * @return The Adult Dreamly pill created.
     */
    @Override
    protected Dreamly manufactureDreamly(CasingGenerator cg,
        SolutionGenerator sg, ActiveIngredientGenerator aig)
    {
        System.out.println("Manufacturing adult version of Dreamly");
        try 
        {
            ActiveIngredient activeIngredient = aig.generateActiveIngredient(
                AdultDreamly.STRENGTH);

            Solution solution = sg.generateSolution(AdultDreamly.VOLUME);

            Casing casing = cg.generateCasing(
                AdultDreamly.VOLUME, AdultDreamly.COLOR);

            return new AdultDreamly(activeIngredient, solution, casing);
        }
        catch (RemoteException e) 
        {
            System.out.println("This pill has failed.");
            return new NullDreamly();
        }
    }

    /**
     * Manufacture method for Adult AcheAway pills.
     * @param cg Casing generator used for the pills.
     * @param sg Solution generator used for the pills.
     * @param aig Active Ingredient generator used for the pills.
     * @return The Adult AcheAway pill created.
     */
    @Override
    protected AcheAway manufactureAcheAway(CasingGenerator cg,
        SolutionGenerator sg, ActiveIngredientGenerator aig)
    {
        System.out.println("Manufacturing adult version of AcheAway");
        try 
        {
            ActiveIngredient activeIngredient = aig.generateActiveIngredient(
                AdultAcheAway.STRENGTH);

            Solution solution = sg.generateSolution(AdultAcheAway.VOLUME);

            Casing casing = cg.generateCasing(
                AdultAcheAway.VOLUME, AdultAcheAway.COLOR);

            return new AdultAcheAway(activeIngredient, solution, casing);
        }
        catch (RemoteException e) 
        {
            return new NullAcheAway();
        }
    }

    /**
     * Getter method for instance of AdultGelCapFactory.
     * 
     * @return The instance of AdultGelCapFactory
     */
    public static AdultGelCapFactory getInstance()
    {
        if (instance == null)
        {
            synchronized (AdultGelCapFactory.class) 
            {
                if (instance == null)
                {
                    instance = new AdultGelCapFactory();
                }
            }
        }
        return instance;
    }
}
