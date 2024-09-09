package pills;
import java.rmi.RemoteException;

/**
 * Mock for generating Solution.
 * 
 * @author Squad Dos
 * @version 6.18.23
 */
public class SolutionGeneratorMock implements SolutionGenerator
{
    public static final String PRINT_STATEMENT = "";
    public static final Solution RETURN_VALUE = Solution.OIL;

    /**
     * This method takes an amount and returns the Solution.
     * 
     * @return Solution
     * @param volume
     * @throws RemoteException
     */
    @Override
    public Solution generateSolution(double volume) throws RemoteException
    {
        System.out.println(PRINT_STATEMENT);
        return RETURN_VALUE;
    }
}
