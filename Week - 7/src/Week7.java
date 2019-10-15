/**
 * @author Mark Orimoloye
 * 29 April 2018
 * Two simple array methods.
 */
public class Week7
{
    public static void main(String[] args)
    {
        Integer[] iray = {1,2,3,4};
        Character[] cray = {'b','o','o','k'};
        
        printMe(iray);
        printMe(cray);
    }
    
    // Impletmenting a generic method
    public static <T> void printMe(T[] x)
    {
        for (T i : x)
            System.out.printf("%s ", i);
        System.out.println();
    }
}