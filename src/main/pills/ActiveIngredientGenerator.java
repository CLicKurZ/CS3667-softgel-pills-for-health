package pills;

import java.rmi.RemoteException;
import java.rmi.Remote;

/**
 * Interface for generating ActiveIngredient.
 * 
 * @author Squad Dos
 * @version 6.17.23
 */
public interface ActiveIngredientGenerator extends Remote
{
    /**
     * This method takes an amount and returns the ActiveIngredient.
     * 
     * @param amount
     * @return Active Ingredient
     * @throws RemoteException
     */
    public ActiveIngredient generateActiveIngredient(double amount) 
        throws RemoteException;
}
