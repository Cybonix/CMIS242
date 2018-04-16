
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @author Mark Orimoloye
 * 15 April 2028
 * Check boxes and radio buttons.
 */
public class NewClass extends JFrame
{
    JPanel p1, p2, p3, p4;
    JCheckBox cb1, cb2, cb3;
    JLabel lb01, lb02, lb03, lb04;
    JRadioButton b1, b2;
    ButtonGroup bgrp;
    
    public NewClass()
     {
         super("Path Of The Grasshopper");
         
         setSize(500, 300);
         
         p1 = new JPanel();
         p2 = new JPanel();
         p3 = new JPanel();
         p4 = new JPanel();
         
         cb1 = new JCheckBox("Mizaru");
         cb1.addActionListener(new ActionListener()
         {
             @Override
             public void actionPerformed(ActionEvent ae) 
             {
                 lb01.setText("See No Evil");
             }
             
         });
         
         cb2 = new JCheckBox("Kikazaru");
         cb2.addActionListener(new ActionListener()
         {
             @Override
             public void actionPerformed(ActionEvent ae) 
             {
                 lb02.setText("Hear No Evil");
             }
             
         });
         
         cb3 = new JCheckBox("Iwazaru");
         cb3.addActionListener(new ActionListener()
         {
             @Override
             public void actionPerformed(ActionEvent ae) 
             {
                 lb03.setText("Speak No Evil");
             }
             
         });
         
         lb01 = new JLabel("");
         lb02 = new JLabel("");
         lb03 = new JLabel("");
         lb04 = new JLabel("");
         
         
         b1 = new JRadioButton("I Believe");
         b1.addActionListener(new ActionListener()
         {
             @Override
             public void actionPerformed(ActionEvent ae) 
             {
                 lb04.setText("Begun your training has Padawan");
             }
             
         });

         b2 = new JRadioButton("I Do Not Believe");
         b2.addActionListener(new ActionListener()
         {
             @Override
             public void actionPerformed(ActionEvent ae) 
             {
                 lb04.setText("I sense much fear in you");
             }
             
         });

         
         bgrp = new ButtonGroup();  // Holds the radio buttons together.
         bgrp.add(b1);
         bgrp.add(b2);
         
         
         p1.add(cb1);
         p1.add(cb2);
         p1.add(cb3);
         p2.add(lb01);
         p2.add(lb02);
         p2.add(lb03);
         p3.add(lb04);
         p4.add(b1);
         p4.add(b2);
  
         
         add(p1, BorderLayout.NORTH);
         add(p2, BorderLayout.CENTER);
         add(p3, BorderLayout.BEFORE_LINE_BEGINS);
         add(p4, BorderLayout.SOUTH);
     }

}
