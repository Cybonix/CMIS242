
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Mark Orimoloye
 * 08 April 2018
 * Creates GUI for the ATM transactions, contains the event handlers
 * and main method.
 */
public class ATM extends JFrame
{
    //Private variables for GUI
    private JButton withdraw;
    private JButton deposit;
    private JButton transfer;
    private JButton balance;
    private JRadioButton checking;
    private JRadioButton savings;
    private JTextField box;
    
    static Account checkingAccount;
    static Account savingAccount;
    
    //constructor to create GUI
    public  ATM()
    {
        //creates visible panels
        super("ATM Machine");
        setLayout(new BorderLayout());
        JPanel first = new JPanel(new GridLayout(0,1));
        JPanel third = new JPanel();
        JPanel second = new JPanel(new GridLayout(3,2,10,10));
        
        box = new JTextField(50);
        checking = new JRadioButton("Checking");
        savings = new JRadioButton("Savings");
        withdraw = new JButton("Withdraw");
        deposit = new JButton("Deposit");
        balance = new JButton("Balance");
        transfer = new JButton("Transfer to");
        
        second.add(withdraw);
        second.add(deposit);
        second.add(transfer);
        second.add(balance);
        second.add(checking);
        second.add(savings);
        first.add(second);
        third.add(box);
        first.add(third);
        add(first, BorderLayout.CENTER);
        
        ButtonGroup group = new ButtonGroup();
        group.add(checking);
        group.add(savings);
        HandlerClass handler = new HandlerClass();
        
        checking.setSelected(true);
        withdraw.addActionListener(handler);
        deposit.addActionListener(handler);
        transfer.addActionListener(handler);
        balance.addActionListener(handler);  
    }
    
    //This class handles all actions from all GUI button events.
    private class HandlerClass implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            double amount = 0;
            Account chosen;
            Account notChosen;
            
            if (checking.isSelected())
            {
                chosen = checkingAccount;
                notChosen = savingAccount;
            }
            else
            {
                chosen = savingAccount;
                notChosen = checkingAccount;
            }
            
            if (e.getSource() != balance)
            {
                try 
                {
                    amount = Double.parseDouble(box.getText());
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Enter numeric value in field.");
                    return;
                }
            }
            
            if (e.getSource() == withdraw)
            {
                if (amount % 20 != 0)
                {
                    JOptionPane.showMessageDialog(null, "The amount should be in increments of $20");
                    return;
                }
                try
                {
                    chosen.withdraw(amount);
                }
                catch(InsufficientFunds ex)
                {
                    JOptionPane.showMessageDialog(null, ex);
                    return;
                }
                
                if((checkingAccount.getWithdrawals() + savingAccount.getWithdrawals()) > 4)
                {
                    JOptionPane.showMessageDialog(null, "Total Withdrew with service charge: $" + (amount + 1.50));
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Withdrew: $" + amount);
                }
            }
            else if (e.getSource() == deposit)
            {
                chosen.deposit(amount);
                JOptionPane.showMessageDialog(null, "Deposited: $" + amount);
            }
            else if (e.getSource() == transfer)
            {
                try
                {
                    notChosen.transfer(amount, chosen);
                }
                catch (InsufficientFunds ex)
                {
                    JOptionPane.showMessageDialog(null, ex);
                }
                
                JOptionPane.showMessageDialog(null, "Transferred: $" + amount);
            }
            else if (e.getSource() == balance)
            {
                JOptionPane.showMessageDialog(null, chosen.getBalance());
            }
        }
    }
    
    public static void main(String[] args) 
    {
        // Create the accounts
        checkingAccount = new Account(0);
        savingAccount = new Account(0);
        
        ATM finish = new ATM();
        finish.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finish.pack();
        finish.setVisible(true);
    }
    
}

