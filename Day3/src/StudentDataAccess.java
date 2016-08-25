import java.io.*;
import java.util.List;

public class StudentDataAccess {
    public StudentDataAccess() throws IOException {
    }
    public static void writeToBinaryFile(List<Student> studentList, String path) throws IOException {
        File studentData = new File(path);
        FileOutputStream outputStream = new FileOutputStream(studentData);
        try {
            byte[] data = studentList.toString().getBytes();
            outputStream.write(data,0,studentList.size());
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
           if (outputStream != null){
                    outputStream.close();
                }
        }
        }


     public static List<Student> readFromBinaryFile(String path) throws FileNotFoundException {
         File studentData = new File(path);
         FileInputStream inputStream = new FileInputStream(studentData);
         try {

         } catch (IOException e) {
             e.printStackTrace();
         }
        return 
     }
    }

