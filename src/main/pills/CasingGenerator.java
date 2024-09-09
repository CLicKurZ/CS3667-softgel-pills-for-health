package pills;

import java.rmi.RemoteException;
import java.rmi.Remote;

/**
 * This is the interface class CasingGenerator class 
 * which builds the generateCasing method.
 *
 * @author Squad Dos
 * @version 6.8.23
 */
public interface CasingGenerator extends Remote
{
    /**
     * This is the method for generateCasing 
     * objects which uses parameters
     * for the volume and color.
     * 
     * @param volume volume of the pill
     * @param color color of the pill
     * @return Casing
     * @throws RemoteException
     */
    public Casing generateCasing(double volume, Color color) 
        throws RemoteException;
}

