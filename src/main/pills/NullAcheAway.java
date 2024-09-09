package pills;

/**
 * This is the null class for AcheAway pills.
 *
 * @author Squad Dos
 * @version 6-7-23
 */

public class NullAcheAway extends AcheAway
{
    /**
     * Null constructor for AcheAway.
     */
    public NullAcheAway()
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
