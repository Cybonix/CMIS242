/**
 * @author Joseph Mark Orimoloye
 * 05 May 2018
 * Class that generates each student object.
 */

public class Student 
{
    private String studentName;
    private String major;
    private int credits;
    private int qualityPoints;
    private boolean isCompleted = false;
    
    // Student constructor
    public Student(String studentName, String major)
    {
        this.studentName = studentName;
        this.major = major;
        credits = 0;
        qualityPoints = 0;
    }
    
    public void courseCompleted(String courseGrade, int creditHours)
    {
        int grade = 0;
        if (null != courseGrade) switch (courseGrade)
        {
            case "A":
                grade = 4;
                break;
            case "B":
                grade = 3;
                break;
            case "C":
                grade = 2;
                break;
            case "D&":
                grade = 1;
                break;
            default:
                break;
        }
        
        credits += creditHours;
        qualityPoints += (grade * creditHours);
        isCompleted = true;
    }
    
    public String toString()
    {
        if (!isCompleted)
        {
            return "Name: " + studentName + ", Major: " + major + ", GPA: 4.0";
        }
        double gpa = (qualityPoints / credits);
        return "Name: " + studentName + ", Major: " + major + ", GPA: " + gpa;
    }
}