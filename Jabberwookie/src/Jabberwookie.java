
public class Jabberwookie {
    // Instance variables.  Attributes of Jabberwookie
	String color;
	String sex;
	Boolean hungry;

	// Behavior of Jabberwookie
	void feedJaba()	
	{
		if (hungry == true)
		{
			System.out.println("Yum -- a peasant!");
			hungry = false; // Jaba just ate. resetting.
		}
		else
			System.out.println("No, thanks -- already ate.");
	}

	// show the state of Jabberwookie
	void showAttribute()
	{
		System.out.println("This is a " + sex + " " + color + " Jabberwookie.");
		if (hungry == true)
		System.out.println("The Jabberwookie is hungry!");
		else
		System.out.println("The Jabberwookie is full.");
		
	}
        
        public static void main (String arguments[]) 
        {
            Jabberwookie Muba = new Jabberwookie();
            Muba.color = "orange";
            Muba.sex = "male";
            Muba.hungry = true;
            System.out.println("Calling showAttributes ... ");
            Muba.showAttribute();
            System.out.println("---------");
            System.out.println("Feeding the Jabberwookie ... ");
            Muba.feedJaba();
            System.out.println("---------");
            System.out.println("Calling showAttributes ... ");
            Muba.showAttribute();
            System.out.println("---------");
            System.out.println("Feeding the Jabberwookie ... ");
            Muba.feedJaba();
            
        }
}
