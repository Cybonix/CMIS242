/**
 * Subclass Executive
 * 
 * @author Mark Orimoloye
 */
public class Executive extends Employee
{
    double stockPrice;
    
    //constructor
    public Executive(String name, double mthlySalary, double stockPrice)
    {
        super(name, mthlySalary);
        this.stockPrice = stockPrice;
    }
    
    @Override
    public double annualSalary()
    {
        double execSalary;
        
        if (stockPrice > 50) 
        {
            execSalary = 30000 + super.annualSalary();
        } else 
            {
                execSalary = super.annualSalary();
            }
        
        return execSalary;
    }
    
    @Override
    public String toString()
    {
        String strg = "";
        
        return strg;
    }
}