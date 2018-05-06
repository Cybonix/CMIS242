import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;

/**
 * @author Joseph Mark Orimoloye
 * 05 May 2018
 * GUI interface and main application for the student database program
 */
public class GUI extends JFrame implements ActionListener 
{

    private String[] operationComboBoxChoices = {"Insert", "Delete", "Update", "Find"};
    private JComboBox operationTypesComboBox = new JComboBox(operationComboBoxChoices);
    private JButton processButton = new JButton("Process Request");
    private JTextField nameField = new JTextField();
    private JTextField idField = new JTextField();
    private JTextField majorField = new JTextField();
    private HashMap<String, Student> resultMap = new HashMap<String, Student>();

    public GUI() 
    {
        super("Student Record Database");
        setLayout(new GridLayout(0, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        operationTypesComboBox.addActionListener(this);
        add(new JLabel("Id: "));
        add(idField);
        add(new JLabel("Name: "));
        add(nameField);
        add(new JLabel("Major: "));
        add(majorField);
        add(new JLabel("Choose Selection: "));
        add(operationTypesComboBox);
        add(processButton);
        processButton.addActionListener(this);
        setBoxes(true, true, true);
        pack();
        setVisible(true);
        setSize(400,200);
    }

    void setBoxes(boolean id, boolean name, boolean major) 
    {
        idField.setEditable(id);
        nameField.setEditable(name);
        majorField.setEditable(major);
        if (!id) 
        {
            idField.setText("");
        }
        
        if (!name) 
        {
            nameField.setText("");
        }
        
        if (!major) 
        {
            majorField.setText("");
        }
    }

    public static void main(String[] args) 
    {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        int command = operationTypesComboBox.getSelectedIndex();
        
        if (e.getSource() == operationTypesComboBox) 
        {
            if (command == 0) 
            {
                setBoxes(true, true, true);
            } 
            else 
            {
                setBoxes(true, false, false);
            }
        } 
        else if (e.getSource() == processButton) 
        {
            String strId = getSafeString(idField.getText());
            
            if (strId.length() == 0) 
            {
                displayMessage("Enter idField");
                return;
            }
            if (command == 0) 
            {
                if (resultMap.containsKey(strId)) 
                {
                    displayMessage("Student with this idField already added in database.");
                    return;
                }
                
                String strName = getSafeString(nameField.getText());
                String strMajor = getSafeString(majorField.getText());
                
                if (strName.length() == 0) 
                {
                    displayMessage("Enter nameField");
                    return;
                }
                if (strMajor.length() == 0) 
                {
                    displayMessage("Enter Major");
                    return;
                }
                
                resultMap.put(strId, new Student(strName, strMajor));
                displayMessage("Student information added");
            } 
            else 
            {
                if (!resultMap.containsKey(strId)) 
                {
                    displayMessage("Student idField not found in database.");
                    return;
                }
                if (command == 1) 
                {
                    Student s = resultMap.get(strId);
                    resultMap.remove(strId);
                    displayMessage("Student deleted: " + s.toString());
                } 
                else if (command == 3) 
                {
                    Student s = resultMap.get(strId);
                    displayMessage("Student found: " + s.toString());
                } 
                else if (command == 2) 
                {
                    String[] choices = {"A", "B", "C", "D", "E", "F"};
                    String grade = (String) JOptionPane.showInputDialog(null, "Choose grade: ",
                            "Choose grade", JOptionPane.QUESTION_MESSAGE, null,
                            choices, choices[0]);
                    choices = new String[]{"3", "6"};
                    int credits = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Choose credits: ",
                            "Choose credits", JOptionPane.QUESTION_MESSAGE, null,
                            choices, choices[0]));
                    Student s = resultMap.get(strId);
                    s.courseCompleted(grade, credits);
                    displayMessage("Student information updated: " + s.toString());
                }
            }
        }
    }

    // Method to display message
    public void displayMessage(String s) 
    {
        JOptionPane.showMessageDialog(null, s);
    }

    // Method to return blank string if null
    public String getSafeString(String s) 
    {
        if (s == null) 
        {
            return s;
        }
        return s.trim();
    }

    // Method to recieve non-negative numeric input from user
    public int getIntUsingPane(String msg) 
    {
        int num = 0;
        boolean good = true;
        do {
            good = true;
            try {
                num = Integer.parseInt(JOptionPane.showInputDialog(msg));
                if (num <= 0) 
                {
                    good = false;
                    displayMessage("Enter positive numeric value");
                }
            } catch (Exception e) 
            {
                good = false;
                displayMessage("Enter positive numeric value");
            }
        } 
        while (!good);
        return num;
    }
}