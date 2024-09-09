package pills;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


/**
 * This is the implemented class OilGenerator class 
 * of SolutionGenerator which builds the Solution.
 *
 * @author Squad Dos
 * @version 6.19.23
 */
public class SalineGenerator extends UnicastRemoteObject 
    implements SolutionGenerator
{
    /**
     * No-arg constructor for the generator.
     * 
     * @throws RemoteException Handles RemoteException.
     */
    protected SalineGenerator() throws RemoteException
    {
        super();
    }

    /**
     * Constructor for generator using a port number.
     * 
     * @param port The int port number.
     * @throws RemoteException Handles RemoteException.
     */
    protected SalineGenerator(int port) throws RemoteException
    {
        super(port);
    } 

    /**
     * This is the method for generateSolution
     * objects which uses parameters
     * for the volume.
     * 
     * @param volume volume of the pill
     * @return Saline Solution
     */
    @Override
    public Solution generateSolution(double volume) throws RemoteException
    {
        System.out.printf("Mixing salt and water...\n"
            + "Verifying ratio...\n"
            + "Returning %.2fmL saline solution", volume);
        return Solution.SALINE;
    }
}
