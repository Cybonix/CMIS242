/**
 * Superclass Employee
 * 
 * @author Mark Orimoloye
 */
public class Employee 
{
    private String name;
    private double mthlySalary;

	//constructor
	public Employee(String name, double mthlySalary) 
        {
            this.name = name;
            this.mthlySalary = mthlySalary;
	}
        
    public double annualSalary() 
        {
            double aSalary = mthlySalary * 12;
            return aSalary;
	}

    @Override
	public String toString() 
        {
            String strg = name + " makes " 
                    + String.valueOf(mthlySalary) + " a month, which is equal to " 
                    + String.valueOf(annualSalary()) + " a year.";
            return strg;
	}
}