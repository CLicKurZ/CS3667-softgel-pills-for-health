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
public class OilGenerator extends UnicastRemoteObject 
    implements SolutionGenerator
{
    /**
     * No-arg constructor for the generator.
     * 
     * @throws RemoteException Handles RemoteException.
     */
    protected OilGenerator() throws RemoteException
    {
        super();
    }

    /**
     * Constructor for generator using a port number.
     * @param port The int port number.
     * 
     * @throws RemoteException Handles RemoteException.
     */
    protected OilGenerator(int port) throws RemoteException
    {
        super(port);
    } 

    /**
     * This is the method for generateSolution 
     * objects which uses parameters
     * for the volume.
     * 
     * @param volume volume of the pill
     * @return Oil Solution.
     */
    @Override
    public Solution generateSolution(double volume) 
        throws RemoteException
    {
        System.out.printf("Extracting pill-sized quantity of oil...\n"
            + "Returning %.2fmL oil solution\n", volume);
        return Solution.OIL;
    }
}
