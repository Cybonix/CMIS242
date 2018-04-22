
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * @author Mark Orimoloye
 * This GUI class allows you to choose between the iterative or recursive method
 * 22 April 2018
 */
public class GUI extends JFrame implements ActionListener
{
    // private variable for GUI
    private JRadioButton iterative = new JRadioButton("Iterative");
    private JLabel fill1 = new JLabel();
    private JLabel fill2 = new JLabel();
    private JLabel fill3 = new JLabel();
    private JLabel enterN = new JLabel("enter n");
    private JLabel result = new JLabel("Result");
    private JLabel efficiency = new JLabel("Efficiency");
    private JRadioButton recursive = new JRadioButton("Recursive");
    private ButtonGroup rBG = new ButtonGroup();
    private JButton compute = new JButton("Compute");
    private JTextField enterNBox = new JTextField();
    private JTextField resultBox = new JTextField();
    private JTextField efficiencyBox = new JTextField();
    
    // constructor to create GUI
    public GUI()
    {
        super("Iterative/Recursive Program");
        setBounds(100, 200, 300, 200);
        
        getContentPane().setLayout(new GridLayout(6,2));
        rBG.add(iterative);
        rBG.add(recursive);
        iterative.setSelected(true);
        getContentPane().add(fill1);
        getContentPane().add(iterative);
        getContentPane().add(fill2);
        getContentPane().add(recursive);
        getContentPane().add(enterN);
        getContentPane().add(enterNBox);
        getContentPane().add(fill3);
        compute.addActionListener(this);
        getContentPane().add(compute);
        getContentPane().add(result);
        getContentPane().add(resultBox);
        getContentPane().add(efficiency);
        getContentPane().add(efficiencyBox);
        addWindowListener(new WindowAdapterImpl());
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        int result;
        Sequence.efficiency = 0;
        if (iterative.isSelected())
        {
            result = Sequence.computeIterative(Integer.parseInt(enterNBox.getText()));
        }
        else
        {
            result = Sequence.computeRecursive(Integer.parseInt(enterNBox.getText()));
        }
        resultBox.setText(Integer.toString(result));
        efficiencyBox.setText(Integer.toString(Sequence.efficiency));
    }
    
    // On window close creates csv file
    private static class WindowAdapterImpl extends WindowAdapter 
    {
        public WindowAdapterImpl()
        {
            
        }
        
        public void windowClosing(WindowEvent e)
        {
            try 
            {
                int iterative;
                int recursive;
                FileWriter csv = new FileWriter("Efficiency Values.csv");
                for(int i = 0; i <= 10; i++)
                {
                    Sequence.computeIterative(i);
                    iterative = Sequence.getEfficiency();
                    Sequence.computeRecursive(i);
                    recursive = Sequence.getEfficiency();
                    csv.write(i + "," + iterative + "," + recursive + "\n");
                }
                csv.close();  
            }
            catch (IOException ex)
            {
                Logger.getLogger(Sequence.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) 
    {
        GUI test = new GUI();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);
    }
}
