package pills;

import java.rmi.RemoteException;
import java.util.Random;

/**
 * This is the abstract class for the GelCapFactory.
 *
 * @author Squad Dos
 * @version 6.8.23
 */
public abstract class GelCapFactory
{

    /**
     * Method for producing quality checked Dreamly pills.
     *
     * @return A Dreamly pill, either Null or Complete
     * @throws RemoteException
     */
    public final Dreamly produceDreamly() throws RemoteException
    {
        String dreamly = "dreamly";
        System.out.println("Creating a Dreamly pill...");
        Dreamly dreamlyPill = manufactureDreamly(
            GelCapRecipes.CASINGS.get(dreamly),
            GelCapRecipes.SOLUTIONS.get(dreamly),
            GelCapRecipes.ACTIVES.get(dreamly));
        if (qualityCheck())
        {
            System.out.println("quality check passed");
            return dreamlyPill;
        }
        else
        {
            System.out.println("quality check failed");
            return new NullDreamly();
        }
    }

    /**
     * Method for producing quality checked AcheAway pills.
     * 
     * @return An AcheAway pill, either Null or Complete
     * @throws RemoteException
     */
    public final AcheAway produceAcheAway() throws RemoteException
    {
        String aa = "acheaway";
        System.out.println("Creating an AcheAway pill...");
        AcheAway acheAwayPill = manufactureAcheAway(
            GelCapRecipes.CASINGS.get(aa),
            GelCapRecipes.SOLUTIONS.get(aa),
            GelCapRecipes.ACTIVES.get(aa));
        if (qualityCheck())
        {
            System.out.println("quality check passed");
            return acheAwayPill;
        }
        else
        {
            System.out.println("quality check failed");
            return new NullAcheAway();
        }
    }

    protected abstract Dreamly manufactureDreamly(CasingGenerator 
        cg, SolutionGenerator sg, ActiveIngredientGenerator aig) 
        throws RemoteException;

    protected abstract AcheAway manufactureAcheAway(CasingGenerator 
        cg, SolutionGenerator sg, ActiveIngredientGenerator aig) 
        throws RemoteException;


    /**
     * Quality check for GelCap pills that fails 
     * 10% of the time.
     * @return Whether or not it passed (random)
     */
    private final boolean qualityCheck()
    {
        System.out.println("Performing quality check...");
        Random r = new Random();
        int randomNum = r.nextInt(100);

        if (randomNum == 0)
        {
            return false;
        }
        return true;
    }
}
