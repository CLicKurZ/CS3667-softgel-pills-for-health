package pills;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * This is the implemented class GelatinGenerator class 
 * of CasingGenerator which builds the Casing.
 *
 * @author Squad Dos
 * @version 6.8.23
 */
public class GelatinGenerator extends UnicastRemoteObject 
    implements CasingGenerator
{
    /**
     * No-arg constructor for the generator.
     * 
     * @throws RemoteException Handles RemoteException.
     */
    protected GelatinGenerator() throws RemoteException
    {
        super();
    }

    /**
     * Constructor for generator using a port number.
     * 
     * @param port The int port number.
     * @throws RemoteException Handles RemoteException.
     */
    protected GelatinGenerator(int port) throws RemoteException
    {
        super(port);
    } 

    /**
     * This is the constructor for GelatinGeneraot 
     * objects which uses parameters
     * for the volume and color.
     * Prints a statement for for Gelatin and retuns it.
     * 
     * @param volume volume of the pill
     * @param color color of the pill
     * @return Gelatin Casing.
     */
    @Override
    public Casing generateCasing(double volume, Color color) 
        throws RemoteException
    {
        System.out.printf("Mixing gelatin, water, opacifier, and glycerin...\n"
            + "Shaping...\n Returning %.2fml %s gelatin casing...\n",
            volume, color);
        return Casing.GELATIN;
    }
}
