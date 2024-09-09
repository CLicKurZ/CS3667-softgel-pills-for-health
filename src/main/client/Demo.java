package client;
import pills.SoftGelPillStore;


/**
 * This is the Demo class. It uses the SoftGelPillStore
 * as a client program to allow the user to log in, 
 * order pills, view their order, checkout, and log out.
 * 
 * @author Squad Dos
 * @version 6.19.23
 */
public class Demo
{
    public static SoftGelPillStore client = new SoftGelPillStore();

    /**
     * This is the main method for the Demo class. It prompts the user
     * for an input of which pill they'd like to demo and prints the
     * demo information to the console.
     * 
     * @param args command line args
     */
    public static void main(String[] args)
    {  
        client.logIn();
        client.order();       

    }
}
