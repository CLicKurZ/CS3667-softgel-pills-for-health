package pills;

/**
 * This is the null class for Dreamly pills.
 *
 * @author Squad Dos
 * @version 6-7-23
 */

public class NullDreamly extends Dreamly
{
    /**
     * Null constructor for Dreamly.
     */
    public NullDreamly()
    {
        super(0.0, 0.0, null, null, null, null);
    }

    /**
     * The accept method from GelCap.
     * 
     * @param i The Inspector object.
     */
    public void accept(Inspector i)
    {
        i.inspect(this);
    }
}
