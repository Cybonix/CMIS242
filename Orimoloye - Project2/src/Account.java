/**
 * @author Mark Orimoloye
 * 08 April 2018
 * Handles account transactions
 */
public class Account 
{
    private double balance;
    private int withdrawals;
    
    //create account constructor
    public Account(double initialBalance)
    {
        balance = initialBalance;
        withdrawals = 0;
    }
    
    //get the balance
    public double getBalance()
    {
        return balance;
    }
    
    //make a deposit
    public void deposit(double amount)
    {
        balance +=amount;
    }
    
    //check balance
    public void withdraw(double amount) throws InsufficientFunds 
    {
        if (amount > balance)
        {
            throw new InsufficientFunds("Insufficient funds");
        }
        else 
        {
            balance -= amount;
            withdrawals++;
        }
    }
    
    //number of withdrawals
    public int getWithdrawals()
    {
        return withdrawals;
    }
    
    //add service fee
    public void serviceFee() throws InsufficientFunds
    {
        if (1.5 > balance)
        {
            throw new InsufficientFunds("Insufficient Funds");
        }
        else
        {
            balance -= 1.5;
        }
    }
    
    public void transfer(double amount, Account toAccount) throws InsufficientFunds
    {
        //withdraw from this account
        this.withdraw(amount);
        
        //deposit to the other account
        toAccount.deposit(amount);
    }
}
