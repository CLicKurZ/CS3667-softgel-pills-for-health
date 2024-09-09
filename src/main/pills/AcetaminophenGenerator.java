package pills;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * This is the class AcetaminophenGenerator which implements the
 * interface ActiveIngredientGenerator.
 * 
 * @author Squad Dos
 * @version 6.17.23
 */
public class AcetaminophenGenerator extends UnicastRemoteObject 
    implements ActiveIngredientGenerator
{
    /**
     * No-arg constructor for the generator.
     * 
     * @throws RemoteException Handles RemoteException.
     */
    protected AcetaminophenGenerator() throws RemoteException
    {
        super();
    }

    /**
     * Constructor for generator using a port number.
     * 
     * @param port The int port number.
     * @throws RemoteException Handles RemoteException.
     */
    protected AcetaminophenGenerator(int port) throws RemoteException
    {
        super(port);
    } 

    /**
     * Implementation from ActiveIngredientGenerator.
     * 
     * @param amount The amount of Active Ingredient in the pill.
     * @return The Acetaminophen Active Ingredient.
     */
    @Override
    public ActiveIngredient generateActiveIngredient(double amount) 
        throws RemoteException
    {
        System.out.printf("Acetylating para-aminophenol with acetic "
            + "anhydride\nCarefully extracting %.2fmg of acetaminophen\n"
            + "Returning %.2fmg of acetaminophen\n", amount, amount);
        return ActiveIngredient.ACETAMINOPHEN;
    }
}
