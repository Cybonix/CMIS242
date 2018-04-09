
import javax.swing.JOptionPane;

/**
 * @author Mark Orimoloye
 * 08 April 2018
 * Handles all exceptions
 */
public class InsufficientFunds extends Exception 
{
    public InsufficientFunds()
    {
        // If account balance is less than 0, throw Exception.
        JOptionPane frame = new JOptionPane();
        JOptionPane.showMessageDialog(frame, "You have insufficient funds.");
    }
    
    public InsufficientFunds(String e)
    {
        // If account balance is less than 0, throw Exception.
        JOptionPane frame = new JOptionPane();
        JOptionPane.showMessageDialog(frame, "You have insufficient funds.");
    }
}
