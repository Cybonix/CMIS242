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
    
    public double annualSalary()
    {
        if (stockPrice > 50) 
        {
            double execSalary = 30000 + super.annualSalary();
        } else 
            {
                double execSalary = super.annualSalary();
            }
        
        return execSalary;
    }
    
    public String toString()
    {
        String strg = "";
        
        return strg;
    }
}
