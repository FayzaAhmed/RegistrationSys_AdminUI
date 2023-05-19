import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void printStudentsStat()
    {
        ArrayList<Student> students = Model.readBatch("db.csv");
        System.out.println("Number of users: "+students.size());

        HashMap<String, Integer> courses = new HashMap<>();
        for(Student student:students)
        {
            for(String course : student.courses)
            {
                if(!courses.containsKey(course))
                    courses.put(course, 0);

                courses.put(course, courses.get(course)+1);
            }
        }
        for (Map.Entry<String, Integer> entry : courses.entrySet())
        {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Number of students registered in " + key + " course: " + value);
        }
    }
    public static void printNumberOfFiles()
    {
        ArrayList<String> files = Model.getFilesInPath(Model.readFolderPath);
        int filesNumber = files.size();
        System.out.println("Number of batch files: "+filesNumber);
    }
    public static void printNumberOfVerifiedFiles()
    {
        ArrayList<String> fileNames = Model.getFilesInPath(Model.readFolderPath);
        fileNames = (ArrayList<String>) fileNames.stream().filter(s -> s.contains("verified")).collect(Collectors.toList());
        int verifiedNumber = fileNames.size();
        System.out.println("Number of verified batch files: "+verifiedNumber);
    }
    public static void main(String[] args) {
        Model.databaseFilePath = "app/data/database";
        Model.readFolderPath = "app/data/batch/";
        printStudentsStat();
        printNumberOfFiles();
        printNumberOfVerifiedFiles();
    }
}
