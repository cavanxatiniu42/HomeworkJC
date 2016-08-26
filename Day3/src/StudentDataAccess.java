import java.io.*;
import java.util.List;
import java.util.function.Function;

public class StudentDataAccess {
    public StudentDataAccess() throws IOException {
    }
    public  void writeToBinaryFile(List<Student> studentList, String path) throws IOException {
        File studentData = new File(path);
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(studentData));
        try {
            outputStream.writeObject(studentList);
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {

                    outputStream.close();
        }
        }

//
     public static List<Student> readFromBinaryFile(String path) throws IOException, ClassNotFoundException {
         File studentData = new File(path);
         ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(studentData)));

         List<Student> studentList = (List<Student>)inputStream.readObject();
         return studentList;
     }
     public static void writeToTextFile(List<Student> studentList, String path) throws IOException {
         File studentData = new File(path);
         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(studentData));
         try {
             bufferedWriter.write(studentList.toString());
         }catch (IOException e){
             e.printStackTrace();
         }
         finally {
             bufferedWriter.close();
         }
     }
     public static List<Student> readFromTextFile (String path) throws FileNotFoundException {
         File studentData = new File(path);
         BufferedReader bufferedReader = new BufferedReader(new FileReader(studentData));
         try {
             List<Student> studentList = (List<Student>) bufferedReader.readLine();
         } catch (IOException e) {
             e.printStackTrace();
         }
         return
     }

    }

