import java.util.ArrayList;
import java.util.Arrays;

public class Student
{
    public static char separator = ';';
    public String name;
    public String ID;
    public ArrayList<String> courses;

    public Student(String name, String ID, ArrayList<String> courses)
    {
        this.name = name;
        this.ID = ID;
        this.courses = courses;
    }

    public Student(String str)
    {
        String[] arr = str.split(String.valueOf(separator), 15);
        this.name = arr[0];
        this.ID   = arr[1];
        this.courses = new ArrayList<>(Arrays.asList(arr[2].split(",", 15)));
    }

    public String toString()
    {
        String coursesStr = "";
        for(int i =0; i<courses.size()-1; ++i)
            coursesStr+= courses.get(i) +",";
        coursesStr+= courses.get(courses.size() - 1);
        return this.name + separator + this.ID + separator + coursesStr;
    }
}