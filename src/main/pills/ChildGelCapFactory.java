package pills;

import java.rmi.RemoteException;

/**
 * Factory class for Child GelCap pills.
 * 
 * @author Squad Dos
 * @version 6.13.23
 */
public class ChildGelCapFactory extends GelCapFactory
{
    private static ChildGelCapFactory instance;

    /**
     * No-arg constructor for ChildGelCapFactory instance.
     */
    private ChildGelCapFactory()
    {
        super();
    }

    /**
     * Manufacture method for Child Dreamly pills.
     * @param cg Casing generator used for the pills.
     * @param sg Solution generator used for the pills.
     * @param aig Active Ingredient generator used for the pills.
     * @return The Child Dreamly pill created.
     */
    @Override
    protected Dreamly manufactureDreamly(CasingGenerator cg, 
        SolutionGenerator sg, ActiveIngredientGenerator aig)
    {
        System.out.println("Manufacturing child version of Dreamly");
        try 
        {
            ActiveIngredient activeIngredient = 
                aig.generateActiveIngredient(ChildDreamly.STRENGTH);
            Solution solution = 
                sg.generateSolution(ChildDreamly.VOLUME);
            Casing casing = 
                cg.generateCasing(ChildDreamly.VOLUME, ChildDreamly.COLOR);
            return new ChildDreamly(activeIngredient, solution, casing);
        }
        catch (RemoteException e) 
        {
            return new NullDreamly();
        }
    }

    /**
     * Manufacture method for Child AcheAway pills.
     * @param cg Casing generator used for the pills.
     * @param sg Solution generator used for the pills.
     * @param aig Active Ingredient generator used for the pills.
     * @return The Child AcheAway pill created.
     */
    @Override
    protected AcheAway manufactureAcheAway(CasingGenerator cg, 
        SolutionGenerator sg, ActiveIngredientGenerator aig)
    {
        System.out.println("Manufacturing child version of AcheAway");
        try 
        {
            ActiveIngredient activeIngredient =
                aig.generateActiveIngredient(ChildAcheAway.STRENGTH);
            Solution solution = 
                sg.generateSolution(ChildAcheAway.VOLUME);
            Casing casing = 
                cg.generateCasing(ChildAcheAway.VOLUME, ChildAcheAway.COLOR);
            return new ChildAcheAway(activeIngredient, solution, casing);
        }
        catch (RemoteException e) 
        {
            System.out.println("This pill has failed.");
            return new NullAcheAway();
        }
    }

    /**
     * Getter method for instance of ChildGelCapFactory.
     * 
     * @return The instance of ChildGelCapFactory
     */
    public static ChildGelCapFactory getInstance()
    {
        if (instance == null)
        {
            synchronized (ChildGelCapFactory.class) 
            {
                if (instance == null) 
                {
                    instance = new ChildGelCapFactory();
                }
            }
        }
        return instance;
    }
}
