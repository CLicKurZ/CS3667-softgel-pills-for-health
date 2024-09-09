package pills;

import java.rmi.RemoteException;

/**
 * Mock for generating ActiveIngredient.
 * 
 * @author Squad Dos
 * @version 6.18.23
 */
public class ActiveIngredientGeneratorMock implements ActiveIngredientGenerator
{
    public static final String PRINT_STATEMENT = "";
    public static final ActiveIngredient
        RETURN_VALUE = ActiveIngredient.ZOLPIDEM;

    /**
     * This method takes an amount and returns the ActiveIngredient.
     * 
     * @return ActiveIngredient
     * @param amount
     * @throws RemoteException
     */
    @Override
    public ActiveIngredient generateActiveIngredient(double amount)
        throws RemoteException
    {
        System.out.println(PRINT_STATEMENT);
        return RETURN_VALUE;
    }
}
