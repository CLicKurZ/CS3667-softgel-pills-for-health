package pills;

import java.rmi.RemoteException;

/**
 * Mock for generating Casing.
 * 
 * @author Squad Dos
 * @version 6.18.23
 */
public class CasingGeneratorMock implements CasingGenerator
{
    public static final String PRINT_STATEMENT = "";
    public static final Casing RETURN_VALUE = Casing.GELATIN;

    /**
     * This method takes an amount and returns the Solution.
     * 
     * @return Casing
     * @param volume
     * @param color
     * @throws RemoteException
     */
    @Override
    public Casing generateCasing(double volume, Color color)
        throws RemoteException
    {
        System.out.println(PRINT_STATEMENT);
        return RETURN_VALUE;
    }
}
