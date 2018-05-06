
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Joseph Mark Orimoloye
 * Week 8 - Converting an array into a list and back.
 * 06 May 2018
 */
public class Week8 
{
    public static void main(String[] args) 
    {
           String[] candies = {"Blowpops", "Now-and-Laters","Lemonheads","Skittles" };
           
           System.out.println("Candies array before list conversion and additions: \n");
           for(String x : candies)
               System.out.printf("%s ", x);
           
           // Converting the candies array into a linked list
           LinkedList<String> thelist = new LinkedList<>(Arrays.asList(candies));
           
           // Now, we can use list and collection methods on the array... Cool~!
           thelist.add("Jawbreakers");
           thelist.addFirst("Redhots");
           
           // Convert back to an array... watch this!
           candies = thelist.toArray(new String[thelist.size()]);
           
           System.out.println("\n\n\n Candies array after the list conversion and additions: \n");
           
           for(String x : candies)
               System.out.printf("%s ", x);
    }
}
