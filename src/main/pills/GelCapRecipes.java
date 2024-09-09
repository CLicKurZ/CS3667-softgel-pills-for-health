package pills;

import java.util.HashMap;
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.net.MalformedURLException;

/**
 * Recipes for all GelCap pills.
 * Utilized by Factories.
 * 
 * @author Squad Dos
 * @version 6.8.23
 */
public class GelCapRecipes
{
    public static final HashMap<String, CasingGenerator> CASINGS
        = getCasings();
    public static final HashMap<String, SolutionGenerator> SOLUTIONS
        = getSolutions();
    public static final HashMap<String, ActiveIngredientGenerator> ACTIVES
        = getActives();

    private static HashMap<String, CasingGenerator> getCasings()
    {
        HashMap<String, CasingGenerator> map = new HashMap<>();
        try
        {
            CasingGenerator plasticizerGen =
                (CasingGenerator) Naming.lookup(
                "rmi://152.10.10.40/PlasticizerGenerator");
            CasingGenerator gelatinGen =
                (CasingGenerator) Naming.lookup(
                "rmi://152.10.10.40/GelatinGenerator");
            map.put("dreamly", plasticizerGen);
            map.put("acheaway", gelatinGen);
        }
        catch (MalformedURLException | RemoteException | NotBoundException e)
        {
            e.printStackTrace();
        }
        return map;
    }

    private static HashMap<String, SolutionGenerator> getSolutions()
    {
        HashMap<String, SolutionGenerator> map = new HashMap<>();
        try
        {
            SolutionGenerator oilGen =
                (SolutionGenerator) Naming.lookup(
                "rmi://152.10.10.40/OilGenerator");
            SolutionGenerator salineGen =
                (SolutionGenerator) Naming.lookup(
                "rmi://152.10.10.40/SalineGenerator");
            map.put("dreamly", oilGen);
            map.put("acheaway", salineGen);
        }
        catch (MalformedURLException | RemoteException | NotBoundException e)
        {
            e.printStackTrace();
        }
        return map;
    }

    private static HashMap<String, ActiveIngredientGenerator> getActives()
    {
        HashMap<String, ActiveIngredientGenerator> map = new HashMap<>();
        try
        {
            ActiveIngredientGenerator zolpidemGen =
                (ActiveIngredientGenerator) Naming.lookup(
                "rmi://152.10.10.40/ZolpidemGenerator");
            ActiveIngredientGenerator actaminophenGen =
                (ActiveIngredientGenerator) Naming.lookup(
                "rmi://152.10.10.40/AcetaminophenGenerator");
            map.put("dreamly", zolpidemGen);
            map.put("acheaway", actaminophenGen);
        }
        catch (MalformedURLException | RemoteException | NotBoundException e)
        {
            e.printStackTrace();
        }
        return map;
    }
}
