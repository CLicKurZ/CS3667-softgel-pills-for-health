package pills;

import java.rmi.RemoteException;
import java.rmi.Remote;

/**
 * This is the interface class SolutionGenerator class 
 * which builds the generateSolution method.
 *
 * @author Squad Dos
 * @version 6.19.23
 */
public interface SolutionGenerator extends Remote
{
    /**
     * This is the method for generateSolution 
     * objects which uses a parameter
     * for the volume.
     * 
     * @param volume volume of the pill
     * @return Solution
     * @throws RemoteException
     */
    public Solution generateSolution(double volume) 
        throws RemoteException;
}
