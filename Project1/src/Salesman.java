/**
 * Subclass Salesman
 * 
 * @author Mark Orimoloye
 */
public class Salesman extends Employee 
{
	private double annualSales;
        
        //contructor
        public Salesman(String name, double mthlySalary, double annualSales)
        {
            super(name, mthlySalary);
            this.annualSales = annualSales;
        }
        
        @Override
        public double annualSalary() 
        {
            if (annualSales > 1000000) 
            {
                annualSales = 1000000;
            }
            
            double smanSalary =  (annualSales * 0.02) + super.annualSalary();
        return smanSalary;
        }
        
        @Override
        public String toString ()
        {
            String strg = super.toString() 
                    + " This Salesman also made " + annualSales 
                    +" in annual sales.";
            return strg;
        }
        
  
}