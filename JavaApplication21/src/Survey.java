
import javax.swing.JFrame;

/**
 *
 * @author Mark Orimoloye
 */
public class Survey 
{
    public static void main(String[] args) 
    {
        SurveyBox box = new SurveyBox();
        box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        box.setSize(400, 200);
        box.setVisible(true);
    }
}
