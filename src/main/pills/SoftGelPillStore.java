package pills;

import java.io.PrintStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * SoftGelPillStore client class to use in Demo that
 * runs the necessary checks and logging information.
 * 
 * @author Squad Dos
 * @version 6.23.23
 */
public class SoftGelPillStore 
{
    private GelCapFactory factory;
    private ArrayList<GelCap> currentOrder;
    private Scanner input = new Scanner(System.in);
    private PrintStream output = System.out;
    private String customerName = "";
    private int customerAge = 0;
    private boolean isLoggedIn = false;
    private StrengthInspector si;
    private FailureInspector fi;
    private ConsistencyInspector ci;

    /**
     * Constructor for Client/SoftGelPillStore.
     * 
     * @param input Scanner for user input.
     * @param output Output for Checkout and successes or failures.
     */
    public SoftGelPillStore(Scanner input, PrintStream output)
    {
        currentOrder = new ArrayList<>();
        this.input = input;
        this.output = output;
        isLoggedIn = false;
        si = new StrengthInspector();
        fi = new FailureInspector();
        ci = new ConsistencyInspector();
    }

    /**
     * No-arg constructor for Client.
     */
    public SoftGelPillStore()
    {
        this(new Scanner(System.in), System.out);
        currentOrder = new ArrayList<>();

    }

    /**
     * Checkout method to finish program.
     * Checks if order is okay to checkout first.
     * 
     * @return orderArray GelCap array with pills in current order.
     */
    public GelCap[] checkOut()
    {
        if (currentOrder.size() > 0)
        {
            output.println("\nYour order has been processed\n");

            boolean validChoice = false;
            int subChoice = 0;

            while (!validChoice) 
            {
                output.println("Do you want to:"
                        + "\n1. Login"
                        + "\n2. Exit");

                try 
                {
                    subChoice = input.nextInt();
                    if (subChoice == 1 || subChoice == 2)
                    {
                        validChoice = true;
                    } 
                    else 
                    {
                        output.println("Invalid choice. Please enter 1 or 2.");
                    }
                } 
                catch (InputMismatchException e) 
                {
                    output.println("Invalid input!" 
                        + " Please enter a numeric choice.");
                    input.nextLine();
                }
            }

            if (subChoice == 1) 
            {
                input.nextLine();
                logIn();
                return null;
            } 
            else if (subChoice == 2) 
            {
                output.println("Thank you for using our service. Goodbye!");
                logOut();
                return null;
            }
        }
        if (currentOrder == null || currentOrder.size() == 0)
        {
            output.println("\nPlease select your order before " 
                + "checking out.\n");
            return null;
        }
        if (isInconsistent())
        {
            output.println("\nSomething went wrong: please try to " 
                + "place your order again.\n");
            currentOrder = new ArrayList<GelCap>();
            return null;
        }
        double failRate = checkFailRate();
        if (tooBigFailRate(failRate))
        {
            output.println("We're sorry, something went wrong. "
                + "Please try to place your order again.");
            currentOrder = new ArrayList<GelCap>();
            return null;
        }

        GelCap[] orderArray = currentOrder.toArray(new GelCap[0]);
        currentOrder = new ArrayList<GelCap>();
        return orderArray;
    }

    /**
     * Order method to set currentOrder.
     */
    public void order() 
    {
        do 
        {
            try 
            {
                output.println("\nWhat would you like to do?"
                        + "\n1. Order AcheAway\n2. Order Dreamly"
                        + "\n3. View Order" + "\n4. Checkout"
                        + "\n5. LogOut\n");
                int choice = input.nextInt();

                switch (choice) 
                {
                    case 1:
                        output.println("\nHow many AcheAway" 
                            + " pills would you like to order?");
                        int acheAwayQuantity = input.nextInt();
                        if (acheAwayQuantity > 0) 
                        {
                            for (int i = 0; i < acheAwayQuantity; i++) 
                            {
                                GelCap acheAway = factory.produceAcheAway();
                                if (acheAway instanceof ChildAcheAway) 
                                {
                                    si.inspect((ChildAcheAway) acheAway); 
                                    currentOrder.add(acheAway);
                                } 
                                else if (acheAway instanceof AdultAcheAway) 
                                {
                                    si.inspect((AdultAcheAway) acheAway); 
                                    currentOrder.add(acheAway);
                                }
                                else if (acheAway instanceof NullAcheAway)
                                {
                                    output.println("The AcheAway" 
                                        + " pill production" 
                                        + " has encountered a problem.");
                                }
                            }
                            output.println(acheAwayQuantity 
                                + " AcheAway pills added to the order.");
                        }
                        break;
                    case 2:
                        output.println("\nHow many Dreamly"
                            + " pills would you like to order?");
                        int dreamlyQuantity = input.nextInt();
                        if (dreamlyQuantity > 0) 
                        {
                            for (int i = 0; i < dreamlyQuantity; i++) 
                            {
                                GelCap dreamly = factory.produceDreamly();
                                if (dreamly instanceof ChildDreamly) 
                                {
                                    si.inspect((ChildDreamly) dreamly);
                                    currentOrder.add(dreamly);
                                } 
                                else if (dreamly instanceof AdultDreamly) 
                                {
                                    si.inspect((AdultDreamly) dreamly);
                                    currentOrder.add(dreamly);
                                }
                                else if (dreamly instanceof NullDreamly)
                                {
                                    output.println("The Dreamly pill"
                                        + " production has"
                                        + " encountered a problem.");
                                }
                            }
                            output.println(dreamlyQuantity 
                                + " Dreamly pills added to the order.");
                        } 
                        break;
                    case 3:
                        printCurrentOrder();
                        output.printf("\nCurrent Order: "
                            + "%.2fmg AcheAway, %.2fmg Dreamly\n", 
                            getAcheAwayStrength(), getDreamlyStrength());
                        break;
                    case 4:
                        checkOut();

                        si.reset();

                        
                        break;
                    case 5:
                        output.println("\nThank you for"
                            + " using our service. Goodbye!");
                        logOut();
                        break;
                    default:
                        output.println("Invalid choice. "
                            + "Please enter 1, 2, 3, 4, or 5.");
                        break;
                }
            } 
            catch (RemoteException e) 
            {
                output.println("Caught RemoteException.");
            } 
            catch (InputMismatchException e) 
            {
                output.println("Invalid input! Please try again.");
                input.next(); 
            } 
            catch (NullPointerException e)
            {
                output.println("Error producing pill.");
            }
        } 
        while (isLoggedIn);
        input.close();
    }



    /**
     * Asks the user for login info (name & age),
     * then uses arg logIn method to log user in.
     */
    public void logIn() 
    {
        logOut();
        do 
        {
            output.print("Welcome to SoftGelPillStore\n"
                + "Please enter your name: ");
            this.customerName = input.nextLine();

            if (this.customerName.matches(".*\\d.*")) 
            {
                output.println("Invalid input."
                    + " Name should not contain numbers.");
            }
        } 
        while (this.customerName.matches(".*\\d.*"));

        do 
        {
            try 
            {
                output.print("Please enter your age: ");
                int customerAge = input.nextInt();
                input.nextLine();
                if (customerAge < 0) 
                {
                    output.println("Age cannot be a negative number."
                        + " Try again.");
                } 
                else 
                {
                    logIn(customerName, customerAge);
                    return;
                }
            } 
            catch (InputMismatchException e) 
            {
                output.println("Invalid input. Please enter a valid age.");
                input.nextLine();
            }
        } 
        while (!isLoggedIn);
    }



    /**
     * Logs the user in with their name and age inputs
     * and make either an Adult or ChildGelCapFactory based on age.
     * 
     * @param name Customer name.
     * @param age Customer age.
     */
    public void logIn(String name, int age)
    {
        customerName = name;
        customerAge = age;
        isLoggedIn = true;
        if (customerAge < 18)
        {
            factory = ChildGelCapFactory.getInstance();
        }
        else 
        {
            factory = AdultGelCapFactory.getInstance();
        }
    }

    /**
     * Log out method that ends the user's session
     * by resetting fields.
     * 
     * @return If logOut was successful.
     */
    public boolean logOut()
    {
        if (!isLoggedIn)
        {
            return false;
        }
        currentOrder.clear();
        factory = null;
        customerName = "";
        customerAge = 0;
        isLoggedIn = false;
        return true;
    }

    /**
     * Sets the Output PrintStream.
     * 
     * @param output
     */
    public void setOutput(PrintStream output)
    {
        if (output == null) 
        {
            this.output = System.out;
        } 
        else 
        {
            this.output = output;
        }
    }

    /**
     * Sets the input scanner.
     * 
     * @param input
     */
    public void setInput(Scanner input)
    {
        if (input == null) 
        {
            this.input = new Scanner(System.in);
        } 
        else 
        {
            this.input = input;
        }
    }

    /**
     * Returns the output PrintStream.
     * 
     * @return output
     */
    public PrintStream getOutput()
    {
        return this.output;
    }

    /**
     * Returns the input Scanner.
     * 
     * @return input
     */
    public Scanner getInput()
    {
        return this.input;
    }

    /**
     * Uses StrengthInspector to get strength 
     * of Dreamly.
     * 
     * @return Strength of Dreamly.
     */
    public double getDreamlyStrength()
    {
        return si.getDreamlyStrength();
    }

    /**
     * Uses StrengthInspector to get strength
     * of AcheAway.
     * 
     * @return Strength of AcheAway.
     */
    public double getAcheAwayStrength()
    {
        return si.getAcheAwayStrength();
    }

    /**
     * Prints the current order.
     */
    public void printCurrentOrder()
    {
        if (currentOrder.size() == 0) 
        {
            output.println("\nYour order is empty.\n");
            return;
        }

        output.println("\nCurrent Order:\n");

        int acheAwayCount = 0;
        int dreamlyCount = 0;

        for (GelCap gelCap : currentOrder) 
        {
            if (gelCap instanceof AcheAway)
            {
                acheAwayCount++;
            } 
            else if (gelCap instanceof Dreamly) 
            {
                dreamlyCount++;
            }
        }

        if (acheAwayCount > 0) 
        {
            output.printf("AcheAway Pills: %d\n", acheAwayCount);
        }

        if (dreamlyCount > 0) 
        {
            output.printf("Dreamly Pills: %d\n", dreamlyCount);
        }
    }

    /**
     * Returns whether or not the fail rate is too high for 
     * the current order.
     * 
     * @param failRate The rate of failure.
     * @return If failRate is too big or not.
     */
    private boolean tooBigFailRate(double failRate)
    {
        if (failRate > .1)
        {
            return true;
        }
        return false;
    }

    /**
     * Checks the rate of failure to use in
     * tooBigFailRate using FailureInspector.
     * 
     * @return Rate of failure.
     */
    private double checkFailRate()
    {
        return fi.getFailRate();
    }

    /**
     * Checks if the order is inconsistent using
     * ConsistencyInspector.
     * 
     * @return If the order is inconsistent.
     */
    private boolean isInconsistent()
    {
        return ci.soFarSoConsistent();
    }
}
