package pills;

/**
 * Mock Class to instantiate GelCapFactory for its test.
 * This mock class does not mention any specific mock implementations.
 * It simply prints the method name and returns the mock objects.
 * Replace the return statements with the appropriate mock object creations.
 * 
 * Note: The mock objects should be created externally 
 * and passed as parameters to this class.
 * 
 * @author Squad Dos
 * @version 6.19.23
 */
public class GelCapFactoryMock extends GelCapFactory 
{
    public static final String CORRECT_PRINT_DREAMLY
        = "manufactureDreamly called";
    public static final String CORRECT_PRINT_ACHEAWAY 
        = "manufactureAcheAway called";
    public DreamlyMock dreamlyMock;
    public AcheAwayMock acheAwayMock;


    @Override
    protected DreamlyMock manufactureDreamly(CasingGenerator cg,
        SolutionGenerator sg, ActiveIngredientGenerator aig) 
    {
        System.out.println(CORRECT_PRINT_DREAMLY);
        return dreamlyMock;
    }

    @Override
    protected AcheAwayMock manufactureAcheAway(CasingGenerator cg, 
        SolutionGenerator sg, ActiveIngredientGenerator aig) 
    {
        System.out.println(CORRECT_PRINT_ACHEAWAY);
        return acheAwayMock;
    }
}

