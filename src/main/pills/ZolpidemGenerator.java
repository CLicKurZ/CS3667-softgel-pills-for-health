package pills;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * This is the class ZolpidemGenerator which implements the
 * interface ActiveIngredientGenerator.
 * 
 * @author Squad Dos
 * @version 6.17.23
 */
public class ZolpidemGenerator extends UnicastRemoteObject 
    implements ActiveIngredientGenerator
{
    /**
     * No-arg constructor for the generator.
     * 
     * @throws RemoteException Handles RemoteException.
     */
    protected ZolpidemGenerator() throws RemoteException
    {
        super();
    }

    /**
     * Constructor for generator using a port number.
     * 
     * @param port The int port number.
     * @throws RemoteException Handles RemoteException.
     */
    protected ZolpidemGenerator(int port) throws RemoteException
    {
        super(port);
    } 

    /**
     * This is the method for generateActiveIngredient which uses 
     * parameters for the volume.
     * 
     * @param amount Amount of solution.
     * @return Saline Solution
     */
    @Override
    public ActiveIngredient generateActiveIngredient(double amount)
        throws RemoteException
    {
        System.out.printf("Opening secure storage area...\n"
            + "Carefully extracting %.2fmg of zolpidem\n"
            + "Returning %.2fmg of zolpidem\n", amount, amount);
        return ActiveIngredient.ZOLPIDEM;
    }
}
