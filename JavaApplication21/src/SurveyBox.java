
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 * @author Mark Orimoloye
 * 15 April 2018
 * RadioButton survey example
 */
public class SurveyBox extends JFrame
{
    private JRadioButton out;
    private JRadioButton good;
    private JRadioButton norm;
    private JRadioButton not;
    private JRadioButton ter;
    private ButtonGroup group;
    
    public SurveyBox()
    {
        super("Thank you for taking our Survey!!");
        setLayout(new FlowLayout());
        
        JLabel question = new JLabel("How would you rate our customer service?", JLabel.CENTER);
        add(question);
        
        out = new JRadioButton("Outstanding");
        good = new JRadioButton("Good");
        norm = new JRadioButton("Normal");
        not = new JRadioButton("Not so good");
        ter = new JRadioButton("Terrible");
        
        out.setPreferredSize(new Dimension(100,25));
        out.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                JOptionPane.showMessageDialog(null, "We are thrilled to hear you had outstanding service!\nThank you! Come back again soon!", "Results", JOptionPane.PLAIN_MESSAGE);
            }
            
        });
        
        good.setPreferredSize(new Dimension(100,25));
        good.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                JOptionPane.showMessageDialog(null, "We are happy to hear you had good service!\nThank you for visting! Come back again soon!", "Results", JOptionPane.PLAIN_MESSAGE);
            }
            
        });
        
        norm.setPreferredSize(new Dimension(100,25));
        norm.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                JOptionPane.showMessageDialog(null, "We are sorry you didn't have outstanding service!\nWe will work on this in the future.\nThank you for visting! Come back again soon!", "Results", JOptionPane.PLAIN_MESSAGE);
            }
            
        });
        
        not.setPreferredSize(new Dimension(100,25));
        not.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                JOptionPane.showMessageDialog(null, "We appologise for not giving you outstanding service!\nWe will work hard to fix this in the future\nThank you! Come back again soon!", "Results", JOptionPane.PLAIN_MESSAGE);
            }
            
        });
        
        ter.setPreferredSize(new Dimension(100,25));
        ter.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                JOptionPane.showMessageDialog(null, "We appologise for not giving you good service!\nWe will work hard to fix this in the future\nThank you! Please back again soon!", "Results", JOptionPane.PLAIN_MESSAGE);
            }
            
        });
        
        add(out);
        add(good);
        add(norm);
        add(not);
        add(ter);
        
        group = new ButtonGroup();
        group.add(out);
        group.add(good);
        group.add(norm);
        group.add(not);
        group.add(ter);
    }
    
}
