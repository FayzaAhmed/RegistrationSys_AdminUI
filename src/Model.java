import java.io.*;
import java.util.ArrayList;

public class Model
{
    public static String readFolderPath;
    public static String databaseFilePath;


    public static ArrayList<String> getFilesInPath(String path)
    {
        File folder = new File(path);
        ArrayList<String> files = new ArrayList<>();

        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++)
            if (listOfFiles[i].isFile())
                files.add(listOfFiles[i].getName());
        return files;
    }
    public static void storeStudent(Student student) throws IOException
    {
        File file = new File(databaseFilePath);
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        br.write(String.valueOf(student)+"\n");

        br.close();
        fr.close();
    }

    public static ArrayList<Student> readBatch(String fileName)
    {
        ArrayList<Student> students = new ArrayList<>();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(databaseFilePath+"/"+fileName));
            String line = reader.readLine();

            while (line != null)
            {
                Student student = new Student(line);
                students.add(student);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}