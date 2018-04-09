
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 08 April 2018
 * This program populates a label field from keyboard inputs, and reset fields.
 * @author Mark Orimoloye
 */
public class Gui extends JFrame implements KeyListener,ActionListener
{
    // Using three components from the java swing library
    JTextField keyText = new JTextField(80);
    JLabel keyLabel = new JLabel("Press Fire Button~!");
    JButton reset = new JButton("Reset");
    
    Gui()
    {
        keyText.addKeyListener(this);
        reset.addActionListener(this);
        setSize(300, 150);
        setVisible(true);
        setLocationRelativeTo(null);  // This will center screen the running application.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        add(keyLabel, BorderLayout.NORTH);
        add(keyText, BorderLayout.CENTER);
        add(reset, BorderLayout.SOUTH);
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        // Not using this method
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        
        if(keyCode == KeyEvent.VK_F)
        {
            keyLabel.setText("Ooga... Ooga... Torpedoes Away~!");
        }
        else
        {
            keyLabel.setText("You didn't press the fire button!");
        }
        
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
        // Not using this method
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        keyLabel.setText("Press Fire Button~!");
        keyText.setText("");
    }
    
    public static void main(String[] args) 
    {
        Gui go = new Gui();
    }

}
